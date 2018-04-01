package patterns.observer;

/**
 * Created by serhii on 31.03.18.
 */
public interface MyObservable {


    void addObserver(MyObserver observer);
    void removeObserver(MyObserver observer);
    void notifyObservers(Object value);


}
