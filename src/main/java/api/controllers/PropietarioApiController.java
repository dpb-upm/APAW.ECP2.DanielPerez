package api.controllers;

import api.businesscontroller.PropietarioBusinessController;
import api.dtos.PropietarioDto;
import api.entities.Propietario;
import api.exceptions.ArgumentNotValidException;

import java.util.Optional;

public class PropietarioApiController {

    public static final String ADD_PROPIETARIO_SERVIDOR = "/propietario";
    public static final String GET_PROPIETARIO_SERVIDOR = "/propietario/{id}";
    public static final String ID_ID = "/{id}";
    public static final String PUT_PROPIETARIO_SERVIDOR = ADD_PROPIETARIO_SERVIDOR + ID_ID;

    private PropietarioBusinessController propietarioBusinessController = new PropietarioBusinessController();

    public String create(PropietarioDto propietarioDto){
        validate(propietarioDto.getNombre(), "propietarioDto nombre");
        return this.propietarioBusinessController.create(propietarioDto);
    }

    public Optional<Propietario> read(String id){
        validate(id, "id propietarioApi");
        return this.propietarioBusinessController.read(id);
    }

    public void update(String id, String newId){
        validate(id, "id propietarioApi");
        validate(newId, "newId propietarioApi");
        this.propietarioBusinessController.update(id, newId);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }
}
