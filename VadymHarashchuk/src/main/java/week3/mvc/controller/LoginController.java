package week3.mvc.controller;

import week3.mvc.exceptions.LoginException;
import week3.mvc.model.human.User;
import week3.mvc.model.human.Worker;

public interface LoginController {

    String login(String username, String password, String type) throws LoginException;
    User getUser(String name);
    Worker getWorker(String name);
    String isLoggedIn(String accessToken);

}
