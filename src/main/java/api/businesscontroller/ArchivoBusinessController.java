package api.businesscontroller;

import api.daos.DaoFactory;
import api.dtos.ArchivoDto;
import api.entities.Archivo;

import java.util.List;

public class ArchivoBusinessController {

    public String create(ArchivoDto archivoDto) {
        Archivo archivo = new Archivo(archivoDto.getTamanio(), archivoDto.getDescripcion());
        DaoFactory.getFactory().getArchivoDAO().save(archivo);
        return archivo.getId();
    }

    public float findGreaterThan(Double value) {
        return DaoFactory.getFactory().getArchivoDAO().findGreaterThan(value);
    }

    public List<Archivo> readAll() {
        return DaoFactory.getFactory().getArchivoDAO().findAll();
    }
}
