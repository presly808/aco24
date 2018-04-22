package week2.mvc.contactController;

import week1.Contact;

public interface ContactController {

    public boolean addContact(Contact contact);

    public boolean removeContact(int id);

    public Contact[] findByNameOrNumber(String nameOrNumber);

    public Contact[] getAll();
}
