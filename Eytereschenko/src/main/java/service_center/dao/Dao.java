package service_center.dao;

public interface Dao<T> {
    boolean create(T T);
    T read(String id);
    boolean update(T updatedT);
    T delete(String id);
    T[] all();
}