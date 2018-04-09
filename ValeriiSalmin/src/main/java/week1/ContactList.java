package week1;

/**
 * Created by serhii on 31.03.18.
 */
public class ContactList {

    Contact[] contactArray = new Contact[100];


    public boolean addContact(Contact contact){
        if (isValidContact(contact)){
            Contact.n++;
            for (int i = 0; i < contactArray.length; i++) {
                if (contactArray[i]==null){
                    contactArray[i]=contact;
                    return true;
                }
            }
        }
        return false;
    }

    public Contact[] findByNameOrNumber(String nameOrNumber){
        Contact[] contactsFoundTemp = new Contact[contactArray.length];
        int iPoint=0;
        for (int i=0;i<contactArray.length;i++){
            if ((nameOrNumber==contactArray[i].getName())||(nameOrNumber==contactArray[i].getNumber())){
                contactsFoundTemp[i]=contactArray[i];
                iPoint=i;
            }
        }
        Contact[] contactsFound = new Contact[iPoint];
        for (int i=0;i<iPoint;i++) {
            contactsFound[i]=contactsFoundTemp[i];
        }
        return contactsFound;
    }

    public boolean removeContact(int id){
        boolean flag=false;
        for (int i=0;i<contactArray.length;i++){
            if (id==contactArray[i].getId()){
                Contact.n--;
                contactArray[i]=null;
                //return true;
                flag=true;
            }
        }
        Contact[] contactArrayTemp = new Contact[Contact.n];
        for (int i = 0; i < contactArray.length; i++) {
            if (contactArray[i]!=null) {
                contactArrayTemp[i]=contactArray[i];

            }
        }

        return flag;
    }

    public Contact[] getAll(){
        Contact[] contactArrayTemp = new Contact[Contact.n];
        System.arraycopy(contactArray,0,contactArrayTemp,0,Contact.n);
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
