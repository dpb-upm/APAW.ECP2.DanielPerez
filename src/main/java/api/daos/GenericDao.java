package api.daos;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T, String> {

    void save(T entity);

    T getEntity(String id);

    Optional<T> read(String id);

    void deleteById(String id);

    List<T> findAll();
}
