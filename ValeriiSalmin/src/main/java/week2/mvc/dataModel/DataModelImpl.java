package week2.mvc.dataModel;

import week1.Contact;

public class DataModelImpl implements DataModel {

    private Contact[] contactsArray;
    private int lastIndex;

    public DataModelImpl(){
        this.contactsArray = new Contact[10];
    }

    @Override
    public boolean create(Contact contact) {
        contactsArray[lastIndex] = contact;
        lastIndex++;
        return true;
    }

    @Override
    public Contact[] read() {
        return contactsArray;
    }

    @Override
    public boolean update(Contact contact) {
        for (int i = 0; i < contactsArray.length; i++) {
            if (contactsArray[i].getId()==contact.getId()) {
                contactsArray[i] = contact;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        for (int i = 0; i < contactsArray.length; i++) {
            if (contactsArray[i].getId()==id) {
                contactsArray[i] = null;
                lastIndex--;
                return true;
            }
        }
        return false;
    }
}
