package week1;

/**
 * Created by serhii on 31.03.18.
 */
public class ContactList {

    Contact[] contactArray = new Contact[10];
    int lastContactIndex = 0;

    public boolean addContact(Contact contact) {
        if (isValidContact(contact)) {
            //TODO: need check/increase array
            contactArray[lastContactIndex] = contact;
            lastContactIndex++;
            return true;
        }
        return false;
    }

    public Contact[] findByNameOrNumber(String nameOrNumber) {
        Contact[] contactsFoundTemp = new Contact[contactArray.length];
        int iPoint = 0;
        for (int i = 0; i < contactArray.length; i++) {
            if (contactArray[i] != null) {
                if (contactArray[i].getNumber().contains(nameOrNumber) || contactArray[i].getName().contains(nameOrNumber)) {
                    contactsFoundTemp[i] = contactArray[i];
                    iPoint++;
                }
            }
        }

        Contact[] contactsFound = new Contact[iPoint];
        for (int i = 0; i < contactsFound.length; i++) {
            contactsFound[i] = contactsFoundTemp[i];
        }
        return contactsFound;
    }

    public boolean removeContact(int id) {
        //TODO:
        for (int i = 0; i < contactArray.length; i++) {
            if (contactArray[i] != null) {
                if (id == contactArray[i].getId()) {
                    lastContactIndex--;
                    contactArray[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public Contact[] getAll() {
        Contact[] contactArrayTemp = new Contact[lastContactIndex];
        for (int i = 0; i < contactArray.length; i++) {
            for (int j = 0; j < lastContactIndex; j++) {
                if ((contactArray[i] != null) && (contactArrayTemp[j] == null)) {
                    contactArrayTemp[j] = contactArray[i];
                }
            }
        }
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

        if ((number.length() == 13) && (number.substring(1).matches(regex))) {
            return true;
        }
        return false;
    }
}
