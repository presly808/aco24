package week1;

import java.util.Arrays;

/**
 * Created by serhii on 31.03.18.
 */
public class ContactList {

    private final int DEFAULT_SIZE = 10;
    private Contact[] contacts = new Contact[DEFAULT_SIZE];
    private int mainCounter = 0;



    public boolean addContact(Contact contact) {
        if (contact != null && contact.getNumber().length() == 13) {
            contacts[mainCounter] = contact;
            mainCounter++;
            return true;
        }
        if (contact.getNumber().matches("[0-9]")) return true;
        return false;
    }

    public Contact[] findByNameOrNumber(String nameOrNumber) {
        Contact[] tmp = new Contact[mainCounter];
        int userIndex = 0;

        for (int i = 0; i < contacts.length; i ++) {
            if(contacts[i] != null) {
                if (contacts[i].getName().contains(nameOrNumber) || contacts[i].getNumber().contains(nameOrNumber)) {
                    tmp[userIndex] = contacts[i];
                    userIndex++;
                }
            }
        }

        Contact[] res = Arrays.copyOf(tmp, userIndex);
        return res;
    }

    public boolean removeContact(int id){
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                if (id == contacts[i].getId()) {
                    contacts[i] = null;
                    mainCounter--;
                    return true;
                }
            }
        }

        return false;
    }

    public Contact[] getAll() {
        Contact[] res = new Contact[mainCounter];
        for (int i = 0; i < mainCounter; i++) {
            res[i] = contacts[i];
        }
        return res;
    }
}