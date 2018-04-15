package week2.mvc.controller;

import week2.mvc.model.Contact;
import week2.mvc.model.DataModel;

import java.util.Arrays;

public class ContactControllerImpl implements ContactController {

    private DataModel dataModel;

    public ContactControllerImpl(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    public boolean addContact(Contact contact) {

        if (ValidatorContact.validateContact(contact)) {
            return dataModel.add(contact);
        }

        return false;
    }

    @Override
    public Contact[] findByNameOrNumber(String nameOrNumber) {
        Contact[] matched = new Contact[10];
        int index = 0;

        for (Contact contact : getAll()) {
            if (findContact(contact, nameOrNumber) != null) {
                matched[index++] = findContact(contact, nameOrNumber);
            }
        }
        return Arrays.copyOf(matched, index);
    }

    @Override
    public boolean removeContact(int id) {
        Contact[] list = getAll();
        for (int i = 0; i < list.length; i++) {
            if (list[i].getId() == id) {
                System.arraycopy(getAll(), i + 1, getAll(), i, list.length - 1 - i);
                dataModel.setSize(dataModel.getSize() - 1);
                list[list.length - 1] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Contact[] getAll() {
        return dataModel.get();
    }


    public Contact findContact(Contact contact, String nameOrNumber) {
        if (contact.getName().contains(nameOrNumber) || contact.getNumber().contains(nameOrNumber)) {
            return contact;
        }
        return null;
    }

//    public Contact findContact(Contact[] list, int id) {
//        for (Contact contact : list) {
//            if (contact.getId() == id) {
//                return contact;
//            }
//        }
//        return null;
//    }
}
