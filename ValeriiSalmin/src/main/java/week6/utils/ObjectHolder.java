package week6.utils;

import week6.httpserver.User;

import java.util.HashMap;
import java.util.Map;

public class ObjectHolder {

    public static Map<String, User> createUserMap() {
        Map<String, User> userMap = new HashMap<>();
        userMap.put("1", new User("valerii","123456"));
        userMap.put("2", new User("presly","12345"));
        userMap.put("3", new User("oleg","1234567"));
        return userMap;
    }
}
