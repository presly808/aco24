package week1;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by serhii on 31.03.18.
 */
public class ContactList {



    public ContactList(){
        this(DEFAULT_LIST_SIZE);
    }

    public ContactList(int size){
        Contact[] contactList = new Contact[size];
    }

    private static final int DEFAULT_LIST_SIZE = 50;
    private Contact[] contactList = new Contact[DEFAULT_LIST_SIZE];
    private int size;



    public boolean addContact(Contact contact){
        if(contact == null){
            return false;
        }

        if(contactList.length == size){
            System.out.println("Contact list is full");
            return false;
        }

        if(contact.getNumber().length() != 13){
            System.out.println("Enter valid phone number");
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

        for (int i = 0; i < contactList.length; i++) {
            if(contactList[i] != null &&
                    (contactList[i].getName().contains(nameOrNumber)
                            || contactList[i].getNumber().contains(nameOrNumber))
                    ){
                contactListResult[index++] = contactList[i];

            }
        }

        return contactListResult;
    }

    public boolean removeContact(int id){
        int count = 0;

        for (int i = 0; i < contactList.length; i++) {
            if(contactList[i] != null && contactList[i].getId() == id){
                contactList[i] = null;
                count++;
            }
        }

        if(count == 0) {
            return false;
        }

        return true;
    }

    public Contact[] getAll(){
        int count = 0;

        for (int i = contactList.length - 1; i >= 0 ; i--) {
            if(contactList[i] != null){
                moveElement(contactList, i);
            }
        }

        for (int i = 0; i < contactList.length; i++) {
            if (contactList[i] != null) {
                count++;
            }
        }

        return Arrays.copyOf(contactList, count);

    }

    private void moveElement(Contact[] contactList, int i) {
        for(int j = i - 1; j >= 0; j--){
            if(contactList[j] == null){
                Contact tmp = contactList[i];
                contactList[i] = contactList[j];
                contactList[j] = tmp;
            }
        }
    }

}
