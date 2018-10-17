package api.businesscontroller;

import api.daos.DaoFactory;
import api.dtos.ServidorDto;
import api.entities.Servidor;
import api.entities.TipoServidor;
import api.exceptions.NotFoundException;

public class ServidorBusinessController {

    public String create(ServidorDto servidorDto) {
        Servidor servidor = new Servidor(null, servidorDto.getTipo(), servidorDto.getPropietario());
        DaoFactory.getFactory().getServidorDAO().save(servidor);
        return servidor.getId();
    }

    public void updateTipoServidor(String id, TipoServidor tipo){
        Servidor servidor = DaoFactory.getFactory().getServidorDAO().read(id)
                .orElseThrow(() -> new NotFoundException("Servidor ("+id+")"));
        servidor.setTipo(tipo);
        DaoFactory.getFactory().getServidorDAO().save(servidor);
    }
}
