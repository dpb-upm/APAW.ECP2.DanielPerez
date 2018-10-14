package api.controllers;

import api.businesscontroller.SalaBusinessController;
import api.dtos.SalaDto;

public class SalaApiController extends ApiController {

    public static final String SALA = "/sala" ;
    public static final String ID_ID  = "/{id}";
    public static final String PUT_SALA = SALA + ID_ID;

    SalaBusinessController salaBusinessController = new SalaBusinessController();

    public String create(SalaDto salaDto){
        validate(salaDto.getNombre(), "salaDto nombre");
        validate(salaDto.getCapacidad(), "salaDto capacidad");
        return this.salaBusinessController.create(salaDto);
    }

    public void update(String id, String newId){
        validate(id, "id update salaApi");
        validate(newId, "newId salaApi");
        this.salaBusinessController.update(id, newId);
    }
}
