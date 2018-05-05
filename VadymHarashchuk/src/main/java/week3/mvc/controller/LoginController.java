package week3.mvc.controller;

public interface LoginController {

    String loginAsUser(String username, String password);
    String loginAsWorker(String username, String password);
    String loginAsAdmin(String username, String password);
}
