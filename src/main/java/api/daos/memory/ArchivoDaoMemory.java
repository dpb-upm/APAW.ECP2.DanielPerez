package api.daos.memory;

import api.daos.ArchivoDAO;
import api.entities.Archivo;

public class ArchivoDaoMemory extends GenericDaoMemory<Archivo> implements ArchivoDAO {

    @Override
    public String getId(Archivo entity) {
        return entity.getId();
    }

    @Override
    public void setId(Archivo entity, String id) {
        entity.setId(id);
    }
}
