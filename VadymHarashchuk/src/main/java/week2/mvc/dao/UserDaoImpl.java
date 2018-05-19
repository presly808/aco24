package week2.mvc.dao;

import week2.mvc.model.User;
import week2.mvc.server.ObjectHolder;

import java.util.HashMap;


public class UserDaoImpl implements Dao<User> {

    private DbContainer container = (DbContainer) ObjectHolder.getBean("db");

    public UserDaoImpl() {
        container.userMap = new HashMap<>();
    }

    public boolean create(User user) {
      //  container.userMap.put(user.getId(), user);
        return true;
    }

    public User read(String id) {
        return container.userMap.get(id);
    }

    public boolean update(User user) {
     //   container.userMap.put(user.getId(), user);
        return true;
    }

    public User delete(int id) {
        return null;
    }

    public User[] all() {
        return new User[0];
    }
}
