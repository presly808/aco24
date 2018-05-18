package week6.httpserver;

import java.util.HashMap;
import java.util.Map;

public class Post {

    private static int countID;
    private int id;
    private String title;
    private String body;

    public Post(){
        countID++;
    }

    public Post(String title, String body) {
        countID++;
        id = countID;
        this.title = title;
        this.body = body;
    }

    public static int getCountID() {
        return countID;
    }

    public static void setCountID(int countID) {
        Post.countID = countID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static Map<Post, User> createPostMap() {
        Map<Post, User> postsMap = new HashMap<>();
        postsMap.put(new Post("title1","body1"), new User("valerii","123456"));
        postsMap.put(new Post("title2","body2"), new User("presly","12345"));
        postsMap.put(new Post("title3","body3"), new User("oleg","1234567"));
        return postsMap;
    }
}
