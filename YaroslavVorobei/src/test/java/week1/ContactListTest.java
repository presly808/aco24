package week1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by y.vorobei on 01.04.18.
 */
public class ContactListTest {

    private ContactList contactList = new ContactList();

    @Test
    public void addContact() throws Exception {
        Contact user1 = new Contact(1, "L1", "+380933091219");
        Contact user2 = new Contact(2, "L2", "+380733091219");
        boolean res = contactList.addContact(user1);
        boolean res1 = contactList.addContact(user2);
        assertTrue(res);
        assertTrue(res1);
        assertEquals(2, contactList.getAll().length);
    }

    @Test
    public void addContactNeg() throws Exception {
        assertFalse(contactList.addContact(new Contact(1, "Lolia", "lkjhsdksdkjf")));
    }

    @Test
    public void addContactNegFullDB() throws Exception {
        final int SIZE_DB = 15;
        boolean result = true;
        for (int i = 0; i <= SIZE_DB; i++) {
            Contact userName = new Contact(1, "L1", "+380933091219");
            result = contactList.addContact(userName);
        }
        assertFalse(result);
    }


    @Test
    public void findByNameOrNumber() throws Exception {
        Contact user1 = new Contact(1, "Lolia", "+380933091219");
        Contact user2 = new Contact(2, "Ivan", "+38093");
        Contact user3 = new Contact(3, "Oleg", "+380933091233");
        Contact user4 = new Contact(4, "Oleg", "+380773091233");

        contactList.addContact(user1);
        contactList.addContact(user2);
        contactList.addContact(user3);
        contactList.addContact(user4);

        assertEquals(3, contactList.findByNameOrNumber("093").length);
        assertEquals(2, contactList.findByNameOrNumber("Oleg").length);
    }

    @Test
    public void removeContact() throws Exception {

        Contact user1 = new Contact(1, "Lolia", "+380933091219");
        Contact user2 = new Contact(2, "Ivan", "+38093");
        Contact user3 = new Contact(3, "Oleg", "+380933091233");

        contactList.addContact(user1);
        contactList.addContact(user2);
        contactList.addContact(user3);

        contactList.removeContact(1);

        assertEquals(2, contactList.getAll().length);
    }

    @Test
    public void removeContactNeg() throws Exception {

        Contact user1 = new Contact(1, "Lolia", "+380933091219");
        contactList.addContact(user1);
        assertFalse(contactList.removeContact(777));
    }

    @Test
    public void getAll() throws Exception {

        Contact user1 = new Contact(1, "Lolia", "+380933091219");
        Contact user2 = new Contact(2, "Ivan", "+38093");
        Contact user3 = new Contact(3, "Oleg", "+380933091233");

        contactList.addContact(user1);
        contactList.addContact(user2);
        contactList.addContact(user3);

        assertEquals(3, contactList.getAll().length);

    }

    @After
    public void clearContactList(){
        contactList.clearContactsStore();
    }

}