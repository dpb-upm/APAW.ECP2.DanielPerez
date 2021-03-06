package api.daos.memory;

import api.daos.GenericDao;
import org.apache.logging.log4j.LogManager;

import java.util.*;

public abstract class GenericDaoMemory<T> implements GenericDao<T, String> {

    private Map<String, T> map;

    private int id;

    GenericDaoMemory() {
        this.map = new HashMap<>();
        this.id = 1;
    }

    @Override
    public void save(T entity) {
        String idEntity = this.getIdT(entity);
        if (idEntity == null || idEntity.isEmpty()) {
            idEntity = String.valueOf(this.id);
            this.setIdT(entity, idEntity);
        }
        if (!this.map.containsKey(id)) {
            this.map.put(String.valueOf(this.id), entity);
            this.id++;
            LogManager.getLogger(this.getClass()).debug("   save: " + entity);
        } else {
            LogManager.getLogger(this.getClass()).error("La entidad ya existe en el índice");
        }
    }

    @Override
    public T getEntity(String id){
        return map.get(id);
    }

    @Override
    public Optional<T> read(String id) {
        T entity = map.get(id);
        LogManager.getLogger(this.getClass()).debug("   read(" + id + "): " + entity);
        return Optional.ofNullable(entity);
    }

    @Override
    public void deleteById(String id) {
        map.remove(id);
        LogManager.getLogger(this.getClass()).debug("   deleteById(" + id + "): ¿Existe id?" + map.containsKey(id));
    }

    @Override
    public List<T> findAll() {
        ArrayList<T> list = new ArrayList<>(map.values());
        LogManager.getLogger(this.getClass()).debug("   findAll: " + list);
        return list;
    }

    @Override
    public void update(String idEntity, String newId){
        T entity = this.getEntity(idEntity);
        this.setIdT(entity, newId);
        this.map.put(newId, map.get(idEntity));
        this.map.remove(idEntity);
    }

    public abstract String getIdT(T entity);

    public abstract void setIdT(T entity, String id);

    public int total(){
        return this.map.size();
    }
}
