package week1;

/**
 * Created by serhii on 31.03.18.
 */
public class ContactList {

    private int defaultSize = 10;
    private Contact[] contacts = new Contact[defaultSize];
    private int size = 0;

    public boolean addContact(Contact contact) {

        if (contact.getNumber().matches("[0-9]")) return true;
        if (contact != null
                && contact.getId()!= 0
                && contact.getName() != null
                && contact.getNumber() != null
                && contact.getNumber().length() == 13
                && size <= defaultSize) {
            contacts[size] = contact;
            size++;
            return true;
        }
        return false;
    }

    public Contact[] findByNameOrNumber(String nameOrNumber) {
        Contact[] indexUserSearch = new Contact[size];
        int userIndex = 0;
        for (int i = 0; i < contacts.length && contacts[i] != null ; i ++) {
                if (contacts[i].getName().contains(nameOrNumber) ||
                        contacts[i].getNumber().contains(nameOrNumber)) {
                    indexUserSearch[userIndex] = contacts[i];
                    userIndex++;
                }
        }
        Contact[] indexUsersFound = new Contact[userIndex];
        for (int i = 0 ; i < indexUserSearch.length; i ++ ) {
            indexUserSearch[i] = indexUserSearch[i];
        }
        return indexUsersFound;
    }

    public boolean removeContact(int id){
        for (int i = 0; i < contacts.length && contacts[i] != null; i++) {
                if (id == contacts[i].getId()) {
                    contacts[i] = null;
                    size--;
                    return true;
                }
        }
        return false;
    }

    public Contact[] getAll() {
        Contact[] allUsers = new Contact[size];
        for (int i = 0; i < size; i++) {
            allUsers[i] = contacts[i];
        }
        return allUsers;
    }
}
