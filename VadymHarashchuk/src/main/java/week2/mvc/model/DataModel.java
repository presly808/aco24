package week2.mvc.model;

public interface DataModel {

    boolean add(Contact contact);

    Contact remove(int id);

    Contact[] get();

    int getSize();

    void setSize(int size);

}
