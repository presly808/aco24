package week3.mvc.dao;

import week3.mvc.model.human.User;
import week3.mvc.model.repair.Ticket;

import java.util.List;

public interface UserDao {

    boolean createUser(User user);

    List<User> getAllUsers();

    User updateUser(User user, String phone, List<Ticket> tickets);

    boolean deleteUser(User user) throws Exception;
}
