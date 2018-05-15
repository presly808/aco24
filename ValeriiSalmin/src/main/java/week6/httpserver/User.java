package week6.httpserver;

import java.util.UUID;

public class User {

    private String name;
    private String password;

    public User(){
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getAccessKey(String name, String password){
        return UUID.randomUUID().toString().substring(0,16);
    }
}
