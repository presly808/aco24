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
        int INITIAL_SIZE = 10;
        Contact[] matched = new Contact[INITIAL_SIZE];
        int index = 0;

        for (Contact contact : getAll()) {
            Contact foundContact = findContact(contact, nameOrNumber);
            if (foundContact != null) {
                matched[index++] = foundContact;
            }
        }
        return Arrays.copyOf(matched, index);
    }

    @Override
    public Contact removeContact(int id) {
        Contact[] list = getAll();
        for (int i = 0; i < list.length; i++) {
            if (list[i].getId() == id) {
                Contact foundToRemove = list[i];
                System.arraycopy(getAll(), i + 1, getAll(), i, list.length - 1 - i);
                dataModel.setSize(dataModel.getSize() - 1);
                list[list.length - 1] = null;
                return foundToRemove;
            }
        }
        return null;
    }

    @Override
    public Contact[] getAll() {
        return dataModel.get();
    }


    @Override
    public Contact findContact(Contact contact, String nameOrNumber) {
        if (contact != null
                && nameOrNumber != null
                && !nameOrNumber.isEmpty()
                && (contact.getName().contains(nameOrNumber)
                || contact.getNumber().contains(nameOrNumber))) {
            return contact;
        }
        return null;
    }


}
