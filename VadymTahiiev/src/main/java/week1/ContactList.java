package week1;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * Created by serhii on 31.03.18.
 */
public class ContactList {

    private int size = 0;
    private Contact[] contactStorage;
    private Contact[] temporaryStorage;


    public ContactList() {
        contactStorage = new Contact[0];
    }

    public boolean addContact(Contact contact){
        if (contact == null) return false;
        if (!contact.getNumber().contains("+380")) return false;
        contactStorage = Arrays.copyOf(contactStorage, size + 1);
        contactStorage[size] = contact;
        size++;
        return true;
    }

    public Contact[] findByNameOrNumber(String nameOrNumber){
        if (nameOrNumber.contains("+380")) {
            temporaryStorage = new Contact[0];
            for (int i = 0; i < contactStorage.length; i++) {
                if (contactStorage[i].getNumber().contains(nameOrNumber)) {
                    temporaryStorage = Arrays.copyOf(temporaryStorage, temporaryStorage.length + 1);
                    temporaryStorage[temporaryStorage.length - 1] = contactStorage[i];
                }
            }
        } else {
            temporaryStorage = new Contact[0];
            for (int i = 0; i < contactStorage.length; i++) {
                if (contactStorage[i].getName().contains(nameOrNumber)) {
                    temporaryStorage = Arrays.copyOf(temporaryStorage, temporaryStorage.length + 1);
                    temporaryStorage[temporaryStorage.length - 1] = contactStorage[i]; }
            }
        }
        return temporaryStorage;
    }

    public boolean removeContact(int id){
        for (int i = 0; i < contactStorage.length; i++) {
            if (!contactStorage[i].getId().contains(Integer.toString(id))) {
                return false;
            } else {
                Contact[] arrayFirstPart = new Contact[i];
                Contact[] arraySecondPart = new Contact[contactStorage.length - i - 1];
                arrayFirstPart = Arrays.copyOf(contactStorage, i);
                arraySecondPart = Arrays.copyOfRange(contactStorage,i + 1, contactStorage.length);
                Contact[] ycontactStorage = new Contact[contactStorage.length - 1];
                for (int j = 0; j < contactStorage.length - 1; j++) {
                    if (j < arrayFirstPart.length) {
                        contactStorage[j] = arrayFirstPart[j];
                    } else {
                        contactStorage[j] = arraySecondPart[j];
                    }
                }
                contactStorage = Arrays.copyOf(contactStorage, contactStorage.length - 1);
            }
        }
        return true;
    }

    public Contact[] getAll(){
        return contactStorage;
    }
}

