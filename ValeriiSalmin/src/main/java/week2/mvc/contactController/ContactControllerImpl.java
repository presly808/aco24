package week2.mvc.contactController;

import week1.Contact;
import week2.mvc.dataModel.DataModel;
import week2.mvc.dataModel.DataModelImpl;

public class ContactControllerImpl implements ContactController {

    private final DataModel dataModel;

    public ContactControllerImpl(DataModel dataModel){
        this.dataModel = dataModel;
    }

    @Override
    public boolean addContact(Contact contact) {
       if (contact != null){
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
        return new Contact[0];
    }

    @Override
    public Contact[] getAll() {
        return dataModel.read();
    }
}
