package week1;

/**
 * Created by serhii on 31.03.18.
 */
public class ContactList {

    //private int defaultSize = 7;
    private Contact[] contacts = new Contact[10];
    private int size = 0;

    //private int[] serchName = new int [size];

    //public int getSize() {
    //     return size;
    //}


    public boolean addContact(Contact contact) {

        if (contact.getNumber().matches("^[a-zA-Z]+$")) return false;

        if (contact != null
                && contact.getId()!= 0 && contact.getName() != null
                && contact.getNumber() != null) {

            contacts[size] = contact;
            size++;
            return true;
        }
        return false;
    }

    public Contact[] findByNameOrNumber(String nameOrNumber) {
        Contact[] userSearch = new Contact[size];
        int users = 0;
        for (int i = 0; i < contacts.length; i ++) {
            if (contacts[i] != null ){
                if (contacts[i].getName().contains(nameOrNumber) ||
                        contacts[i].getNumber().contains(nameOrNumber)) {
                    userSearch[i] = contacts[i];
                    users++;
                }
            }
        }
        Contact[] usersFound = new Contact[users];
        for (int i = 0 ; i < usersFound.length; i ++ ) {
            usersFound[i] = userSearch[i];
        }
        return usersFound;
    }


    public boolean  removeContact(int id){
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                if (id == contacts[i].getId()) {
                    contacts[i] = null;
                    size--;

                    return true;
                }
            }

        }
        return false;
    }

    public Contact[] getAll() {
        Contact[] allUsers = new Contact[size];
        for (int i = 0; i < contacts.length; i++) {
            for (int k = 0; k < size; k ++){
                if (contacts[i] != null && allUsers[k] == null) {
                    allUsers[k] = contacts[i];
                }
            }
        }
        return allUsers;
    }
}
