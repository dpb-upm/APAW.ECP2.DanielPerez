package api.controllers;

import api.businesscontroller.ArchivoBusinessController;
import api.dtos.ArchivoDto;
import api.exceptions.ArgumentNotValidException;

public class ArchivoApiController {

    private static final String ARCHIVO = "/archivo";

    private ArchivoBusinessController archivoBusinessController = new ArchivoBusinessController();

    public String create(ArchivoDto archivoDto){
        validate(archivoDto.getTamanio(), "archivoDto tamaño");
        validate(archivoDto.getDescripcion(), "archivoDto descripcion");
        return this.archivoBusinessController.create(archivoDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }
}
