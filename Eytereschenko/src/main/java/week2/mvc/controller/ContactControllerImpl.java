package week2.mvc.controller;

import week2.mvc.dao.ContactDao;
import week2.mvc.model.Contact;
import week2.mvc.model.ContactValidator;

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

        // validation
        if (!ContactValidator.validate(contact)) {
            return -1;
        }

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

    @Override
    public Contact[] mergeContacts(Contact[] contacts1, Contact[] contacts2) {

        //validation
        if (contacts1 == null) {
            if (contacts2 == null) {
                System.out.println("arrays are null!");
                return null;
            } else {
                System.out.println("1st list is null!");
                return contacts2;
            }
        } else if (contacts2 == null) {
            System.out.println("2nd list is null");
            return contacts1;
        }


        List<Contact> list = new ArrayList<>();
        for (int i = 0; i < contacts1.length; i++) {
            list.add(contacts1[i]);
        }

        for (int i = 0; i < contacts2.length; i++) {
            if (!list.contains(contacts2[i])) {
                list.add(contacts2[i]);
            }
        }

        return list.toArray(new Contact[list.size()]);
    }

    @Override
    public Contact[] findByCity(String city) {

        if (city == null || city.isEmpty()) {
            System.out.println("please, enter correct city");
            return new Contact[0];
        }

        String cityToBeFind = city.toLowerCase().trim();

        Contact[] contacts = contactDao.all();

        List<Contact> list = new ArrayList<>();

        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i].getNotes().toLowerCase().equals(cityToBeFind)) {
                list.add(contacts[i]);
            }
        }

        return list.toArray(new Contact[list.size()]);
    }


}
