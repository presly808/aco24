package week6.utils;

import com.sun.net.httpserver.HttpExchange;
import week6.httpserver.User;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public static String getDataFromServer(HttpExchange httpExchange){
        BufferedReader br = null;
        String jsonBody = null;
        try {
            br = new BufferedReader(new InputStreamReader(httpExchange.getRequestBody()));
            StringBuilder sb = new StringBuilder();
            while (br.ready()) {
                sb.append(br.readLine());
            }
            jsonBody = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonBody;
    }
}
