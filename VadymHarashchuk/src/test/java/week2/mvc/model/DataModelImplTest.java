package week2.mvc.model;

import org.junit.*;

import static org.junit.Assert.*;

public class DataModelImplTest {

    DataModel dataModel;

    @Before
    public void setUp() throws Exception {
        dataModel = new DataModelImpl();
    }

    @After
    public void tearDown() throws Exception {
        dataModel = null;
    }

    @Test
    public void add() {
        assertEquals(dataModel.get().length,0);
        Contact contact1 = new Contact(135, "Vad", "+420931234567");
        assertTrue(dataModel.add(contact1));
    }

    @Test
    public void remove() {
        Contact contact1 = new Contact(135, "Vad", "+420931234567");
        Contact contact2 = new Contact(1, "Vasya", "+420931234567");
        dataModel.add(contact1);
        dataModel.add(contact2);
        Contact c = dataModel.remove(1);
        assertEquals(c, contact2);
        assertEquals(1, dataModel.get().length);
    }

    @Test
    public void get() {
        Contact contact1 = new Contact(135, "Vad", "+420931234567");
        Contact contact2 = new Contact(1, "Vasya", "+420931234567");
        dataModel.add(contact1);
        dataModel.add(contact2);
        assertEquals(2, dataModel.get().length);
    }

    @Test
    public void getSize() {
        Contact contact1 = new Contact(135, "Vad", "+420931234567");
        Contact contact2 = new Contact(1, "Vasya", "+420931234567");
        dataModel.add(contact1);
        dataModel.add(contact2);
        assertEquals(dataModel.get().length,dataModel.getSize());
    }

    @Test
    public void setSize(){
        Contact contact1 = new Contact(135, "Vad", "+420931234567");
        Contact contact2 = new Contact(1, "Vasya", "+420931234567");
        dataModel.add(contact1);
        dataModel.add(contact2);
        int size = dataModel.getSize();
        dataModel.setSize(1);
        assertNotEquals(size, dataModel.getSize());
    }
}