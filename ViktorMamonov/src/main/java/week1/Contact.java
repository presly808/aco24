package week1;

/**
 * Created by serhii on 31.03.18.
 */
public class Contact {
    private int id;
    private String name;
    private String number;

    public Contact (int id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
