package api;

import api.controllers.ArchivoApiController;
import api.controllers.PropietarioApiController;
import api.controllers.SalaApiController;
import api.controllers.ServidorApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoFactoryMemory;
import api.dtos.ArchivoDto;
import api.dtos.PropietarioDto;
import api.dtos.SalaDto;
import api.dtos.ServidorDto;
import api.entities.TipoServidor;
import api.exceptions.ArgumentNotValidException;
import api.exceptions.NotFoundException;
import api.exceptions.RequestInvalidException;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;
import org.apache.logging.log4j.LogManager;

public class Dispatcher {

    private final ArchivoApiController archivoApiController = new ArchivoApiController();
    private final ServidorApiController servidorApiController = new ServidorApiController();
    private final PropietarioApiController propietarioApiController = new PropietarioApiController();
    private final SalaApiController salaApiController = new SalaApiController();

    private static final String METHODERROR = "method error: ";
    private static final String REQUESTERROR = "request error: ";

    static {
        DaoFactory.setFactory(new DaoFactoryMemory());
        LogManager.getLogger(Dispatcher.class).debug("   create DaoFactoryMemory");
    }

    public void submit(HttpRequest request, HttpResponse response) {
        String errorMessage = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:
                    this.doPost(request, response);
                    break;
                case GET:
                    this.doGet(request, response);
                    break;
                case PUT:
                    this.doPut(request);
                    break;
                case PATCH:
                    this.doPatch(request);
                    break;
                case DELETE:
                    this.doDelete(request);
                    break;
                default: // Unexpected
                    throw new RequestInvalidException(METHODERROR + request.getMethod());
            }
        } catch (ArgumentNotValidException | RequestInvalidException exception) {
            response.setBody(String.format(errorMessage, exception.getMessage()));
            response.setStatus(HttpStatus.BAD_REQUEST);
        } catch (NotFoundException exception) {
            response.setBody(String.format(errorMessage, exception.getMessage()));
            response.setStatus(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {  // Unexpected
            LogManager.getLogger(Dispatcher.class).debug(exception.getMessage());
            response.setBody(String.format(errorMessage, exception));
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void doDelete(HttpRequest request) {
        if (request.isEqualsPath(PropietarioApiController.DELETE_PROPIETARIO_SERVIDOR)) {
            this.propietarioApiController.delete(request.getPath(1));
        } else {
            throw new RequestInvalidException(REQUESTERROR + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doGet(HttpRequest request, HttpResponse response) {
        if(request.isEqualsPath(ArchivoApiController.ARCHIVO + ArchivoApiController.BUSCAR_POR_TAMANIO)){
            response.setBody(this.archivoApiController.findGreaterThan(request.getParams().get("q")));
        } else if (request.isEqualsPath(ArchivoApiController.ARCHIVO)){
            response.setBody(this.archivoApiController.readAll());
        } else if (request.isEqualsPath(PropietarioApiController.GET_PROPIETARIO_SERVIDOR)) {
            response.setBody(this.propietarioApiController.read((String) request.getBody()));
        } else {
            throw new RequestInvalidException(METHODERROR + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doPatch(HttpRequest request) {
        if (request.isEqualsPath(ServidorApiController.PATCH_SERVIDOR)) {
            this.servidorApiController.updateTipoServidor(request.getPath(1), (TipoServidor) request.getBody());
        } else {
            throw new RequestInvalidException(REQUESTERROR + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(ArchivoApiController.ARCHIVO)){
            response.setBody(archivoApiController.create((ArchivoDto) request.getBody()));
        } else if(request.isEqualsPath(ServidorApiController.ADD_SERVIDOR)) {
            response.setBody(servidorApiController.create((ServidorDto) request.getBody()));
        } else if(request.isEqualsPath(PropietarioApiController.ADD_PROPIETARIO_SERVIDOR)) {
            response.setBody(propietarioApiController.create((PropietarioDto) request.getBody()));
        } else if (request.isEqualsPath(SalaApiController.SALA)){
            response.setBody(salaApiController.create((SalaDto) request.getBody()));
        } else {
            throw new RequestInvalidException(METHODERROR + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doPut(HttpRequest request) {
        if (request.isEqualsPath(SalaApiController.PUT_SALA)) {
            this.salaApiController.update(request.getPath(1), (String) request.getBody());
        } else if (request.isEqualsPath(PropietarioApiController.PUT_PROPIETARIO_SERVIDOR)) {
            this.propietarioApiController.update(request.getPath(1), (String) request.getBody());
        } else {
            throw new RequestInvalidException(REQUESTERROR + request.getMethod() + ' ' + request.getPath());
        }
    }
}
