package week2.mvc.utils;

import java.util.UUID;

/**
 * Created by serhii on 13.05.18.
 */
public class NumberUtil {
    public static String generateId() {
        return UUID.randomUUID().toString().substring(0,8);
    }

    public static String generateToken() {
        return UUID.randomUUID().toString().substring(0,16);
    }
}
