package week2.mvc.contactController;

import week1.Contact;

public interface ContactController {

    public boolean addContact(Contact contact) throws Exception;

    public boolean removeContact(int id) throws Exception;

    public Contact[] findByNameOrNumber(String nameOrNumber) throws Exception;

    public Contact[] getAll();
}
