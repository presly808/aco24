package week6.httpserver;

import java.util.*;

public class User {

    List<Post> postsLists = new ArrayList<>();
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

    public static String login(User user){
        final String[] accessKey = {null};
        createUserMap().forEach((k,v)->{
            if (user.getName().equals(v.getName()) && (user.getPassword().equals(v.getPassword()))){
                accessKey[0] = user.getAccessKey(user.getName(),user.getPassword());
            }
        });
        return accessKey[0];
    }

    public String getAccessKey(String name, String password){
        return UUID.randomUUID().toString().substring(0,16);
    }

    public static Map<String, User> createUserMap() {
        Map<String, User> userMap = new HashMap<>();
        userMap.put("1", new User("valerii","123456"));
        userMap.put("2", new User("presly","12345"));
        userMap.put("3", new User("oleg","1234567"));
        return userMap;
    }



    public void addPost(Post post){
        postsLists.add(post);
    }
}
