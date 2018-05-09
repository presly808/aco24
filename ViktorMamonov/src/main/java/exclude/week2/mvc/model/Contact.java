package exclude.week2.mvc.model;

/**
 * Created by serhii on 15.04.18.
 */
public class Contact {

    private int id;
    private String name;
    private String number;
    private String city;

    public String getCity() {
        return city;
    }

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Contact(String name, String number, String city) {
        this.name = name;
        this.number = number;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || obj.getClass() != Contact.class){
            return false;
        }
        Contact contact = (Contact) obj;

        return this.id == contact.id;
    }
}
