package api.controllers;

import api.businesscontroller.ServidorBusinessController;
import api.dtos.ServidorDto;
import api.entities.TipoServidor;
import api.exceptions.ArgumentNotValidException;

public class ServidorApiController {

    public static final String ADD_SERVIDOR = "/servidor";
    public static final String ID_ID = "/{id}";
    public static final String TIPO_SERVIDOR = "/tipo";
    public static final String PATCH_SERVIDOR = ADD_SERVIDOR + ID_ID + TIPO_SERVIDOR;

    private final ServidorBusinessController servidorBusinessController = new ServidorBusinessController();

    public String create(ServidorDto servidorDto) {
        validate(servidorDto.getTipo(), "servidorDto tipo");
        return this.servidorBusinessController.create(servidorDto);
    }

    public void updateTipoServidor(String id, TipoServidor tipo){
        validate(id, "id ServidorApi");
        validate(tipo, "tipo ServidorApi");
        this.servidorBusinessController.updateTipoServidor(id, tipo);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }
}
