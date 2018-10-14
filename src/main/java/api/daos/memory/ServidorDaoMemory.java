package api.daos.memory;

import api.daos.ServidorDao;
import api.entities.Servidor;

public class ServidorDaoMemory extends GenericDaoMemory<Servidor> implements ServidorDao {

    @Override
    public String getIdT(Servidor servidor) {
        return servidor.getId();
    }

    @Override
    public void setIdT(Servidor servidor, String id) {
        servidor.setId(id);
    }
}
