package week1;

 /**
  * Created by mac on 4/1/18.
 */
public class ContactList {

    private static final int DEFAULT_SIZE = 1;
    private static int nextId = 1;
    private final int TOTAL_DIGITS_OF_NUMBER = 13;
    private Contact[] listOfContacts;

    public ContactList() {
        this.listOfContacts = new Contact[DEFAULT_SIZE];
    }

    public boolean addContact(Contact contact) {
        if (contactValidating(contact)) {
            contact.setContactId(nextId++);
            for (int i = 0; i < listOfContacts.length; i++) {
                if (listOfContacts[i] == null) {
                    listOfContacts[i] = contact;
                    System.out.println("This contact is added with id " + contact.getContactId());
                    return true;
                }
            }
            Contact[] newlistOfContacts = new Contact[listOfContacts.length * 2];
            for (int i = 0; i < listOfContacts.length; i++) {
                newlistOfContacts[i] = listOfContacts[i];
            }
            newlistOfContacts[listOfContacts.length] = contact;
            this.listOfContacts = newlistOfContacts;
            System.out.println("This contact is added with id " + contact.getContactId());
            return true;
        }
        return false;
    }

    public Contact[] findByNameOrNumber(String nameOrNumber) {
        int position = 0;
        Contact[] tmp = new Contact[listOfContacts.length];

        for (int i = 0; i <listOfContacts.length ; i++) {
            if (listOfContacts[i] != null && nameOrNumber != null && !nameOrNumber.isEmpty()
                    && (listOfContacts[i].getName().contains(nameOrNumber)
                    || listOfContacts[i].getNumber().contains(nameOrNumber))){
                position++;
                tmp[i]=listOfContacts[i];
            }
        }

        for (int j = 0; j < position ; j++) {
            System.out.println(tmp[j].getName() + tmp[j].getNumber());
        }

        if (position == 0){
            System.out.println("No matches found");
        }
        return tmp;
    }




    public boolean removeContact(int id) {
        if (id > nextId) {
            System.out.println("There isn't contact with this ID");
            return false;
        } else {
            for (int i = 0; i < listOfContacts.length; i++) {
                if (id > 0 && listOfContacts[i].getContactId() == id) {
                    listOfContacts[i] = null;
                    deleteFreeCell(i);
                    return true;
                }
            }
        }
        return false;
    }

    public Contact[] getAll() {
        for (int i = 0; i < nextId - 1; i++) {
            System.out.println("Contact Id " + listOfContacts[i].getContactId());
        }
        return listOfContacts;
    }

    private void deleteFreeCell(int i) {
        int nextAfterI = i + 1;
        Contact[] tmp = new Contact[listOfContacts.length];
        System.arraycopy(listOfContacts, 0, tmp, 0, i);
        System.arraycopy(listOfContacts, i + 1, tmp, i, (nextId - 1) - nextAfterI);
        listOfContacts = tmp;
        --nextId;
    }

    private boolean contactValidating(Contact contact) {
        if (contact.getNumber() == null || contact.getName() == null
                || contact.getName().isEmpty() || contact.getNumber().isEmpty()
                || contact.getNumber().length() < 3 || contact.getNumber().length() != TOTAL_DIGITS_OF_NUMBER
                || !contact.getNumber().substring(0, 3).equals("+38")) {
            System.out.println("Incorrect input of contact");
            return false;
        }
        return true;
    }
}
