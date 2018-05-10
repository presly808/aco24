package week3.mvc.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LoginControllerImpl implements LoginController {

    private final static Map<String, String> admins = new HashMap<>();
    private final static Map<String, String> users = new HashMap<>();
    private final static Map<String, String> workers = new HashMap<>();

    private String accessKey;

    static {
        admins.put("admin_Vadym", "123456");
        admins.put("admin_Valerii", "qwerty");
        admins.put("admin_Serhii", "123123");
        users.put("user", "123456");
        users.put("Max", "654321");
        users.put("Sashko", "password");
        workers.put("Olexandr", "id1234");
        workers.put("Ivan", "id625");
        workers.put("Nazar", "id1024");
    }

    @Override
    public String login(String typeOfuser, String username, String password) {
        Map<String, String> credentials = new HashMap<>();
        switch (typeOfuser) {
            case "user":
                credentials = users;
                break;
            case "admin":
                credentials = admins;
                break;
            case "worker":
                credentials = workers;
        }

        for (Map.Entry<String, String> pair : credentials.entrySet()) {
            if (pair.getKey().equals(username) && pair.getValue().equals(password)) {
                setAccessKey(Base64.getEncoder().encodeToString(password.getBytes())
                        + Base64.getEncoder().encodeToString(username.getBytes())
                        + Base64.getEncoder().encodeToString(new Date().toString().getBytes()));
            }
        }
        return accessKey;
    }

    public String getAccessKey() {
        return accessKey;
    }

    private void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }
}
