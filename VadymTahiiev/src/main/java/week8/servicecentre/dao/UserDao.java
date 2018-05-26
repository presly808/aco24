package week8.servicecentre.dao;

import week8.servicecentre.model.Ticket;
import week8.servicecentre.model.User;

import java.util.Map;

public class UserDao implements Dao<User> {

    @Override
    public boolean create(User user) throws Exception{
        DB.users.put(user, null);
        return true;
    }

    @Override
    public User read(User user) throws Exception{
        for (Map.Entry<User, Ticket> entry:
                DB.users.entrySet()) {
            if (user.getName().equals(entry.getKey().getName()) &&
                    user.getPassword().equals(entry.getKey().getPassword())) {
                return entry.getKey();
            }
        }
        throw new Exception();
    }

    @Override
    public boolean update(User updatedUser) throws Exception {
        for (Map.Entry<User, Ticket> entry:
                DB.users.entrySet()) {
            if (updatedUser.getId().equals(entry.getKey().getId())) {
                entry.getKey().setName(updatedUser.getName());
                entry.getKey().setPassword(updatedUser.getPassword());
                entry.getKey().setPhoneNumber(updatedUser.getPhoneNumber());
                return true;
            }
        }
        throw new Exception();
    }

    @Override
    public boolean delete(String id) throws Exception {
        for (Map.Entry<User, Ticket> entry:
                DB.users.entrySet()) {
            if (id.equals(entry.getKey().getId())) {
                DB.users.remove(entry.getKey());
                return true;
            }
        }
        throw new Exception();
    }
}
