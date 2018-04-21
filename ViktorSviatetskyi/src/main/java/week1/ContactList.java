package week1;

/**
 * Created by serhii on 31.03.18.
 */
public class ContactList {

    private static final int DEFAULT_CONTACTLIST_SIZE = 20;
    private int phoneSize = 13;
    private int arrSize = 0;

    private Contact[] contactList = new Contact[DEFAULT_CONTACTLIST_SIZE];

    public boolean addContact(Contact contact) {

        if (!isValidContact(contact)) {
            System.out.println("Not valid contact");
            return false;
        } else if (arrSize >= contactList.length - 1) {
            System.out.println("No free space for new contact");
            return false;
        } else contactList[arrSize] = contact;
        arrSize++;
        return true;
    }


    public Contact[] findByNameOrNumber(String nameOrNumber) {

        int counter = 0;
        for (int i = 0; i < contactList.length; i++) {
            if (contactList[i] != null &&
                    (contactList[i].getName().contains(nameOrNumber) ||
                            contactList[i].getNumber().contains(nameOrNumber))
                    ) {
                counter++;
            }
        }
        if (counter == 0) {
            return null;
        }
        Contact[] resalt = new Contact[counter];

        int resIndex = 0;
        for (int i = 0; i < contactList.length; i++) {
            if (contactList[i] != null &&
                    (contactList[i].getName().contains(nameOrNumber) ||
                            contactList[i].getNumber().contains(nameOrNumber))
                    ) {
                resalt[resIndex++] = contactList[i];
            }
        }
        return resalt;
    }

    public boolean removeContact(int id) {
        for (int i = 0; i < arrSize; i++) {
            if (contactList[i] != null && id == contactList[i].getId()) {
                contactList[i] = null;
                arrSize--;
                return true;
            }
        }
        return false;
    }

    public Contact[] getAll() {
        Contact[] result = new Contact[arrSize];
        int notEmpty = 0;
        for (int i = 0; i < DEFAULT_CONTACTLIST_SIZE; i++) {
            if (contactList[i] != null) {
                result[notEmpty] = contactList[i];
                notEmpty++;
            }

        }
        return result;
    }


    private boolean isValidContact(Contact contact) {
        if (contact != null &&
                contact.getId() != 0 &&
                contact.getName() != null &&
                (contact.getNumber().matches("[+][0-9]{12}"))
            //isValidPhone(contact.getNumber())
                ) {
            return true;
        }

        return false;
    }

  /*  private boolean isValidPhone(String number) {
        String num = "\\d";
        if (number.length() == phoneSize &&
                number.substring(0, 1).equals("+") &&
                number.substring(1).matches(num)) {
            return true;
        }
        return false;
    }*/

}
