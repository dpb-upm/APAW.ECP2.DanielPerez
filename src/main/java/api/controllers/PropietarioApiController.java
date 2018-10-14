package api.controllers;

import api.businesscontroller.PropietarioBusinessController;
import api.dtos.PropietarioDto;
import api.exceptions.ArgumentNotValidException;

public class PropietarioApiController {

    public static final String ADD_PROPIETARIO_SERVIDOR = "/propietario";

    private PropietarioBusinessController propietarioBusinessController = new PropietarioBusinessController();

    public String create(PropietarioDto propietarioDto){
        validate(propietarioDto.getNombre(), "propietarioDto nombre");
        return this.propietarioBusinessController.create(propietarioDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }
}
