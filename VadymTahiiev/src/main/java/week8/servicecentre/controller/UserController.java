package week8.servicecentre.controller;

import week8.servicecentre.dao.*;
import week8.servicecentre.model.User;

import java.util.UUID;

public class UserController implements IUserController {
    private Dao userDao;
    private User user;

    @Override
    public boolean registerUser(String name, String phoneNumber, String password) throws Exception{
        userDao = new UserDao();
        user = new User();
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        String id = UUID.randomUUID().toString();
        user.setId(id);
        userDao.create(user);
        return true;
    }

    @Override
    public String loginUser(String name, String password) throws Exception {
        user.setName(name);
        user.setPassword(password);
        User tempUser = (User)userDao.read(user);
        return tempUser.getId();
    }
}
