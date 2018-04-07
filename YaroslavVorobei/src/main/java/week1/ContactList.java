package week1;

import java.util.Arrays;

import static java.awt.SystemColor.info;

/**
 * Created by y.vorobei on 31.03.18.
 */
public class ContactList {

    private static final int DEFAULT_CONTACT_LIST_SIZE = 15;
    private static Contact[] tempContactsStore = new Contact[DEFAULT_CONTACT_LIST_SIZE];
    private static Contact[] contactsStore;
    private static int size;
    private static int removeContactIndex = 0;

    public static boolean addContact(Contact contact){
        //contactsStore = new Contact[DEFAULT_CONTACT_LIST_SIZE];
        if(!contact.getNumber().substring(0,3).equals("+38")){
            return false;
        }

        if(contact == null){
            System.out.println("Contact is NULL!!!");
            return false;
        }

        if(size == tempContactsStore.length){
            System.out.println("Contact list is already FULL!!!");
        }

        tempContactsStore[size] = contact;
        size++;

        contactsStore = Arrays.copyOf(tempContactsStore, size);

        return true;
    }


    public Contact[] findByNameOrNumber(String nameOrNumber){
        return null;
    }


    public static boolean removeContact(int id){

         if(!findContactByID(id) || contactsStore.length == 0 || contactsStore == null){
            return false;
         }

        for (int i = 0; i < contactsStore.length; i++) {
            if(contactsStore[i].getId() == id){
                removeContactIndex = i;
            }
        }

        int lastContactIndex = contactsStore.length;

        Contact[] firstArrayPart = new Contact[removeContactIndex];
        System.arraycopy(contactsStore, 0, firstArrayPart, 0, removeContactIndex);

        removeContactIndex++;

        Contact[] secondArrayPart = new Contact[lastContactIndex - removeContactIndex];
        System.arraycopy(contactsStore, removeContactIndex, secondArrayPart, 0, contactsStore.length - removeContactIndex);

        contactsStore = null;
        contactsStore = new Contact[firstArrayPart.length + secondArrayPart.length];

        System.arraycopy(firstArrayPart, 0, contactsStore, 0, firstArrayPart.length);
        System.arraycopy(secondArrayPart, 0, contactsStore, firstArrayPart.length, secondArrayPart.length);

        return true;
    }

    private static boolean findContactByID(int id){
        boolean searchFlag = false;

        for (int i = 0; i < contactsStore.length; i++) {
            if(contactsStore[i].getId() == id){
                return true;
            }
        }

        if(searchFlag == false) {
            System.out.println("We don't have user with id = " + id);
        }
        return searchFlag;
    }

    private static Contact findContactById(int id){
        for (int i = 0; i < contactsStore.length; i++) {
            if(contactsStore[i].getId() == id){
                return contactsStore[i];
            }
        }
        System.out.println("We don't have user with id = " + id);
        return null;
    }

    private static Contact findContactByName(String name){
        for (int i = 0; i < contactsStore.length; i++) {
            if(contactsStore[i].getName().equals(name)){
                return contactsStore[i];
            }
        }
        System.out.println("We don't have user with name = " + name);
        return null;
    }


    public Contact[] getAll(){
        for (int i = 0; i < contactsStore.length; i++) {
            System.out.println("userID = " + contactsStore[i].getId());
        }
        return contactsStore;
    }



    public static void main(String[] args) {

        Contact user1 = new Contact(1, "Lolia", "+380933091219");
        Contact user2 = new Contact(2, "Ivan", "+38093");
        Contact user3 = new Contact(3, "Oleg", "+380933091233");
        Contact user4 = new Contact(4, "Olga", "+380933091234");

        addContact(user1);
        addContact(user2);
        addContact(user3);
        addContact(user4);

        removeContact(3);


    /*    int[] arr = {1, 2, 3, 4, 5};

        int lastContactIndex = arr.length;
        int removeContactIndex = 2;

        int[] secondArrayPart = new int[lastContactIndex - removeContactIndex];

        System.out.println("size second arr = " + secondArrayPart.length);
        System.arraycopy(arr, 1, secondArrayPart, 1, 2);


        for (int i = 0; i < secondArrayPart.length; i++) {
            System.out.println("--> " + secondArrayPart[i]);
        } */
        }
    //}


   // }
}
