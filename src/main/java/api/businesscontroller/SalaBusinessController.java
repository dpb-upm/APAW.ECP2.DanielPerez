package api.businesscontroller;

import api.daos.DaoFactory;
import api.dtos.SalaDto;
import api.entities.Sala;

public class SalaBusinessController {

    public String create(SalaDto salaDto) {
        Sala sala = new Sala(salaDto.getNombre(), salaDto.getCapacidad());
        DaoFactory.getFactory().getSalaDAO().save(sala);
        return sala.getId();
    }

    public void update(String idEntity, String newId) {
        DaoFactory.getFactory().getSalaDAO().update(idEntity, newId);
    }
}
