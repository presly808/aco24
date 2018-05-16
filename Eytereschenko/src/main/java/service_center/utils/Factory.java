package service_center.utils;

import service_center.dao.DbContainer;

import java.util.HashMap;
import java.util.Map;

public final class Factory {

    private static final Map<String, Object> objectMap = new HashMap<>();

    static {
        objectMap.put("db", new DbContainer());
        //objectMap.put();
    }

    public static<T> T getItem(String name){
        return (T) objectMap.get(name);
    }

}
