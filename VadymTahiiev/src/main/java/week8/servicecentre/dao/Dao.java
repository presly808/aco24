package week8.servicecentre.dao;

public interface Dao<T> {

    public boolean create(T t) throws Exception;

    public T read(T t) throws Exception;

    public boolean update(T updatedT) throws Exception;

    public boolean delete(String id) throws Exception;

}
