package week1;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by serhii on 31.03.18.
 */
public class ContactList {

    private List<Contact> contactStorage;

    public ContactList() {
        contactStorage = new ArrayList<Contact>();
    }

    public boolean addContact(Contact contact){
        if (contact == null) return false;
        if (!contact.getNumber().contains("+380")) return false;
        return contactStorage.add(contact);
    }

    public Contact[] findByNameOrNumber(String nameOrNumber) {
        List<Contact> temporaryStorage = new ArrayList<>();
        for (int i = 0; i < contactStorage.size(); i++) {
            if (contactStorage.get(i).getNumber().contains(nameOrNumber) ||
                    contactStorage.get(i).getName().contains(nameOrNumber)) {
                temporaryStorage.add(contactStorage.get(i));
            }
        }
        return temporaryStorage.toArray(new Contact[temporaryStorage.size()]);
    }


    public boolean removeContact(int id){
        for (int i = 0; i < contactStorage.size(); i++) {
            if (contactStorage.get(i).getId() == id) {
                contactStorage.remove(i);
                return true;
            }
        }
        return false;
    }

    public Contact[] getAll(){
        return contactStorage.toArray(new Contact[contactStorage.size()]);
    }
}

