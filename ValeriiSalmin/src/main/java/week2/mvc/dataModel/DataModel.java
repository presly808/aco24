package week2.mvc.dataModel;

import week1.Contact;

public interface DataModel {

    public boolean create(Contact contact);

    public Contact[] read();

    public boolean update(Contact contact);

    public boolean delete(int id);
}
