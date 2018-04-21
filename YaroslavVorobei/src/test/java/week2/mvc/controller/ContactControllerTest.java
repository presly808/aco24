package week2.mvc.controller;

import week2.mvc.dao.ContactDaoImpl;
import week2.mvc.model.Contact;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by serhii on 15.04.18.
 */
public class ContactControllerTest {

    private ContactController contactController;

    @Before
    public void before(){
        contactController = new ContactControllerImpl(new ContactDaoImpl());
        // init data, in particular create contactController
    }

    @After
    public void after(){
        // delete all data, remove contactController
        contactController = null;
    }

    @Test
    public void addContact() throws Exception {
        int id = contactController.addContact(new Contact("Ivan", "+380932312345"));
        assertNotEquals(-1, id);
        assertNotEquals(0, id);
    }

    @Test
    public void removeContact() throws Exception {
        Contact newCont = new Contact("Ivan", "+380932312345");
        int id = contactController.addContact(newCont);

        Contact removed = contactController.removeContact(id);

        Assert.assertEquals(newCont.getName(), removed.getName());
    }

    @Test
    public void removeContactNotFound() throws Exception {
        Contact newCont = new Contact("Ivan", "+380932312345");
        int id = contactController.addContact(newCont);

        Contact removed = contactController.removeContact(-5);

        assertNull(removed);
    }

    @Test
    public void findByKeyWord() throws Exception {
        contactController.addContact(new Contact("Anton", "+380931234567"));
        contactController.addContact(new Contact("Andrey", "+380939876543"));
        contactController.addContact(new Contact("Oleg", "+380974536723"));
        contactController.addContact(new Contact("Ivan", "+380507869078"));

        Contact[] contacts = contactController.findByKeyWord("an");
        assertEquals(2,contacts.length);

        Contact[] contactsNum = contactController.findByKeyWord("093");
        assertEquals(2,contactsNum.length);
    }

    @Test
    public void findByKeyWordNotFound() throws Exception {
        contactController.addContact(new Contact("Anton", "+380931234567"));
        contactController.addContact(new Contact("Andrey", "+380939876543"));
        contactController.addContact(new Contact("Oleg", "+380974536723"));
        contactController.addContact(new Contact("Ivan", "+380507869078"));

        Contact[] contacts = contactController.findByKeyWord("x");
        assertEquals(0,contacts.length);
    }

    @Test
    public void findDuplicates() throws Exception {

        contactController.addContact(new Contact("Anton", "+380931234567"));
        contactController.addContact(new Contact("Petro", "+380931234567"));
        contactController.addContact(new Contact("Andrey", "+380939876543"));
        contactController.addContact(new Contact("Oleg", "+380974536723"));
        contactController.addContact(new Contact("Ivan", "+380507869078"));

        Contact[] contacts = contactController.findDuplicates();
        assertEquals(2,contacts.length);
    }

    @Test
    public void getAll() throws Exception {
        contactController.addContact(new Contact("Anton", "+380931234567"));
        contactController.addContact(new Contact("Petro", "+380931234567"));
        contactController.addContact(new Contact("Andrey", "+380939876543"));
        contactController.addContact(new Contact("Oleg", "+380974536723"));
        contactController.addContact(new Contact("Ivan", "+380507869078"));

        assertEquals(5, contactController.getAll().length);
    }

    @Test
    public void findByNameOrNumber() throws Exception {
        Contact user1 = new Contact("Lolia", "+380933091219");
        Contact user2 = new Contact("Ivan", "+38093");
        Contact user3 = new Contact("Oleg", "+380933091233");
        Contact user4 = new Contact("Oleg", "+380773091233");

        contactController.addContact(user1);
        contactController.addContact(user2);
        contactController.addContact(user3);
        contactController.addContact(user4);

        assertEquals(3, contactController.findByNameOrNumber("093").length);
        assertEquals(2, contactController.findByNameOrNumber("Oleg").length);
    }

    @Test
    public void filterByCity(){
        Contact user1 = new Contact("Lolia", "+380933091219", "Kyiv");
        Contact user2 = new Contact("Ivan", "+38093","Poninka");
        Contact user3 = new Contact("Den", "+38093878","Poninka");

        contactController.addContact(user1);
        contactController.addContact(user2);
        contactController.addContact(user3);

        assertEquals(2, contactController.filterByCity("Poninka").length);
        assertEquals(1, contactController.filterByCity("Kyiv").length);
    }
    @Test
    public void filterByCityNeg(){
        Contact user1 = new Contact("Lolia", "+380933091219", "Kyiv");
        Contact user2 = new Contact("Ivan", "+38093","Poninka");
        Contact user3 = new Contact("Den", "+38093878","Poninka");

        contactController.addContact(user1);
        contactController.addContact(user2);
        contactController.addContact(user3);

        assertEquals(0, contactController.filterByCity("Polonne").length);
    }

    @Test
    public void mergeContacts(){
        Contact user1 = new Contact("Ivan", "+380933091219");
        Contact user2 = new Contact("Ivan2", "+38097720922");

        contactController.addContact(user1);
        contactController.addContact(user2);

        contactController.mergeContacts(user1, user2);
        assertEquals(1, contactController.findByNameOrNumber("Ivan").length);
    }
}