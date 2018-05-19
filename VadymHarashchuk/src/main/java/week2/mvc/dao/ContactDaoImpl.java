package week2.mvc.dao;

import week2.mvc.model.Contact;
import week2.mvc.server.ObjectHolder;

public class ContactDaoImpl implements Dao<Contact> {

    private DbContainer container = (DbContainer) ObjectHolder.getBean("db");


    public ContactDaoImpl(){

    }

    public boolean create(Contact contact) {
        return false;
    }

    public Contact read(String id) {
        return null;
    }

    public boolean update(Contact contact) {
        return false;
    }

    public Contact delete(int id) {
        return null;
    }

    public Contact[] all() {
        return new Contact[0];
    }
}
