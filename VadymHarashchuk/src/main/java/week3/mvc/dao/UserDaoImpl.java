package week3.mvc.dao;

import week3.mvc.controller.ServiceFactory;
import week3.mvc.db.DBusers;
import week3.mvc.model.human.User;
import week3.mvc.model.repair.Ticket;

import java.util.List;

public class UserDaoImpl implements Dao<User> {

    DBusers users;


    public UserDaoImpl() {
        users = (DBusers) ServiceFactory.getBean("users");
    }


    public boolean create(User user) {

        return users.addUser(user);

    }

    public List<User> find(String key) {
        return users.findUsers(key);
    }

    public boolean createUsers(List<User> usersList) {

        return users.addUsers(usersList);

    }


    public List<User> getAll() {

        return users.getAllUsers();
    }

    public User update(User user, String phone, List<Ticket> tickets, double...salary) {

        int index = users.getAllUsers().indexOf(user);
        user.setPhoneNumber(phone);
        user.setTickets(tickets);

        return users.getAllUsers().set(index, user);
    }

    public boolean delete(User user) throws Exception {

        if (users.getAllUsers().indexOf(user) >= 0)
            return users.getAllUsers().remove(user);

        throw new Exception("There is no such user in users");

    }

}
