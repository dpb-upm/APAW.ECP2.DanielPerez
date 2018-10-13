package api.daos.memory;

import api.daos.SalaDao;
import api.entities.Sala;

public class SalaDaoMemory extends GenericDaoMemory<Sala> implements SalaDao {
    @Override
    public String getIdT(Sala sala) {
        return sala.getId();
    }

    @Override
    public void setIdT(Sala sala, String id) {
        sala.setId(id);
    }
}
