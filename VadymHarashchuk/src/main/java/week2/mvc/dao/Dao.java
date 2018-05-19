package week2.mvc.dao;

public interface Dao<T> {
    boolean create(T T);
    T read(String id);
    boolean update(T T);
    T delete(int id);
    T[] all();
}
