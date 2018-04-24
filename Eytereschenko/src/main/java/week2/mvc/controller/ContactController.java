package week2.mvc.controller;

import week2.mvc.model.Contact;

public interface ContactController {

    int addContact(Contact contact);

    Contact removeContact(int id);

    Contact[] findByKeyWord(String keyWord);

    Contact[] findDuplicates();

    Contact[] getAll();

    Contact[] mergeContacts(Contact[] contacts1, Contact[] contacts2);

    Contact[] findByCity(String city);

}
