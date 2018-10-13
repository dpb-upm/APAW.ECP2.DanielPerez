package api.daos.memory;

import api.daos.PropietarioDao;
import api.entities.Propietario;

public class PropietarioDaoMemory extends GenericDaoMemory<Propietario> implements PropietarioDao {
    
    @Override
    public String getIdT(Propietario propietario) {
        return propietario.getId();
    }

    @Override
    public void setIdT(Propietario propietario, String id) {
        propietario.setId(id);
    }
}
