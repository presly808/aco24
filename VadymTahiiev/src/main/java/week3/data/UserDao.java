package week3.data;

import week3.model.User;

public class UserDao {

    public static boolean createUser(User user) {
        if (user == null) return false;
        return DataBase.users.add(user);
    }

    public static User readUser(int id) {
        if (id <= 0) return null;
        for (int i = 0; i < DataBase.users.size(); i++) {
            if (DataBase.users.get(i).getId() == id) return DataBase.users.get(i);
        }
        return null;
    }

    public static boolean updateUser(User updatedUser) {
        if (updatedUser == null || updatedUser.getId() <=0 ) return false;
        for (int i = 0; i < DataBase.users.size(); i++) {
            if (DataBase.users.get(i).getId() == updatedUser.getId()) {
                DataBase.users.get(i).setName(updatedUser.getName());
                DataBase.users.get(i).setPhoneNumber(updatedUser.getPhoneNumber());
                return true;
            }
        }
        return false;
    }

    public static User deleteUser(User user) {
        if (user == null) return null;
        for (int i = 0; i < DataBase.users.size(); i++) {
            if (DataBase.users.get(i).equals(user)) {
                DataBase.users.remove(i);
                return user;
            }
        }
        return null;
    }
}
