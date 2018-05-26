package week3.mvc.dao;

import week3.mvc.model.repair.Ticket;

import java.util.List;

public interface Dao<T> {

    boolean create(T t);

    List<T> find(String key);

    List<T> getAll();

    T update(T user, String phone, List<Ticket> tickets, double...salary);

    boolean delete(T t) throws Exception;

}
