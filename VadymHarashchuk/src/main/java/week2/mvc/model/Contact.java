package week2.mvc.model;

/**
 * Created by serhii on 15.04.18.
 */
public class Contact {

    private String id;
    private String name;
    private String number;

    private String notes;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", notes='" + notes + '\'' +
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
