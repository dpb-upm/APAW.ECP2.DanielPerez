package api.daos.memory;

import api.daos.PropietarioDAO;
import api.entities.Propietario;

public class PropietarioDaoMemory extends GenericDaoMemory<Propietario> implements PropietarioDAO {
    
    @Override
    public String getId(Propietario entity) {
        return entity.getId();
    }

    @Override
    public void setId(Propietario entity, String id) {
        entity.setId(id);
    }
}
