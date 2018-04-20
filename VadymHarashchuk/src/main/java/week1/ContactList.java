package week1;

/**
 * Created by serhii on 31.03.18.
 */

import java.util.Arrays;

public class ContactList {

    private Contact[] allContacts = new Contact[2];
    private int lastIndex = 0;

    public boolean addContact(Contact contact) {

        if (validateNameIsCorrect(contact) && validatePhoneIsCorrect(contact)) {
            if (lastIndex == allContacts.length - 1) {
                Contact[] resized = new Contact[allContacts.length + 10];
                System.arraycopy(allContacts, 0, resized, 0, allContacts.length);
                allContacts = resized;
            }

            allContacts[lastIndex++] = new Contact(contact.getId(), contact.getName(), contact.getNumber());

            return true;
        }
        return false;
    }

    public Contact[] findByNameOrNumber(String nameOrNumber) {
        Contact[] matched = new Contact[1];
        int index = 0;

        for (Contact contact : getAll()) {
            if (contact.getName().contains(nameOrNumber) || contact.getNumber().contains(nameOrNumber)) {
                if (index == matched.length - 1) {
                    Contact[] resized = new Contact[matched.length + 1];
                    System.arraycopy(matched, 0, resized, 0, matched.length);
                    matched = resized;
                }
                matched[index++] = new Contact(contact.getId(), contact.getName(), contact.getNumber());
            }
        }
        return Arrays.copyOf(matched, index);
    }


    public boolean removeContact(int id) {
        Contact[] list = getAll();
        for (int i = 0; i < list.length; i++) {
            if (list[i].getId() == id) {
                System.arraycopy(allContacts, i + 1, allContacts, i, list.length - 1 - i);
                lastIndex--;
                list[list.length - 1] = null;
                return true;
            }
        }
        return false;
    }

    public Contact[] getAll() {
        return Arrays.copyOf(allContacts, lastIndex);
    }

    public boolean validateNameIsCorrect(Contact contact) {
        return !(contact.getName().isEmpty()
                || contact.getNumber().isEmpty()
                || contact.getName() == null
                || contact.getNumber() == null);
    }

    public boolean validatePhoneIsCorrect(Contact contact) {
        return !(contact.getNumber().matches("[a-zA-Z]*")
                || contact.getNumber().contains("?!@#$%^&*~`.,<>/\\|")
                || contact.getNumber().length() < 10);
    }

}

