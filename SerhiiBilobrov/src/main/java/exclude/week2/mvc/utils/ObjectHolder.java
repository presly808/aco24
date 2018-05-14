package exclude.week2.mvc.utils;

import com.google.gson.Gson;
import exclude.week2.mvc.controller.ContactController;
import exclude.week2.mvc.controller.ContactControllerImpl;
import exclude.week2.mvc.controller.UserController;
import exclude.week2.mvc.controller.UserControllerImpl;
import exclude.week2.mvc.dao.ContactDaoImpl;
import exclude.week2.mvc.dao.DbContainer;
import exclude.week2.mvc.dao.UserDaoImpl;
import exclude.week2.mvc.model.Contact;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by serhii on 13.05.18.
 */
public final class ObjectHolder {

    private static final Map<String, Object> objectsMap = new HashMap<>();

    static {
        objectsMap.put("gson", new Gson());
        objectsMap.put("db", new DbContainer());

        ContactController contactController = new ContactControllerImpl(new ContactDaoImpl());
        contactController.addContact(new Contact("support", "+380931212345"));
        contactController.addContact(new Contact("admin", "+380674592345"));

        objectsMap.put("contactController", contactController);


        UserController userController = new UserControllerImpl(new UserDaoImpl());
        objectsMap.put("userController", userController);

    }

    public static<T> T getBean(String name){
        return (T) objectsMap.get(name);
    }

}
