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
    public boolean create(Contact contact) throws Exception {
        return arrayList.add(contact);
    }

    @Override
    public Contact read(int id) throws Exception{
        Contact result = arrayList.stream().
                filter(contact -> contact.getId() == id).
                findFirst().orElseGet(null);
        if (result == null) {
            throw new Exception();
        } else {
            return result;
        }
    }

    @Override
    public boolean update(Contact updatedContact) throws Exception{
        int indexInArr = arrayList.indexOf(updatedContact);

        if(indexInArr == -1){
            throw new Exception();
        }

        arrayList.set(indexInArr, updatedContact);

        return true;
    }

    @Override
    public Contact delete(int id) throws Exception{
        Contact contact = read(id);

        if(contact == null){
            throw new Exception();
        }

        arrayList.remove(contact);

        return contact;
    }

    @Override
    public Contact[] all() {
        return arrayList.toArray(new Contact[arrayList.size()]);
    }
}
