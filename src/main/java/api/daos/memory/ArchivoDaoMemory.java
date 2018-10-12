package api.daos.memory;

import api.daos.ArchivoDao;
import api.entities.Archivo;

public class ArchivoDaoMemory extends GenericDaoMemory<Archivo> implements ArchivoDao {

    @Override
    public String getId(Archivo entity) {
        return entity.getId();
    }

    @Override
    public void setId(Archivo entity, String id) {
        entity.setId(id);
    }
}
