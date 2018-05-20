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
    public int addContact(Contact contact) throws Exception {

        int idCount = ID_COUNT;
        contact.setId(idCount);
        ID_COUNT++;
        contactDao.create(contact);
        return idCount;
    }

    @Override
    public Contact removeContact(int id) throws Exception  {
        return contactDao.delete(id);
    }

    @Override
    public Contact[] findByKeyWord(String keyWord) throws Exception {
        if (keyWord == null || keyWord.isEmpty()) {
            throw new Exception();
        }

        String prepared = keyWord.trim().toLowerCase();

        List<Contact> resultList = new ArrayList<>();

        Contact[] result = Arrays.stream(contactDao.all())
                .filter(cont -> cont.getName().startsWith(prepared) ||
                        cont.getNumber().contains(prepared))
                .collect(Collectors.toList())
                .toArray(new Contact[resultList.size()]);


        return result;
    }
    @Override
    public Contact[] filterByCity(String city) throws Exception {
        if (city == null || city.isEmpty()) {
            throw new Exception();
        }
        String prepared = city.trim().toLowerCase();
        List<Contact> resultList = new ArrayList<>();

        Contact[] result = Arrays.stream(contactDao.all())
                .filter(cont -> cont.getNotes().startsWith(prepared))
                .collect(Collectors.toList())
                .toArray(new Contact[resultList.size()]);


        return result;
    }

    @Override
    public Contact[] mergeContacts(Contact[] contacts1, Contact[] contacts2) throws Exception {
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

        List<Contact> duplicates = new ArrayList<>();

        Contact[] result = Arrays.stream(contactDao.all())
                .distinct()
                .collect(Collectors.toList())
                .toArray(new Contact[duplicates.size()]);

        return result;
    }

    @Override
    public Contact[] getAll() {
        return contactDao.all();
    }
}
