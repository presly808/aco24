package exclude.week2.mvc.dao;

import exclude.week2.mvc.model.Contact;
import exclude.week2.mvc.utils.NumberUtil;
import exclude.week2.mvc.utils.ObjectHolder;

/**
 * Created by serhii on 15.04.18.
 */
// TODO: 13.05.18 add exceptions
public class ContactDaoImpl implements Dao<Contact> {

    private DbContainer container = (DbContainer) ObjectHolder.getBean("db");

    public ContactDaoImpl() {
    }

    @Override
    public boolean create(Contact contact) {
        contact.setId(NumberUtil.generateId());
        return container.contactList.add(contact);
    }

    @Override
    public Contact read(String id) { // TODO: 13.05.18 add exceptions
        return container.contactList.stream()
                        .filter(contact -> contact.getId().equals( id))
                        .findFirst().orElseGet(null);
    }

    @Override
    public boolean update(Contact updatedContact) {
        int indexInArr = container.contactList.indexOf(updatedContact);

        if(indexInArr == -1){
            return false;
        }

        container.contactList.set(indexInArr, updatedContact);

        return true;
    }

    @Override
    public Contact delete(String id) {
        Contact contact = read(id);

        if(contact == null){
            return null;
        }

        container.contactList.remove(contact);

        return contact;
    }

    @Override
    public Contact[] all() { // pagination
        return container.contactList.toArray(new Contact[container.contactList.size()]);
    }
}
