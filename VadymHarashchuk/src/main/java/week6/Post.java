package week6;

import com.google.gson.annotations.Expose;

public class Post {

    static  int common_id = 1;
    @Expose
    private String title;
    @Expose
    private String body;
    @Expose
    private int id;

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = common_id++;
    }


    public Post(String title, String body) {
        this.title = title;
        this.body = body;
        this.id = common_id++;
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
}
