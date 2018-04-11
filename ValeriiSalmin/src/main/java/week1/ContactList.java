package week1;

/**
 * Created by serhii on 31.03.18.
 */
public class ContactList {

    Contact[] contactArray = new Contact[10];
    int n;

    public boolean addContact(Contact contact){
        if (isValidContact(contact)){
            n++;
            for (int i = 0; i < contactArray.length; i++) {
                if (contactArray[i]==null){
                    contactArray[i]=contact;
                    return true;
                }
            }
        }
        return false;
    }

    public Contact[] findByNameOrNumber(String nameOrNumber) {
        Contact[] contactsFoundTemp = new Contact[contactArray.length];
        int iPoint = 0;
        for (int i = 0; i < contactArray.length; i++) {
            if (contactArray[i] != null) {
                if (contactArray[i].getNumber().contains(nameOrNumber)) {
                    contactsFoundTemp[i] = contactArray[i];
                    iPoint = i;
                }
            }
        }

        Contact[] contactsFound = new Contact[iPoint+1];
        for (int i = 0; i < contactsFound.length; i++) {
            contactsFound[i] = contactsFoundTemp[i];
        }
        return contactsFound;
    }

    public boolean removeContact(int id){
        for (int i=0;i<contactArray.length;i++) {
            if (contactArray[i] != null) {
                if (id == contactArray[i].getId()) {
                    n--;
                    contactArray[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public Contact[] getAll(){
        Contact[] contactArrayTemp = new Contact[n];
        for (int i = 0; i < contactArray.length; i++) {
            for (int j=0;j<n;j++) {
                if ((contactArray[i] != null)&&(contactArrayTemp[j]==null)) {
                    contactArrayTemp[j] = contactArray[i];
                }
            }
        }
        return contactArrayTemp;
    }

    public boolean isValidContact(Contact contact){
        if ((contact.getId()!=0)&&(contact.getName()!=null)&&isValidNumber(contact.getNumber())){
            return true;
        }
        return false;
    }

    public boolean isValidNumber(String number){

        String regex = "\\d+";

        if ((number.length()==13)&&(number.substring(1).matches(regex))){
            return true;
        }
        return false;
    }
}
