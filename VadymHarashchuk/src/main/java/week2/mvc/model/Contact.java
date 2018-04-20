package week2.mvc.model;

/**
 * Created by serhii on 31.03.18.
 */
public class Contact {

    private int id;
    private String name;
    private String number;


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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {

        Contact contact = (Contact) obj;
        if (obj == null) return  false;

        return contact.getNumber().equals(this.getNumber())
                && contact.getName().equals(this.getName())
                && contact.getId() == this.getId();
    }
}
