package week2.mvc.dataModel;

import week1.Contact;

import java.util.Arrays;

public class DataModelImpl implements DataModel {

    private Contact[] contactsArray;
    private int lastContactIndex;

    public DataModelImpl(){
        this.contactsArray = new Contact[10];
    }

    public Contact[] getContactsArray() {
        return contactsArray;
    }

    public void setContactsArray(Contact[] contactsArray) {
        this.contactsArray = contactsArray;
    }

    public int getLastContactIndex() {
        return lastContactIndex;
    }

    @Override
    public boolean create(Contact contact) {
        contactsArray[lastContactIndex] = contact;
        lastContactIndex++;
        return true;
    }

    @Override
    public Contact[] read() {
        return Arrays.copyOf(contactsArray,lastContactIndex);
    }

    @Override
    public boolean update(Contact contact) {
        for (int i = 0; i < lastContactIndex; i++) {
            if (contactsArray[i].getId()==contact.getId()) {
                contactsArray[i] = contact;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        for (int i = 0; i < lastContactIndex; i++) {
            if (contactsArray[i].getId()==id) {
                contactsArray[i] = null;
                lastContactIndex--;
                return true;
            }
        }
        return false;
    }
}
