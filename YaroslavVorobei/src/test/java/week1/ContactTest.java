package week1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTest {

    private Contact user;

    @Before
    public void setUp() {
        user = new Contact(1, "Lolia", "+380933091219");
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Lolia", user.getName());
    }

    @Test
    public void setName() throws Exception {
        user.setName("Eva");
        assertEquals("Eva", user.getName());
    }

    @Test
    public void getNumber() throws Exception {
        assertEquals("+380933091219", user.getNumber());
    }

    @Test
    public void setNumber() throws Exception {
        user.setNumber("+389379992");
        assertEquals("+389379992", user.getNumber());
    }

    @Test
    public void getId() throws Exception {
        assertEquals(1, user.getId());
    }

    @Test
    public void setId() throws Exception {
        user.setId(777);
        assertEquals(777, user.getId());
    }

}