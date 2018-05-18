package week6.httpserver;

import java.util.*;

public class User {

    private List<Post> postsLists = new ArrayList<>();
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

    public List<Post> getPostsLists() {
        return postsLists;
    }

    public static String login(User user){
        final String[] accessKey = {null};
        createUserMap().forEach((k,v)->{
            if (user.getName().equals(v.getName()) && (user.password.equals(v.password))){
                accessKey[0] = user.getAccessKey();
            }
            else{
                System.out.println("there is no such user");
            }
        });
        return accessKey[0];
    }

    public String getAccessKey(){
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
