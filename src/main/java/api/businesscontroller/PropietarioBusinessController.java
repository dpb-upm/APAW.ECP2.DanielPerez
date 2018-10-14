package api.businesscontroller;

import api.daos.DaoFactory;
import api.dtos.PropietarioDto;
import api.entities.Propietario;
import api.entities.Servidor;

import java.util.Optional;

public class PropietarioBusinessController {

    public String create(PropietarioDto propietarioDto) {
        Propietario propietario = new Propietario(propietarioDto.getNombre(), propietarioDto.getEdad(), propietarioDto.getNacimiento());
        DaoFactory.getFactory().getPropietarioDAO().save(propietario);
        return propietario.getId();
    }

    public Optional<Servidor> read(String id) {
        return DaoFactory.getFactory().getServidorDAO().read(id);
    }
}
