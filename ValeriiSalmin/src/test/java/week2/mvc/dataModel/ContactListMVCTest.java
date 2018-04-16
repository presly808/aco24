package week2.mvc.dataModel;

import org.junit.*;
import week1.Contact;
import week2.mvc.contactController.*;

public class ContactListMVCTest {

    private ContactController contactController;

    @Before
    public void setUp() throws Exception {
        contactController = new ContactControllerImpl(new DataModelImpl());
    }

    @After
    public void tearDown() throws Exception {
        contactController = null;
    }

    @Test
    public void addContactPositive() throws Exception {
        contactController.addContact(new Contact(1, "Ivan", "+380932312345"));
        contactController.addContact(new Contact(2, "Igor", "+380932312346"));
        Assert.assertEquals(2, contactController.getAll().length);
    }

    @Test
    public void addContactNegative() throws Exception {
        contactController.addContact(new Contact(1, "Ivan", "+380932312345"));
        contactController.addContact(new Contact(2, "Ivan", "+3809"));
        contactController.addContact(new Contact(3, "Ivan", "blabla"));
        Assert.assertEquals(1, contactController.getAll().length);
    }

    @Test
    public void getAll() throws Exception {
        contactController.addContact(new Contact(1, "Ivan", "+380932312345"));
        contactController.addContact(new Contact(2, "Igor", "+380932312346"));
        Assert.assertEquals(2, contactController.getAll().length);
    }

    @Test
    public void findByNameOrNumberPositive() throws Exception {
        contactController.addContact(new Contact(1, "Ivan", "+380932312345"));
        contactController.addContact(new Contact(2, "Igor", "+380932312346"));
        contactController.addContact(new Contact(3, "Ira", "+380932312347"));
        Assert.assertEquals(1, contactController.findByNameOrNumber("ira").length);
        Assert.assertEquals(3, contactController.findByNameOrNumber("8093231234").length);
    }

    @Test
    public void findByNameOrNumberNegative() throws Exception {
        contactController.addContact(new Contact(1, "Ivan", "+380932312345"));
        contactController.addContact(new Contact(2, "Igor", "+380932312346"));
        contactController.addContact(new Contact(3, "Ira", "+380932312347"));
        Assert.assertEquals(0, contactController.findByNameOrNumber("blabal").length);
    }

    @Test
    public void deletePositive() throws Exception {
        contactController.addContact(new Contact(1, "Ivan", "+380932312345"));
        contactController.addContact(new Contact(2, "Igor", "+380932312346"));
        contactController.addContact(new Contact(3, "Ira", "+380932312347"));
        contactController.removeContact(2);
        Assert.assertEquals(2, contactController.getAll().length);
    }

    @Test
    public void deleteNegative() throws Exception {
        contactController.addContact(new Contact(1, "Ivan", "+380932312345"));
        contactController.addContact(new Contact(2, "Igor", "+380932312346"));
        contactController.addContact(new Contact(3, "Ira", "+380932312347"));
        contactController.removeContact(4);
        Assert.assertEquals(3, contactController.getAll().length);
    }
}