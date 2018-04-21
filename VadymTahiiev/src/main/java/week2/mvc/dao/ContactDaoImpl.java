package week2.mvc.dao;

import week2.mvc.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 15.04.18.
 */
public class ContactDaoImpl implements ContactDao {

    private final List<Contact> arrayList;

    public ContactDaoImpl() {
        this.arrayList = new ArrayList<>();
    }

    @Override
    public boolean create(Contact contact) {
        return arrayList.add(contact);
    }

    @Override
    public Contact read(int id) {

        // java8
        for (int i = 0; i < arrayList.size(); i++) {
            Contact contact = arrayList.get(i);
            if(contact.getId() == id){
                return contact;
            }
        }

        // arrayList.stream().filter(contact -> contact.getId() == id).findFirst().orElseGet(null);

        return null;
    }

    @Override
    public boolean update(Contact updatedContact) {
        int indexInArr = arrayList.indexOf(updatedContact);

        if(indexInArr == -1){
            return false;
        }

        arrayList.set(indexInArr, updatedContact);

        return true;
    }

    @Override
    public Contact delete(int id) {
        Contact contact = read(id);

        if(contact == null){
            return null;
        }

        arrayList.remove(contact);

        return contact;
    }

    @Override
    public Contact[] all() { // pagination
        return arrayList.toArray(new Contact[arrayList.size()]);
    }
}
