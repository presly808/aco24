package exclude.week2.mvc.dao;

import exclude.week2.mvc.model.Contact;
import exclude.week2.mvc.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by serhii on 13.05.18.
 */
public class DbContainer {

    public Map<String, User> userMap = new HashMap<>();
    public List<Contact> contactList = new ArrayList<>();

    public void loadFromFile(String path){
        // todo finish
    }

    public void saveIntoTheFile(String path){
        // save
    }

}
