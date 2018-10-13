package api.daos;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T, t> {

    void save(T entity);

    T getEntity(t id);

    Optional<T> read(t id);

    void deleteById(t id);

    List<T> findAll();

    int total();
}
