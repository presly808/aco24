package week3.mvc.dao;

import week3.mvc.controller.ServiceFactory;
import week3.mvc.db.DataBase;
import week3.mvc.model.human.User;
import week3.mvc.model.repair.Ticket;

import java.util.List;

public class UserDaoImpl implements UserDao {

    DataBase database;


    public UserDaoImpl() {
        database = (DataBase) ServiceFactory.get("database");
    }


    public boolean createUser(User user) {

        return database.getUsers().add(user);

    }

    public List<User> getAllUsers() {

        return database.getUsers();
    }

    public User updateUser(User user, String phone, List<Ticket> tickets) {

        int index = database.getUsers().indexOf(user);

        user.setPhoneNumber(phone);
        user.setTickets(tickets);

        return database.getUsers().set(index, user);
    }

    public boolean deleteUser(User user) throws Exception {

        if (database.getUsers().indexOf(user) >= 0)
            return database.getUsers().remove(user);

        throw new Exception("There is no such user in database");

    }

}
