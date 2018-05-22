package week2.mvc.dao;


/**
 * Created by serhii on 13.05.18.
 */
public interface Dao<T> {
    boolean create(T T);
    T read(String id);
    boolean update(T updatedT);
    T delete(String id);
    T[] all();
}
