package week2.mvc.dao;

import week2.mvc.model.Contact;

/**
 * Created by serhii on 15.04.18.
 */
public interface ContactDao {

    boolean create(Contact contact) throws Exception;
    Contact read(int id) throws Exception;
    boolean update(Contact updatedContact) throws Exception;
    Contact delete(int id) throws Exception;

    Contact[] all();

}
