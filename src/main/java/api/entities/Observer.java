package api.entities;

public interface Observer<T> {

    public void update(T object);
}
