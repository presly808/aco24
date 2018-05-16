package service_center.utils;

import java.util.UUID;

public final class NumberUtils {

    public static String generateId(){
        return UUID.randomUUID().toString().substring(0, 8);
    };

}
