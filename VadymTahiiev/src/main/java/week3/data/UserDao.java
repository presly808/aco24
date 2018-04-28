package week3.data;

import week3.model.User;
import java.util.List;

public class UserDao {

    public static boolean createUser(User user) {
        DataBase.users.add(user);
        return true;
    }

    public static List<User> readUsers() {
        if (DataBase.users == null) {
            return null;
        }
        return DataBase.users;
    }

    public static boolean deleteUser(User user) {
        if (user == null) return false;
        for (int i = 0; i < DataBase.users.size(); i++) {
            if (DataBase.users.get(i).equals(user)) {
                DataBase.users.remove(i);
                return true;
            }
        }
        return false;
    }

    public static boolean updateUser(User user, User newUser) {
        if (user == null || newUser == null) return false;
        for (int i = 0; i < DataBase.users.size(); i++) {
            if (DataBase.users.get(i).equals(user)) {
                user = newUser;
                return true;
            }
        }
        return false;
    }
}
