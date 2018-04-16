package week1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by serhii on 01.04.18.
 */
public class ContactListTest {

    @Test
    public void addContact() throws Exception {
        ContactList contactList = new ContactList();
        Contact user1 = new Contact(1, "Lolia", "+380933091219");
        boolean res = contactList.addContact(user1);
        assertTrue(res);
    }

    @Test
    public void addContactNeg() throws Exception {
        ContactList contactList = new ContactList();
        assertFalse(contactList.addContact(new Contact(1, "Lolia", "lkjhsdksdkjf")));
    }

    @Test
    public void findByNameOrNumber() throws Exception {
        ContactList contactList = new ContactList();
        Contact user1 = new Contact(1, "Lolia", "+380933091219");
        Contact user2 = new Contact(2, "Ivan", "+38093");
        Contact user3 = new Contact(3, "Oleg", "+380933091233");

        contactList.addContact(user1);
        contactList.addContact(user2);
        contactList.addContact(user3);

        assertEquals(2, contactList.findByNameOrNumber("093").length);

        assertEquals(1, contactList.findByNameOrNumber("Oleg").length);
    }

    @Test
    public void removeContact() throws Exception {
        ContactList contactList = new ContactList();
        Contact user1 = new Contact(1, "Lolia", "+380933091219");
        Contact user2 = new Contact(2, "Ivan", "+38093");
        Contact user3 = new Contact(3, "Oleg", "+380933091233");

        contactList.addContact(user1);
        contactList.addContact(user2);
        contactList.addContact(user3);

        contactList.removeContact(1);

        assertEquals(1, contactList.getAll().length);
    }

    @Test
    public void getAll() throws Exception {
        ContactList contactList = new ContactList();
        Contact user1 = new Contact(1, "Lolia", "+380933091219");
        Contact user2 = new Contact(2, "Ivan", "+38093");
        Contact user3 = new Contact(3, "Oleg", "+380933091233");

        contactList.addContact(user1);
        contactList.addContact(user2);
        contactList.addContact(user3);

        assertEquals(2, contactList.getAll().length);
    }
}