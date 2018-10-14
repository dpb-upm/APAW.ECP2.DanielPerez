package api.daos.memory;

import api.daos.ArchivoDao;
import api.entities.Archivo;

import java.util.List;

public class ArchivoDaoMemory extends GenericDaoMemory<Archivo> implements ArchivoDao {

    @Override
    public String getIdT(Archivo archivo) {
        return archivo.getId();
    }

    @Override
    public void setIdT(Archivo archivo, String id) {
        archivo.setId(id);
    }

    @Override
    public int findGreaterThan(Double value) {
        return (int) this.findAll().stream().filter(a -> a.getTamanio() >= value).count();
    }
}
