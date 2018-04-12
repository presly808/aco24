package week1;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * Created by y.vorobei on 31.03.18.
 */
public class ContactList {

    private final int DEFAULT_CONTACT_LIST_SIZE = 15;
    private Contact[] tempContactsStore = new Contact[DEFAULT_CONTACT_LIST_SIZE];
    private Contact[] contactsStore;
    private Contact[] listContactsByName;
    private int size;
    private int removeContactIndex = 0;

    public void clearContactsStore() {
        contactsStore = null;
        size = 0;
    }

    public boolean addContact(Contact contact) {
        if (!contact.getNumber().substring(0, 3).equals("+38")) {
            return false;
        }

        if (contact == null) {
            System.out.println("Contact is NULL!!!");
            return false;
        }

        if (size == tempContactsStore.length) {
            System.out.println("Contact list is already FULL!!!");
        }

        tempContactsStore[size] = contact;
        size++;

        contactsStore = Arrays.copyOf(tempContactsStore, size);

        return true;
    }

    public boolean removeContact(int id) {

        if (!findContactByID(id) || contactsStore.length == 0 || contactsStore == null) {
            return false;
        }

        for (int i = 0; i < contactsStore.length; i++) {
            if (contactsStore[i].getId() == id) {
                removeContactIndex = i;
            }
        }

        int lastContactIndex = contactsStore.length;

        Contact[] firstArrayPart = new Contact[removeContactIndex];
        System.arraycopy(contactsStore, 0, firstArrayPart, 0, removeContactIndex);

        removeContactIndex++;

        Contact[] secondArrayPart = new Contact[lastContactIndex - removeContactIndex];
        System.arraycopy(contactsStore, removeContactIndex, secondArrayPart, 0, contactsStore.length - removeContactIndex);

        contactsStore = null;
        contactsStore = new Contact[firstArrayPart.length + secondArrayPart.length];

        System.arraycopy(firstArrayPart, 0, contactsStore, 0, firstArrayPart.length);
        System.arraycopy(secondArrayPart, 0, contactsStore, firstArrayPart.length, secondArrayPart.length);

        return true;
    }

    private boolean findContactByID(int id) {
        boolean searchFlag = false;

        for (int i = 0; i < contactsStore.length; i++) {
            if (contactsStore[i].getId() == id) {
                return true;
            }
        }

        if (searchFlag == false) {
            System.out.println("We don't have user with id = " + id);
        }
        return searchFlag;
    }

    private Contact[] findContactByNumber(String number) {
        int counter = 0;
        for (int i = 0; i < contactsStore.length; i++) {
            if (contactsStore[i].getNumber().substring(1).contains(number)) {
                tempContactsStore[i] = contactsStore[i];
                counter++;
            }
            listContactsByName = Arrays.copyOf(tempContactsStore, counter);
        }
        return listContactsByName;
    }

    private Contact[] findContactByName(String name) {
        int counter = 0;
        for (int i = 0; i < contactsStore.length; i++) {
            if (contactsStore[i].getName().equals(name)) {
                tempContactsStore[i] = contactsStore[i];
                counter++;
            }
        }
        listContactsByName = Arrays.copyOf(tempContactsStore, counter);
        return listContactsByName;
    }

    public Contact[] findByNameOrNumber(String nameOrNumber) {

        if (StringUtils.isNumericSpace(nameOrNumber.substring(1))) {
            return findContactByNumber(nameOrNumber.substring(1));
        }

        return findContactByName(nameOrNumber);
    }


    public Contact[] getAll() {
        for (int i = 0; i < contactsStore.length; i++) {
            System.out.println("userID = " + contactsStore[i].getId());
        }
        return contactsStore;
    }
}
