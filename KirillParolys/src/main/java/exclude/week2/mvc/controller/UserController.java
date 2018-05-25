package exclude.week2.mvc.controller;

import exclude.week2.mvc.exception.MyLoginException;
import exclude.week2.mvc.exception.RegisterException;
import exclude.week2.mvc.model.User;

/**
 * Created by serhii on 13.05.18.
 */
public interface UserController {

    // returns accessToken
    String login(String name, String pass) throws MyLoginException;

    User register(String name, String pass) throws RegisterException;

    boolean isLoggedIn(String accessToken);

}
