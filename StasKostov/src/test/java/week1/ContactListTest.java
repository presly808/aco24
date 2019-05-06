package week1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactListTest {

    private ContactList contactList = new ContactList();

    @Test
    public void addContact() throws Exception {
        Contact user1 = new Contact("Lolia", "+380933091219");
        boolean res = contactList.addContact(user1);
        assertTrue(res);
    }

    @Test
    public void addContactNeg() throws Exception {
        assertFalse(contactList.addContact(new Contact("Lolia", "lkjhsdksdkjf")));
    }


    /*@Test
    public void findByNameOrNumber() throws Exception {
        Contact user1 = new Contact( "Lolia", "+380933091219");
        Contact user2 = new Contact("Ivan", "+38093");
        Contact user3 = new Contact("Oleg", "+380933091233");

        contactList.addContact(user1);
        contactList.addContact(user2);
        contactList.addContact(user3);

        assertEquals(2, contactList.findByNameOrNumber("093").length);

        assertEquals(1, contactList.findByNameOrNumber("Oleg").length);
    }*/

    /*@Test
    public void removeContact() throws Exception {

        Contact user1 = new Contact( "Lolia", "+380933091219");
        Contact user2 = new Contact( "Ivan", "+38093");
        Contact user3 = new Contact( "Oleg", "+380933091233");

        contactList.addContact(user1);
        contactList.addContact(user2);
        contactList.addContact(user3);

        contactList.removeContact(1);

        assertEquals(1, contactList.getAll().length);
    }*/

    /*@Test
    public void getAll() throws Exception {

        Contact user1 = new Contact( "Lolia", "+380933091219");
        Contact user2 = new Contact( "Ivan", "+38093");
        Contact user3 = new Contact( "Oleg", "+380933091233");

        contactList.addContact(user1);
        contactList.addContact(user2);
        contactList.addContact(user3);

        assertEquals(2, contactList.getAll().length);

    }*/

}