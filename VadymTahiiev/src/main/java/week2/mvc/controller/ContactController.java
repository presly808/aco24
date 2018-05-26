package week2.mvc.controller;

import week2.mvc.model.Contact;

/**
 * Created by serhii on 15.04.18.
 */
public interface ContactController {

    int addContact(Contact contact) throws Exception;

    Contact removeContact(int id) throws Exception;

    Contact[] findByKeyWord(String keyWord) throws Exception;

    Contact[] filterByCity(String city) throws Exception;

    Contact[] mergeContacts(Contact[] contacts1, Contact[] contacts2) throws Exception;;

    Contact[] findDuplicates();

    Contact[] getAll();
}
