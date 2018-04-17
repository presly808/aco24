package week2.mvc.contactController;

import week1.Contact;
import week2.mvc.dataModel.DataModelImpl;

import java.util.Arrays;

public class ContactControllerImpl implements ContactController {

    private final DataModelImpl dataModel;

    public ContactControllerImpl(DataModelImpl dataModel){
        this.dataModel = dataModel;
    }

    @Override
    public boolean addContact(Contact contact) {
        if (isContactValid(contact)) {
            if (dataModel.getLastContactIndex() == dataModel.getContactsArray().length) {
                increaseArrayCapacity();
            }
            dataModel.create(contact);
        }
        return false;
    }

    @Override
    public boolean removeContact(int id) {
        return dataModel.delete(id);
    }

    @Override
    public Contact[] findByNameOrNumber(String nameOrNumber) {
        Contact[] tempFoundContactsArray = new Contact[dataModel.getLastContactIndex()];
        int iPoint=0;
        for (int i = 0; i < tempFoundContactsArray.length; i++) {
            if (dataModel.getContactsArray()[i].getName().toLowerCase().contains(nameOrNumber.toLowerCase())||dataModel.getContactsArray()[i].getNumber().contains(nameOrNumber)){
                tempFoundContactsArray[i] = dataModel.getContactsArray()[i];
                iPoint++;
            }
        }
        return Arrays.copyOf(tempFoundContactsArray,iPoint);
    }

    @Override
    public Contact[] getAll() {
        return dataModel.read();
    }

    public void increaseArrayCapacity(){
        Contact[] increasedArray = new Contact[dataModel.getContactsArray().length+10];
        System.arraycopy(dataModel.getContactsArray(),0,increasedArray,0,dataModel.getContactsArray().length);
        dataModel.setContactsArray(increasedArray);
    }

    public boolean isContactValid(Contact contact){
        if (contact != null && isNumberValid(contact.getNumber())){
            return true;
        }
        return false;
    }

    public boolean isNumberValid(String number){
        String regex = "\\d+";
        if (number.length() == 13&&number.substring(1).matches(regex)){
            return true;
        }
        return false;
    }
}
