package week2.mvc.controller;

import org.junit.*;
import week2.mvc.model.Contact;
import week2.mvc.model.DataModelImpl;

import static org.junit.Assert.*;

public class ContactControllerImplTest {

    ContactController contactController;


    @Before
    public void setUp() throws Exception {
        contactController = new ContactControllerImpl(new DataModelImpl());
    }

    @After
    public void tearDown() throws Exception {
        contactController = null;
    }

    @Test
    public void addContactPositive() {
        Contact contact1 = new Contact(135, "Vad", "+420931234567");
        assertTrue(contactController.addContact(contact1));
    }

    @Test
    public void addContactNegative() {
        Contact contact1 = new Contact(135, null, "+420931234567");
        Contact contact2 = new Contact(1, "", null);
        Contact contact3 = new Contact(2, "", "+420");
        Contact contact4 = new Contact(1, "", "+4209311234567asd");
        Contact contact5 = null;
        contactController.addContact(contact1);
        contactController.addContact(contact2);
        contactController.addContact(contact3);
        contactController.addContact(contact4);
        contactController.addContact(contact5);
        assertNotEquals(5, contactController.getAll().length);

    }

    @Test
    public void findByNameOrNumberPositive() {
        Contact contact1 = new Contact(135, "Vad", "+420931234567");
        Contact contact2 = new Contact(1, "Vasya", "+420931234567");
        Contact contact3 = new Contact(45, "Alex", "+420931234567");
        contactController.addContact(contact1);
        contactController.addContact(contact2);
        contactController.addContact(contact3);
        assertEquals( 2, contactController.findByNameOrNumber("Va").length);
    }

    @Test
    public void findByNameOrNumberNegative() {
        Contact contact1 = new Contact(135, "Vad", "+420931234567");
        Contact contact2 = new Contact(1, "Vasya", "+420931234567");
        Contact contact3 = new Contact(45, "Alex", "+420931234567");
        contactController.addContact(contact1);
        contactController.addContact(contact2);
        contactController.addContact(contact3);
        assertEquals( 0, contactController.findByNameOrNumber(null).length);
    }

    @Test
    public void removeContactPositive() {
        Contact contact1 = new Contact(135, "Vad", "+420931234567");
        Contact contact2 = new Contact(1, "Vasya", "+420931234567");
        contactController.addContact(contact1);
        contactController.addContact(contact2);
        assertTrue(contactController.removeContact(135).equals(contact1));
    }

    @Test
    public void removeContactNegative() {
        Contact contact1 = new Contact(135, "Vad", "+420931234567");
        Contact contact2 = new Contact(1, "Vasya", "+420931234567");
        contactController.addContact(contact1);
        contactController.addContact(contact2);
        assertEquals(null, contactController.removeContact(210));
    }

    @Test
    public void getAll() {
        Contact contact1 = new Contact(135, "Vad", "+420931234567");
        Contact contact2 = new Contact(1, "Vasya", "+420931234567");
        contactController.addContact(contact1);
        contactController.addContact(contact2);
        assertEquals(2, contactController.getAll().length);

    }

    @Test
    public void findContactPositive() {
        Contact contact1 = new Contact(135, "Vad", "+420931234567");
        assertEquals(contact1, contactController.findContact(contact1, "931"));
    }

    @Test
    public void findContactNegative() {
        Contact contact1 = new Contact(135, "Vad", "+420931234567");
        assertNotEquals(contact1, contactController.findContact(contact1, "Igo"));
    }
}