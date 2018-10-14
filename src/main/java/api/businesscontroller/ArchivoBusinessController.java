package api.businesscontroller;

import api.daos.DaoFactory;
import api.dtos.ArchivoDto;
import api.entities.Archivo;

public class ArchivoBusinessController {

    public String create(ArchivoDto archivoDto) {
        Archivo archivo = new Archivo(archivoDto.getTamanio(), archivoDto.getDescripcion());
        DaoFactory.getFactory().getArchivoDAO().save(archivo);
        return archivo.getId();
    }
}
