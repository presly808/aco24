package exclude.week2.mvc.model;

/**
 * Created by serhii on 13.05.18.
 */
public class User {

    private String id;
    private String name;
    private String pass;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
