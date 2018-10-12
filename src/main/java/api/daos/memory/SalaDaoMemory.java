package api.daos.memory;

import api.daos.SalaDao;
import api.entities.Sala;

public class SalaDaoMemory extends GenericDaoMemory<Sala> implements SalaDao {
    @Override
    public String getId(Sala entity) {
        return entity.getId();
    }

    @Override
    public void setId(Sala entity, String id) {
        entity.setId(id);
    }
}
