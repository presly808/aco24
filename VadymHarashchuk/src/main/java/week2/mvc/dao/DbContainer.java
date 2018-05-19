package week2.mvc.dao;

import week2.mvc.model.Contact;
import week2.mvc.model.User;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbContainer {

    public Map<Integer, User> userMap = new HashMap<>();
    public List<Contact> contactList = new ArrayList<>();


}
