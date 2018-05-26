package week3.mvc.controller;

import week3.mvc.dao.Dao;
import week3.mvc.dao.UserDaoImpl;
import week3.mvc.dao.WorkerDaoImpl;
import week3.mvc.db.DBadmins;
import week3.mvc.db.DBusers;
import week3.mvc.db.DBworkers;
import week3.mvc.exceptions.LoginException;
import week3.mvc.exceptions.RegisterException;
import week3.mvc.model.human.Human;
import week3.mvc.model.human.User;
import week3.mvc.model.human.Worker;

import java.util.*;

public class LoginControllerImpl implements LoginController {


    private Map<String, String> accessKeys;
    private static Dao<User> users;
    private static Dao<Worker> workers;
    private static DBadmins admins;


    public LoginControllerImpl() {
        users = new UserDaoImpl();
        workers = new WorkerDaoImpl();
        accessKeys = new HashMap<>();
    }


    public String login(String name, String pass, String type) throws LoginException {
//            User found = getUser(name);
        Human found = null;
        switch (type) {
            case "USER":
                found = getUser(name);
                break;
            case "WORKER":
                found = getWorker(name);
        }
        if (found == null || !found.getPassword().equals(pass)) {
            throw new LoginException("wrong name or pass");
        }
        String accessKey = UUID.randomUUID().toString().substring(0, 16);
        accessKeys.put(accessKey, found.getName());
        return accessKey;
    }

    public User getUser(String name) {
        return users.getAll().stream()
                .filter(user -> user.getName().equals(name)).findFirst()
                .orElse(null);
    }

    public Worker getWorker(String name) {
        return workers.getAll().stream()
                .filter(user -> user.getName().equals(name)).findFirst()
                .orElse(null);
    }

    public String isLoggedIn(String accessToken) {

        return accessKeys.entrySet().stream()
                .filter(set -> set.getKey().equals(accessToken))
                .findFirst()
                .map(set -> set.getValue())
                .get();
    }



//    public <T> T register(String name, String pass) throws RegisterException {
//        Human t;
//        if (T instanceof Worker) {
//            t = new Worker(name, pass);
//        }
//
//        t.setName(name);
//        t.setPassword(pass);
//
//        User found = getUser(name);
//
//        if (found != null) {
//            throw new RegisterException("user already exists");
//        }
//
//        boolean result = users.create(t);
//        return t;
//
//    }
}
