package exclude.week2.mvc.controller;

import exclude.week2.mvc.dao.ContactDaoImpl;
import exclude.week2.mvc.model.Contact;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        Assert.assertNotEquals(-1, id);
        Assert.assertNotEquals(0, id);
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

        Assert.assertNull(removed);
    }

    @Test
    public void findByKeyWord() throws Exception {
        contactController.addContact(new Contact("Anton", "+380931234567"));
        contactController.addContact(new Contact("Andrey", "+380939876543"));
        contactController.addContact(new Contact("Oleg", "+380974536723"));
        contactController.addContact(new Contact("Ivan", "+380507869078"));

        Contact[] contacts = contactController.findByKeyWord("an");
        Assert.assertEquals(2,contacts.length);

        Contact[] contactsNum = contactController.findByKeyWord("093");
        Assert.assertEquals(2,contactsNum.length);
    }

    @Test
    public void findByKeyWordNotFound() throws Exception {
        contactController.addContact(new Contact("Anton", "+380931234567"));
        contactController.addContact(new Contact("Andrey", "+380939876543"));
        contactController.addContact(new Contact("Oleg", "+380974536723"));
        contactController.addContact(new Contact("Ivan", "+380507869078"));

        Contact[] contacts = contactController.findByKeyWord("x");
        Assert.assertEquals(0,contacts.length);
    }

    @Test
    public void findDuplicates() throws Exception {

        contactController.addContact(new Contact("Anton", "+380931234567"));
        contactController.addContact(new Contact("Petro", "+380931234567"));
        contactController.addContact(new Contact("Andrey", "+380939876543"));
        contactController.addContact(new Contact("Oleg", "+380974536723"));
        contactController.addContact(new Contact("Ivan", "+380507869078"));

        Contact[] contacts = contactController.findDuplicates();
        Assert.assertEquals(2,contacts.length);
    }

    @Test
    public void getAll() throws Exception {
        contactController.addContact(new Contact("Anton", "+380931234567"));
        contactController.addContact(new Contact("Petro", "+380931234567"));
        contactController.addContact(new Contact("Andrey", "+380939876543"));
        contactController.addContact(new Contact("Oleg", "+380974536723"));
        contactController.addContact(new Contact("Ivan", "+380507869078"));

        Assert.assertEquals(5, contactController.getAll().length);
    }

    @Test
    public void filterByCity() throws Exception {
        contactController.addContact(new Contact("Anton", "+380931234567", "Kiev"));
        contactController.addContact(new Contact("Petro", "+380931234567", "Dnipro"));
        contactController.addContact(new Contact("Andrey", "+380939876543", "dnipro"));
        contactController.addContact(new Contact("Oleg", "+380974536723", "Rivne"));
        contactController.addContact(new Contact("Ivan", "+380507869078", "Vyshneve"));

        Contact[] contacts = contactController.filterByCity("dnipro");
        Contact[] contacts1 = contactController.filterByCity("Novograd");
        Assert.assertEquals(2,contacts.length);
        Assert.assertEquals(0,contacts1.length);
    }

    @Test
    public void filterByNameOrNumber() throws Exception {
        contactController.addContact(new Contact("Anton", "0931234827", "Kiev"));
        contactController.addContact(new Contact("Petro", "+380931234567", "Dnipro"));
        contactController.addContact(new Contact("Andrey", "+380939876543", "dnipro"));
        contactController.addContact(new Contact("Oleg", "+380974536723", "Rivne"));
        contactController.addContact(new Contact("Ivan", "+380507869078", "Vyshneve"));

        Contact[] contacts = contactController.filterByNameOrNumber("ivan", "05078");
        Contact[] contacts1 = contactController.filterByNameOrNumber("  ", "09312");
        Assert.assertEquals(1, contacts.length);
        Assert.assertEquals(2,contacts1.length);


    }

}