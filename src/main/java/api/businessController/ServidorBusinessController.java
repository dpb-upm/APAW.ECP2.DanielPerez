package api.businessController;

import api.daos.DaoFactory;
import api.dtos.ServidorDto;
import api.entities.Servidor;

public class ServidorBusinessController {

    public String create(ServidorDto servidorDto) {
        Servidor servidor = new Servidor(null, servidorDto.getTipo(), servidorDto.getPropietario());
        DaoFactory.getFactory().getServidorDAO().save(servidor);
        return servidor.getId();
    }
}
