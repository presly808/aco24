package week1;

import java.util.Arrays;

/**
 * Created by serhii on 31.03.18.
 */
public class ContactList {

    private Contact[] contactArray = new Contact[10];
    private int lastContactIndex = 0;
    private int phoneNumberSize = 13;

    public boolean addContact(Contact contact) {
        if (isValidContact(contact)) {
            if (lastContactIndex == contactArray.length - 1) {
                increaseArrayCapacity();
            }
            contactArray[lastContactIndex] = contact;
            lastContactIndex++;
            return true;
        }
        return false;
    }

    public Contact[] findByNameOrNumber(String nameOrNumber) {
        Contact[] contactsFoundTemp = new Contact[contactArray.length];
        int iPoint = 0;
        for (int i = 0; i < lastContactIndex; i++) {
            if (contactArray[i] != null) {
                if (contactArray[i].getNumber().contains(nameOrNumber) || contactArray[i].getName().contains(nameOrNumber)) {
                    contactsFoundTemp[iPoint] = contactArray[i];
                    iPoint++;
                }
            }
        }
        Contact[] contactsFound = Arrays.copyOf(contactsFoundTemp, iPoint);
        return contactsFound;
    }

    public boolean removeContact(int id) {
        for (int i = 0; i < lastContactIndex; i++) {
            if (contactArray[i] != null && id == contactArray[i].getId()) {
                contactArray[i] = null;
                lastContactIndex--;
                return true;
            }
        }
        return false;
    }

    public Contact[] getAll() {
        Contact[] contactArrayTemp = Arrays.copyOf(contactArray, lastContactIndex);
        return contactArrayTemp;
    }

    public boolean isValidContact(Contact contact) {
        if (contact != null && contact.getId() != 0 && contact.getName() != null && isValidNumber(contact.getNumber())) {
            return true;
        }
        return false;
    }

    public boolean isValidNumber(String number) {
        String regex = "\\d+";
        if ((number.length() == phoneNumberSize) && (number.substring(1).matches(regex))) {
            return true;
        }
        return false;
    }

    public void increaseArrayCapacity() {
        Contact[] increasedContactsArray = new Contact[contactArray.length + 10];
        System.arraycopy(contactArray, 0, increasedContactsArray, 0, contactArray.length);
        contactArray = increasedContactsArray;
    }
}
