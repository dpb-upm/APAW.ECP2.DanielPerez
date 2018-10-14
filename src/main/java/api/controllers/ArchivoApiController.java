package api.controllers;

import api.businesscontroller.ArchivoBusinessController;
import api.dtos.ArchivoDto;
import api.entities.Archivo;
import api.exceptions.ArgumentNotValidException;

import java.util.List;

public class ArchivoApiController {

    public static final String ARCHIVO = "/archivo";

    private ArchivoBusinessController archivoBusinessController = new ArchivoBusinessController();

    public String create(ArchivoDto archivoDto){
        validate(archivoDto.getTamanio(), "archivoDto tamaño");
        validate(archivoDto.getDescripcion(), "archivoDto descripcion");
        return this.archivoBusinessController.create(archivoDto);
    }

    public List<Archivo> readAll() {
        return this.archivoBusinessController.readAll();
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }
}
