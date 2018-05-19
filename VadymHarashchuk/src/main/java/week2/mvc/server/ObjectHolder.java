package week2.mvc.server;

import com.google.gson.Gson;
import week2.mvc.controller.ContactController;
import week2.mvc.controller.ContactControllerImpl;
import week2.mvc.dao.DbContainer;
import week2.mvc.model.Contact;
import week2.mvc.model.DataModelImpl;

import java.util.HashMap;
import java.util.Map;

public final class ObjectHolder {

    private static final Map<String, Object> objectsMap = new HashMap<>();

    static {

        objectsMap.put("db", new DbContainer());
        objectsMap.put("gson", new Gson());

        ContactController contactController = new ContactControllerImpl(new DataModelImpl());
        contactController.addContact(new Contact(1,"support", "+380501234567"));
        objectsMap.put("contactController", contactController);

    }
    public static Object getBean(String name){
        return  objectsMap.get(name);
    }
}
