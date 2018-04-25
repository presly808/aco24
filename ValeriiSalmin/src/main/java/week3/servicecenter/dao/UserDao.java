package week3.servicecenter.dao;

import week3.servicecenter.model.User;

import java.util.List;

public interface UserDao {

    public boolean create(User user);
    public List<User> read();
    public void update();
    public boolean delete(User user);
}
