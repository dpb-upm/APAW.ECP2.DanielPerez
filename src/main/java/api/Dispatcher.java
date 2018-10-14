package api;

import api.controllers.PropietarioApiController;
import api.controllers.ServidorApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoFactoryMemory;
import api.dtos.PropietarioDto;
import api.dtos.ServidorDto;
import api.exceptions.ArgumentNotValidException;
import api.exceptions.NotFoundException;
import api.exceptions.RequestInvalidException;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;
import org.apache.logging.log4j.LogManager;

public class Dispatcher {

    private final ServidorApiController servidorApiController = new ServidorApiController();
    private final PropietarioApiController propietarioApiController = new PropietarioApiController();

    static {
        DaoFactory.setFactory(new DaoFactoryMemory());
        LogManager.getLogger(Dispatcher.class).debug("   create DaoFactoryMemory");
    }

    public void submit(HttpRequest request, HttpResponse response) {
        String ERROR_MESSAGE = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:
                    this.doPost(request, response);
                    break;
                case GET:
                    break;
                case PUT:
                    break;
                case PATCH:
                    break;
                case DELETE:
                    break;
                default: // Unexpected
                    throw new RequestInvalidException("method error: " + request.getMethod());
            }
        } catch (ArgumentNotValidException | RequestInvalidException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.BAD_REQUEST);
        } catch (NotFoundException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {  // Unexpected
            exception.printStackTrace();
            response.setBody(String.format(ERROR_MESSAGE, exception));
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        if(request.isEqualsPath(ServidorApiController.ADD_SERVIDOR)) {
            response.setBody(servidorApiController.create((ServidorDto) request.getBody()));
        } else if(request.isEqualsPath(PropietarioApiController.ADD_PROPIETARIO_SERVIDOR)){
            response.setBody(propietarioApiController.create((PropietarioDto) request.getBody()));
        } else {
            throw new RequestInvalidException("method error: " + request.getMethod() + ' ' + request.getPath());
        }
    }
}
