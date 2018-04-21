package week1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by serhii on 01.04.18.
 */
public class ContactListTest {


    private ContactList contactList = new ContactList();

    @Test
    public void addContact() throws Exception {
        Contact user1 = new Contact(1, "Lolia", "+380933091219");
        boolean res = contactList.addContact(user1);
        assertTrue(res);
    }

    @Test
    public void addContactNeg() throws Exception {
        assertFalse(contactList.addContact(new Contact(1, "Lolia", "lkjhsdksdkjf")));
    }



    //private void assertArrayEquals(int i, int size) {
    // }


    @Test
    public void findByNameOrNumber() throws Exception {
        Contact user1 = new Contact(1, "Lolia", "+380933091219");
        Contact user2 = new Contact(2, "Ivan", "093");
        Contact user3 = new Contact(3, "Oleg", "+380933091233");
        Contact user4 = new Contact(4,"Valia","+380633918325");

        contactList.addContact(user1);
        contactList.addContact(user2);
        contactList.addContact(user3);
        contactList.addContact(user4);

        assertEquals(2, contactList.findByNameOrNumber("+38093").length);

        assertEquals(1, contactList.findByNameOrNumber("Oleg").length);

    }

    @Test
    public void getAll() throws Exception{

        Contact user1 = new Contact(1, "Lolia", "+380933091219");
        Contact user2 = new Contact(2, "Ivan", "+38093");
        Contact user3 = new Contact(3, "Oleg", "+380933091233");
        Contact user4 = new Contact(4,"Valia","+380633918325");

        contactList.addContact(user1);
        contactList.addContact(user2);
        contactList.addContact(user3);
        contactList.addContact(user4);

        assertEquals(4, contactList.getAll().length);

    }

    @Test
    public void removeContact() throws Exception {

        Contact user1 = new Contact(1, "Lolia", "+380933091219");
        Contact user2 = new Contact(2, "Ivan", "+38093");
        Contact user3 = new Contact(3, "Oleg", "+380933091233");
        Contact user4 = new Contact(4,"Valia","+380633918325");

        contactList.addContact(user1);
        contactList.addContact(user2);
        contactList.addContact(user3);
        contactList.addContact(user4);

        contactList.removeContact(1);

        assertEquals(2, (contactList.getAll().length - 1));

    }

}
