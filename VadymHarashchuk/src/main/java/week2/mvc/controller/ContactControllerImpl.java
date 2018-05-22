package week2.mvc.controller;

import week2.mvc.dao.Dao;
import week2.mvc.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 15.04.18.
 */
public class ContactControllerImpl implements ContactController {

    private static int ID_COUNT = 1;
    private final Dao<Contact> contactDao;

    public ContactControllerImpl(Dao<Contact> contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public String addContact(Contact contact) {

        contactDao.create(contact);

        return contact.getId();
    }

    @Override
    public Contact removeContact(String id) {
        return contactDao.delete(id);
    }

    @Override
    public Contact[] findByKeyWord(String keyWord) {
        if (keyWord == null || keyWord.isEmpty()) {
            return new Contact[0];
        }

        String prepared = keyWord.trim().toLowerCase();

        Contact[] contacts = contactDao.all();

        List<Contact> resultList = new ArrayList<>();

        for (int i = 0; i < contacts.length; i++) {
            Contact curr = contacts[i];

            String name = curr.getName().toLowerCase();
            String number = curr.getNumber();
            if (name.startsWith(prepared) || number.contains(prepared)) {
                resultList.add(curr);
            }
        }

        /*return Arrays.stream(contactDao.all())
                .filter(cont -> cont.getName().startsWith(prepared) || cont.getNumber().contains(prepared))
                .collect(Collectors.toList())
                .toArray(new Contact[resultList.size()]);*/


        return resultList.toArray(new Contact[resultList.size()]);
    }

    @Override
    public Contact[] findDuplicates() {
        Contact[] contacts = contactDao.all();

        List<Contact> duplicates = new ArrayList<>();

        // java8
        for (int i = 0; i < contacts.length; i++) {
            for (int j = i + 1; j < contacts.length; j++) {
                if(contacts[i].getNumber().equals(contacts[j].getNumber())){
                    duplicates.add(contacts[i]);
                    duplicates.add(contacts[j]);
                }
            }
        }

        return duplicates.toArray(new Contact[duplicates.size()]);
    }

    @Override
    public Contact[] getAll() {
        return contactDao.all();
    }
}
