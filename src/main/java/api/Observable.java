package api;

import java.util.HashSet;
import java.util.Set;

public class Observable<T> {

    private Set<Observer<T>> observers = new HashSet<>();

    public void addObserver(Observer observador) {
        this.observers.add(observador);
    }

    public void removeObserver(Observer observador) {
        this.observers.remove(observador);
    }

    public void notifyObservers(T object){
        for (Observer<T> observer : observers) {
            observer.update(object);
        }
    }
}
