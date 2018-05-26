package week8.servicecentre.controller;

public class ProxyUserController implements IUserController {
    private UserController userController;

    public ProxyUserController() {
        userController = new UserController();
    }

    @Override
    public boolean registerUser(String name, String phoneNumber, String password) throws Exception{
        if (name.isEmpty()) {
            return false;
        }
        if (phoneNumber.isEmpty() || !phoneNumber.contains("+3")) {
            return false;
        }
        if (password.isEmpty()) {
            return false;
        }
        return userController.registerUser(name, phoneNumber, password);
    }

    @Override
    public String loginUser(String name, String password) throws Exception{
        if (name.isEmpty()) {
            return "invalid";
        }
        if (password.isEmpty()) {
            return "invalid";
        }
        return userController.loginUser(name, password);
    }
}
