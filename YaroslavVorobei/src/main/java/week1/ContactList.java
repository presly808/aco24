package week1;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * Created by y.vorobei on 31.03.18.
 */
public class ContactList {

    private static final int DEFAULT_CONTACT_LIST_SIZE = 15;
    private Contact[] tempContactsStore;
    private Contact[] contactsStore;
    private int size;
    private int removeContactIndex;

    public ContactList() {
        tempContactsStore = new Contact[DEFAULT_CONTACT_LIST_SIZE];
        removeContactIndex = 0;
    }

    public void clearContactsStore() {
        contactsStore = null;
        size = 0;
    }

    public boolean addContact(Contact contact) {
        if (contact == null) {
            System.out.println("Contact is NULL!!!");
            return false;
        }

        if (!contact.getNumber().substring(0, 3).equals("+38")) {
            return false;
        }

        if (size == tempContactsStore.length) {
            System.out.println("Contact list is already FULL!!!");
            return false;
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
        for (int i = 0; i < contactsStore.length; i++) {
            if (contactsStore[i].getId() == id) {
                return true;
            }
        }
        System.out.println("We don't have user with id = " + id);
        return false;
    }

    public Contact[] findByNameOrNumber(String param) {
        int counter = 0;
        Contact[] foundContactList;

        for (int i = 0; i < contactsStore.length; i++) {
            if (paramIsNumber(param) == true &&
                    validateNumberFormate(contactsStore[i].getNumber()).contains(param)) {
                tempContactsStore[i] = contactsStore[i];
                counter++;
            } else if (contactsStore[i].getName().equals(param)) {
                tempContactsStore[i] = contactsStore[i];
                counter++;
            }
        }

        foundContactList = Arrays.copyOf(tempContactsStore, counter);
        return foundContactList;
    }

    private boolean paramIsNumber(String param) {
        if (param == null) return false;
        return StringUtils.isNumericSpace(validateNumberFormate(param));
    }

    private String validateNumberFormate(String param) {
        if (param == null) return param;
        return param.substring(1);
    }

    public Contact[] getAll() {
        return contactsStore;
    }
}
