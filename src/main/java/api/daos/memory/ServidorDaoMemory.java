package api.daos.memory;

import api.daos.ServidorDao;
import api.entities.Servidor;

public class ServidorDaoMemory extends GenericDaoMemory<Servidor> implements ServidorDao {

    @Override
    public String getId(Servidor entity) {
        return entity.getId();
    }

    @Override
    public void setId(Servidor entity, String id) {
        entity.setId(id);
    }
}
