package api.daos.memory;

import api.daos.SalaDAO;
import api.entities.Sala;

public class SalaDaoMemory extends GenericDaoMemory<Sala> implements SalaDAO {
    @Override
    public String getId(Sala entity) {
        return entity.getId();
    }

    @Override
    public void setId(Sala entity, String id) {
        entity.setId(id);
    }
}
