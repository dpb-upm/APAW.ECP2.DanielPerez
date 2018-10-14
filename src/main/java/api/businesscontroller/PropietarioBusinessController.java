package api.businesscontroller;

import api.daos.DaoFactory;
import api.dtos.PropietarioDto;
import api.entities.Propietario;

import java.util.Optional;

public class PropietarioBusinessController {

    public String create(PropietarioDto propietarioDto) {
        Propietario propietario = new Propietario(propietarioDto.getNombre(), propietarioDto.getEdad(), propietarioDto.getNacimiento());
        DaoFactory.getFactory().getPropietarioDAO().save(propietario);
        return propietario.getId();
    }

    public void delete(String id){
        DaoFactory.getFactory().getPropietarioDAO().deleteById(id);
    }

    public Optional<Propietario> read(String id) {
        return DaoFactory.getFactory().getPropietarioDAO().read(id);
    }

    public void update(String idEntity, String newId) {
        DaoFactory.getFactory().getPropietarioDAO().update(idEntity, newId);
    }
}
