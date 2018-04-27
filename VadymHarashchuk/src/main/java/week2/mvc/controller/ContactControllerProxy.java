package week2.mvc.controller;

import week2.mvc.model.Contact;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ContactControllerProxy {

    private ContactController controller;
    private final String username;
    private final String password;
    private String accessKey;

    private final static Map<String, String> passwords = new HashMap<>();

    static {
        passwords.put("Vadym", "123456");
        passwords.put("Valerii", "qwerty");
        passwords.put("Serhii", "123123");
    }


    public ContactControllerProxy(ContactController controller, String username, String password) {
        this.controller = controller;
        this.username = username;
        this.password = password;
    }

    public boolean login() {
        for (Map.Entry<String, String> pair : passwords.entrySet()) {
            if (pair.getKey().equals(username) && pair.getValue().equals(password)) {
                setAccessKey(Base64.getEncoder().encodeToString(password.getBytes())
                        + Base64.getEncoder().encodeToString(username.getBytes())
                        + Base64.getEncoder().encodeToString(new Date().toString().getBytes()));
                return true;
            }
        }
        return false;
    }


    public boolean addContact(Contact contact) {
        if (accessKey != null) {
            return controller.addContact(contact);
        }
        return false;
    }


    public Contact[] findByNameOrNumber(String nameOrNumber) {
        if (accessKey != null) {
            return controller.findByNameOrNumber(nameOrNumber);
        }
        return new Contact[0];
    }


    public Contact removeContact(int id) {
        if (accessKey != null) {
            return controller.removeContact(id);
        }
         return null;
    }


    public Contact[] getAll() {
        if (accessKey != null) {
            return getAll();
        }
        return new Contact[0];
    }


    public Contact findContact(Contact contact, String nameOrNumber) {
        if (accessKey != null) {
            return findContact(contact, nameOrNumber);
        }
        return null;
    }

    public ContactController getController() {
        if (accessKey != null) {
            return getController();
        }
        return controller;
    }

    public void setController(ContactController controller) {
        if (accessKey != null) {
            this.controller = controller;
        }

    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }
}
