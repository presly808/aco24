package week3.data;

import week3.model.*;

public class UserLogDao {

    public static boolean createPassword(Password password) {
        if (password == null) return false;
        return DataBase.passwords.add(password);
    }

    public static int readPassword(int id) {
        for (int i = 0; i < DataBase.passwords.size(); i++) {
            if (DataBase.passwords.get(i).getId() == id) {
                return DataBase.passwords.get(i).getPassword();
            }
        }
        return -1;
    }

    public static boolean updatePassword(Password updatedPassword) {
        if (updatedPassword == null ) return false;
        for (int i = 0; i < DataBase.passwords.size(); i++) {
            if (DataBase.passwords.get(i).getId() == updatedPassword.getId()) {
                DataBase.passwords.get(i).setPassword(updatedPassword.getPassword());
                return true;
            }
        }
        return false;
    }

    public static Password deletePassword(Password password) {
        if (password == null) return null;
        for (int i = 0; i < DataBase.passwords.size(); i++) {
            if (DataBase.passwords.get(i).equals(password)) {
                DataBase.passwords.remove(i);
                return password;
            }
        }
        return null;
    }

}
