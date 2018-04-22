package week1;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by serhii on 31.03.18.
 */
public class ContactList {

    private static final int DEFAULT_LIST_SIZE = 50;
    private Contact[] contactList = new Contact[DEFAULT_LIST_SIZE];
    private int size;


    public ContactList(){
        this(DEFAULT_LIST_SIZE);
    }

    public ContactList(int size){
        Contact[] contactList = new Contact[size];
    }

    public boolean addContact(Contact contact){
        if(contact == null){
            return false;
        }

        if(contactList.length == size){
            System.out.println("Contact list is full");
            return false;
        }

        if(!contact.getNumber().matches("[+][0-9]{12}")){
            System.out.println("Enter valid phone number");
            return false;
        }

        if(contact.getName().isEmpty()){
            System.out.println("Enter valid Name");
            return false;
        }

        contactList[size++] = contact;


        return true;
    }


    public Contact[] findByNameOrNumber(String nameOrNumber){
        int count = 0;

        for (int i = 0; i < contactList.length; i++) {
            if(contactList[i] != null &&
                    (contactList[i].getName().contains(nameOrNumber)
                            || contactList[i].getNumber().contains(nameOrNumber))
                    ){
                count++;
            }
        }

        if (count == 0) {
            return null;
        }

        Contact[] contactListResult = new Contact[count];

        int index = 0;

        for (int i = 0; contactList[i] != null && i < contactList.length; i++) {
            if(
                    (contactList[i].getName().contains(nameOrNumber)
                            || contactList[i].getNumber().contains(nameOrNumber))
                    ){
                contactListResult[index++] = contactList[i];

            }
        }

        return contactListResult;
    }

    public boolean removeContact(int id){
        int check = 0;

        for (int i = 0; i < contactList.length && contactList[i] != null; i++) {
            if(contactList[i].getId() == id){
                contactList[i] = null;
                check++;
            }
        }

        if(check == 0) {
            return false;
        }

        size--;

        return true;
    }

    public Contact[] getAll(){
        Contact[] contactListRes = new Contact[size];
        int index = 0;
        for (int i = 0; i < DEFAULT_LIST_SIZE; i++) {
            if(contactList[i] != null){
                contactListRes[index] = contactList[i];
                index++;
            }
        }

        return contactListRes;

    }

}
