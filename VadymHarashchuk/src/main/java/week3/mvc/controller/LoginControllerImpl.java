package week3.mvc.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LoginControllerImpl implements LoginController {

    private final static Map<String, String> admins = new HashMap<>();
    private final static Map<String, String> users = new HashMap<>();
    private final static Map<String, String> workers = new HashMap<>();
    private String adminAccessKey;


    private String userAccessKey;
    private String workerAccessKey;

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


    public String loginAsAdmin(String username, String password) {
        for (Map.Entry<String, String> pair : admins.entrySet()) {
            if (pair.getKey().equals(username) && pair.getValue().equals(password)) {
                setAdminAccessKey(Base64.getEncoder().encodeToString(password.getBytes())
                        + Base64.getEncoder().encodeToString(username.getBytes())
                        + Base64.getEncoder().encodeToString(new Date().toString().getBytes()));
            }
        }
        return adminAccessKey;
    }

    public String loginAsWorker(String username, String password) {
        for (Map.Entry<String, String> pair : workers.entrySet()) {
            if (pair.getKey().equals(username) && pair.getValue().equals(password)) {
                setAdminAccessKey(Base64.getEncoder().encodeToString(password.getBytes())
                        + Base64.getEncoder().encodeToString(username.getBytes())
                        + Base64.getEncoder().encodeToString(new Date().toString().getBytes()));
            }
        }
        return workerAccessKey;
    }

    public String loginAsUser(String username, String password) {
        for (Map.Entry<String, String> pair : users.entrySet()) {
            if (pair.getKey().equals(username) && pair.getValue().equals(password)) {
                setUserAccessKey(Base64.getEncoder().encodeToString(password.getBytes())
                        + Base64.getEncoder().encodeToString(username.getBytes())
                        + Base64.getEncoder().encodeToString(new Date().toString().getBytes()));
            }
        }
        return userAccessKey;

    }

    public String getAdminAccessKey() {
        return adminAccessKey;
    }

    public void setAdminAccessKey(String adminAccessKey) {
        this.adminAccessKey = adminAccessKey;
    }

    public String getUserAccessKey() {
        return userAccessKey;
    }

    public void setUserAccessKey(String userAccessKey) {
        this.userAccessKey = userAccessKey;
    }

    public String getWorkerAccessKey() {
        return workerAccessKey;
    }

    public void setWorkerAccessKey(String workerAccessKey) {
        this.workerAccessKey = workerAccessKey;
    }

}
