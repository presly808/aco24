package contactList;

public class Contact {

    private int id;
    private String firstName;
    private String lastName;
    private String number;
    private static int countId = 0;

    public Contact( String firstName, String lastName, String number) {
        id = countId++;
        this.firstName = firstName;
        this.number = number;
        this.lastName = lastName;
    }

}
