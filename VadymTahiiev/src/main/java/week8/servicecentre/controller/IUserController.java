package week8.servicecentre.controller;

public interface IUserController {
    public boolean registerUser(String name, String phoneNumber, String password) throws Exception;
    public String loginUser(String name, String password) throws Exception;
}
