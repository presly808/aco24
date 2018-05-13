package week2.mvc.model;


import java.util.Arrays;

public class DataModelImpl implements DataModel {

    private final static int INITIAL_SIZE = 10;
    private Contact[] allContacts = new Contact[INITIAL_SIZE];
    private int lastIndex = 0;

    @Override
    public boolean add(Contact contact) {

        ensureContactListCapacity();
        allContacts[lastIndex++] = new Contact(contact.getId(), contact.getName(), contact.getNumber());

        return true;
    }

    @Override
    public Contact remove(int id) {
        Contact[] list = get();
        for (int i = 0; i < list.length; i++) {
            if (list[i].getId() == id) {
                Contact found = list[i];
                System.arraycopy(allContacts, i + 1, allContacts, i, list.length - 1 - i);
                lastIndex--;
                list[list.length - 1] = null;
                return found;
            }
        }
        return null;
    }

    @Override
    public Contact[] get() {
        return Arrays.copyOf(allContacts, lastIndex);
    }

    @Override
    public int getSize() {
        return lastIndex;
    }

    @Override
    public void setSize(int size) {
        lastIndex = size;
    }

    public void ensureContactListCapacity(){
        if (lastIndex == allContacts.length - 1) {
            Contact[] resized =  new Contact[INITIAL_SIZE * 2];
            System.arraycopy(allContacts, 0, resized, 0, allContacts.length);
            allContacts = resized;
        }
    }

}
