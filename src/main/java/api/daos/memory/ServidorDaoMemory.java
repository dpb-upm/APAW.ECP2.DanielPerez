package api.daos.memory;

import api.daos.ServidorDAO;
import api.entities.Servidor;

public class ServidorDaoMemory extends GenericDaoMemory<Servidor> implements ServidorDAO {

    @Override
    public String getId(Servidor entity) {
        return entity.getId();
    }

    @Override
    public void setId(Servidor entity, String id) {
        entity.setId(id);
    }
}
