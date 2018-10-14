package api.controllers;

import api.businesscontroller.PropietarioBusinessController;
import api.dtos.PropietarioDto;
import api.entities.Servidor;
import api.exceptions.ArgumentNotValidException;

import java.util.Optional;

public class PropietarioApiController {

    public static final String ADD_PROPIETARIO_SERVIDOR = "/propietario";
    public static final String GET_PROPIETARIO_SERVIDOR = "/propietario/{id}";

    private PropietarioBusinessController propietarioBusinessController = new PropietarioBusinessController();

    public String create(PropietarioDto propietarioDto){
        validate(propietarioDto.getNombre(), "propietarioDto nombre");
        return this.propietarioBusinessController.create(propietarioDto);
    }

    public Optional<Servidor> read(String id){
        validate(id, "id propietarioApi");
        return this.propietarioBusinessController.read(id);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }
}
