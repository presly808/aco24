package week2.mvc.controller;

import week2.mvc.dao.Dao;
import week2.mvc.exception.MyLoginException;
import week2.mvc.exception.RegisterException;
import week2.mvc.model.User;
import week2.mvc.utils.NumberUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by serhii on 13.05.18.
 */
public class UserControllerImpl implements UserController {

    private Map<String, User> accessKeys;
    private Dao<User> userDao;

    public UserControllerImpl(Dao<User> userDao) {
        this.userDao = userDao;
        accessKeys = new HashMap<>();
    }

    @Override
    public String login(String name, String pass) throws MyLoginException {

        User found = getUser(name);

        if(found == null || !found.getPass().equals(pass)){
            throw new MyLoginException("wrong name or pass");
        }

        String accessKey = NumberUtil.generateToken();

        accessKeys.put(accessKey, found);

        return accessKey;
    }

    @Override
    public User register(String name, String pass) throws RegisterException {
        User t = new User();
        t.setName(name);
        t.setPass(pass);

        User found = getUser(name);

        if(found != null){
            throw new RegisterException("user already exists");
        }

        boolean result = userDao.create(t);
        return t;
    }

    private User getUser(String name) {
        return Arrays.stream(userDao.all())
                    .filter(user -> user.getName().equals(name)).findFirst()
                    .orElse(null);
    }

    @Override
    public boolean isLoggedIn(String accessToken) {
        return accessKeys.containsKey(accessToken);
    }
}
