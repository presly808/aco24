package exclude.week2.mvc.controller;

import exclude.week2.mvc.model.Contact;

/**
 * Created by serhii on 15.04.18.
 */
public interface ContactController {

    String addContact(Contact contact);

    Contact removeContact(String id);

    Contact[] findByKeyWord(String keyWord);

    Contact[] findDuplicates();

    Contact[] getAll();
}
