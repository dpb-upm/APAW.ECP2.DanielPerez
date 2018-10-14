package api.controllers;

import api.businesscontroller.ServidorBusinessController;
import api.dtos.ServidorDto;
import api.exceptions.ArgumentNotValidException;

public class ServidorApiController {

    public static final String ADD_SERVIDOR = "/servidor";

    private final ServidorBusinessController servidorBusinessController = new ServidorBusinessController();

    public String create(ServidorDto servidorDto) {
        validate(servidorDto.getTipo(), "servidorDto tipo");
        return this.servidorBusinessController.create(servidorDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }
}
