package exclude.week2.mvc.controller;

import exclude.week2.mvc.model.Contact;

/**
 * Created by serhii on 15.04.18.
 */
public interface ContactController {

    int addContact(Contact contact);

    Contact removeContact(int id);

    Contact[] findByKeyWord(String keyWord);

    Contact[] findDuplicates();

    Contact[] getAll();

    Contact[] filterByCity(String city);

    Contact[] filterByNameOrNumber(String name, String number);
}
