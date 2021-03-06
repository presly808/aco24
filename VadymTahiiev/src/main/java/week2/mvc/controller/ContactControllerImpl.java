package week2.mvc.controller;

import week2.mvc.dao.ContactDao;
import week2.mvc.model.Contact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by serhii on 15.04.18.
 */
public class ContactControllerImpl implements ContactController {

    private static int ID_COUNT = 1;
    private final ContactDao contactDao;

    public ContactControllerImpl(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public int addContact(Contact contact) {

        // generate id
        int idCount = ID_COUNT;
        contact.setId(idCount);
        ID_COUNT++;

        contactDao.create(contact);

        return idCount;
    }

    @Override
    public Contact removeContact(int id) {
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
    public Contact[] filterByCity(String city) {
        Contact[] contacts = contactDao.all();
        List<Contact> resultList = new ArrayList<>();
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i].getNotes().toLowerCase().contains(city.toLowerCase())){
                resultList.add(contacts[i]);
            }
        }
        return resultList.toArray(new Contact[resultList.size()]);
    }

    @Override
    public Contact[] mergeContacts(Contact[] contacts1, Contact[] contacts2){
        Contact[] mergedContacts = new Contact[contacts1.length + contacts2.length];
        for (int i = 0; i < contacts1.length; i++) {
            mergedContacts[i] = contacts1[i];
        }
        int j = 0;
        for (int i = contacts1.length; i < mergedContacts.length; i++) {
            mergedContacts[i] = contacts2[j];
            j++;
        }
        return mergedContacts;
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
