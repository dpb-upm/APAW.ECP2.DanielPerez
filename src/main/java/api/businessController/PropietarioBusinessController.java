package api.businessController;

import api.daos.DaoFactory;
import api.dtos.PropietarioDto;
import api.entities.Propietario;

public class PropietarioBusinessController {

    public String create(PropietarioDto propietarioDto) {
        Propietario propietario = new Propietario(propietarioDto.getNombre(), propietarioDto.getEdad(), propietarioDto.getNacimiento());
        DaoFactory.getFactory().getPropietarioDAO().save(propietario);
        return propietario.getId();
    }
}
