package week2.mvc.controller;

import week2.mvc.model.Contact;

public interface ContactController {

    boolean addContact(Contact contact);

    Contact[] findByNameOrNumber(String nameOrNumber);

    Contact removeContact(int id);

    Contact[] getAll();

    Contact findContact(Contact contact, String nameOrNumber);

}
