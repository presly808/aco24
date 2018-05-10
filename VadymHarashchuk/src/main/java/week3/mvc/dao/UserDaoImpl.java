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

        return database.addUser(user);

    }

    public List<User> findUsers(String key) {
        return database.findUsers(key);
    }

    public boolean createUsers(List<User> users) {

        return database.addUsers(users);

    }



    public List<User> getAllUsers() {

        return database.getAllUsers();
    }

    public User updateUser(User user, String phone, List<Ticket> tickets) {

        int index = database.getAllUsers().indexOf(user);

        user.setPhoneNumber(phone);
        user.setTickets(tickets);

        return database.getAllUsers().set(index, user);
    }

    public boolean deleteUser(User user) throws Exception {

        if (database.getAllUsers().indexOf(user) >= 0)
            return database.getAllUsers().remove(user);

        throw new Exception("There is no such user in database");

    }

}
