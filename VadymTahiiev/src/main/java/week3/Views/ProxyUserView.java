package week3.Views;


import week3.data.UserDao;

import java.util.Scanner;

public class ProxyUserView implements UserView {
    private RealUserView realUserView;

    public ProxyUserView() {
        realUserView = new RealUserView();
    }

    @Override
    public boolean createUser() {
        realUserView.createUser();
        return true;
    }

    @Override
    public boolean toControlUser(String name, String password) {
        return false;
    }

    @Override
    public boolean toControlUser() {
        Scanner sc = new Scanner(System.in);
        String name;
        String password;
        System.out.println("Validation");
        System.out.println("Name: ");
        name = sc.next();
        System.out.println("Password: ");
        password = sc.next();
        for (int i = 0; i < UserDao.readUsers().size(); i++) {
            if (UserDao.readUsers().get(i).getName().equals(name) &&
                    UserDao.readUsers().get(i).getPhoneNumber().equals(password)) {
                realUserView.toControlUser(name,password);
                return true;
            }
        }
        System.out.println("Invalid name or password");
        return false;
    }
}
