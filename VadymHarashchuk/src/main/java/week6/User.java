package week6;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class User {

    @Expose
    private String name;
    @Expose
    private String user;
    private String pass;

    @Expose
    private List<Post> posts;

    public User(){

     }

    public User(String name, String user, String pass) {
        this.name = name;
        this.user = user;
        this.pass = pass;
        posts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public void addPosts(List<Post> posts) {
        this.posts.addAll(posts);
    }
}
