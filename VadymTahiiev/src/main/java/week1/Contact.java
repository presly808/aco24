package week1;

import java.util.Arrays;

/**
 * Created by serhii on 31.03.18.
 */
public class Contact {

    private int id;
    private String name;
    private String number;

    public Contact() {
    }

    public Contact(int id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() { return id;}

    public void setId(int id) { this.id = id; }
}

