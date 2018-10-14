package api.daos;

import api.entities.Archivo;

public interface ArchivoDao extends GenericDao<Archivo, String> {

    int findGreaterThan(Double value);
}
