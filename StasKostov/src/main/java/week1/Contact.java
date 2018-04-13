package week1;

/**
 * Created by mac on 4/1/18.
 */
public class Contact {

    private int contactId;
    private String name;
    private String number;

    public Contact() {
    }

    public Contact( String name, String number) {

        this.name = name;
        this.number = number;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getContactId() {
        return contactId;
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
}
