package week1;

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
        ContactList list = new ContactList();
        Contact user1 = new Contact(4, "Lolia", "+380933091219");
        Contact user2 = new Contact(5, "Ivan", "+38093");
        Contact user3 = new Contact(6, "Oleg", "+380933091233");

        list.addContact(user1);
        list.addContact(user2);
        list.addContact(user3);

        assertEquals(2, list.findByNameOrNumber("093").length);
        assertEquals(1, list.findByNameOrNumber("Oleg").length);
    }

    @Test
    public void removeContact() throws Exception {
        ContactList list = new ContactList();
        Contact user1 = new Contact(1, "Lolia", "+380933091219");
        Contact user2 = new Contact(2, "Ivan", "+38093");
        Contact user3 = new Contact(3, "Oleg", "+380933091233");

        list.addContact(user1);
        list.addContact(user2);
        list.addContact(user3);

        list.removeContact(1);

        assertEquals(1, list.getAll().length);
    }

    @Test
    public void getAll() throws Exception {
        ContactList list2 = new ContactList();
        Contact user1 = new Contact(1, "Lolia", "+380933091219");
        Contact user2 = new Contact(2, "Ivan", "+38093");
        Contact user3 = new Contact(3, "Oleg", "+380933091233");

        list2.addContact(user1);
        list2.addContact(user2);
        list2.addContact(user3);

        assertEquals(2, list2.getAll().length);
    }
}