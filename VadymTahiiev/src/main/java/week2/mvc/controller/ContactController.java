package week2.mvc.controller;

import week2.mvc.model.Contact;

/**
 * Created by serhii on 15.04.18.
 */
public interface ContactController {

    int addContact(Contact contact);

    Contact removeContact(int id);

    Contact[] findByKeyWord(String keyWord);

    Contact[] filterByCity(String city);

    Contact[] mergeContacts(Contact[] contacts1, Contact[] contacts2);

    Contact[] findDuplicates();

    Contact[] getAll();
}
