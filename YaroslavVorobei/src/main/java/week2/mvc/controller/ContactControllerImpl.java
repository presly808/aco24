package week2.mvc.controller;

import org.apache.commons.lang3.StringUtils;
import week2.mvc.dao.ContactDao;
import week2.mvc.model.Contact;
import week2.mvc.validation.DataValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        // validation

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
    public Contact[] findByNameOrNumber(String keyWord) {
        int counter = 0;
        Contact[] tempContactsStore = new Contact[15];
        Contact[] contacts = contactDao.all();

        for (int i = 0; i < contacts.length; i++) {
            if (DataValidation.paramIsNumber(keyWord) == true &&
                    DataValidation.validateNumberFormate(contacts[i].getNumber()).contains(keyWord)) {
                tempContactsStore[i] = contacts[i];
                counter++;
            } else if (contacts[i].getName().equals(keyWord)) {
                tempContactsStore[i] = contacts[i];
                counter++;
            }
        }
        return Arrays.copyOf(tempContactsStore, counter);
    }

    @Override
    public Contact[] filterByCity(String cityName) {
        String prepared = DataValidation.validateStringValue(cityName).trim().toLowerCase();
        Contact[] contacts = contactDao.all();
        List<Contact> resultCityList = new ArrayList<>();

        for (int i = 0; i < contacts.length; i++) {
            Contact curr = contacts[i];
            String city = curr.getCity().toLowerCase();
            if (city.equals(prepared)) {
                resultCityList.add(curr);
            }
        }

        return resultCityList.toArray(new Contact[resultCityList.size()]);
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
    public boolean mergeContacts(Contact cont1, Contact cont2) {
        return false;
    }

    @Override
    public Contact[] findDuplicates() {
        Contact[] contacts = contactDao.all();

        List<Contact> duplicates = new ArrayList<>();

        // java8
        for (int i = 0; i < contacts.length; i++) {
            for (int j = i + 1; j < contacts.length; j++) {
                if (contacts[i].getNumber().equals(contacts[j].getNumber())) {
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
