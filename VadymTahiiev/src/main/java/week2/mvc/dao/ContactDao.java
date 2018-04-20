package week2.mvc.dao;

import week2.mvc.model.Contact;

/**
 * Created by serhii on 15.04.18.
 */
public interface ContactDao {

    boolean create(Contact contact);
    Contact read(int id);
    boolean update(Contact updatedContact);
    Contact delete(int id);
    Contact[] all();

}
