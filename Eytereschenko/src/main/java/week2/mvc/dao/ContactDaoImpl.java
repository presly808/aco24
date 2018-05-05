package week2.mvc.dao;

import week2.mvc.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;


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

        return arrayList.stream().filter(contact -> contact.getId() == id).findFirst().orElse(null);

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

        Contact res = arrayList.stream().filter(contact -> contact.getId() == id).findFirst().orElse(null);
        arrayList.removeIf(contact -> contact.getId() == id);
        return res;

    }

    @Override
    public Contact[] all() { // pagination
        return arrayList.toArray(new Contact[arrayList.size()]);

    }
}
