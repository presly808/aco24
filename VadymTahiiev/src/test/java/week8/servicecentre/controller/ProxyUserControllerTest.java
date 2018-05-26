package week8.servicecentre.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import week8.servicecentre.controller.*;

import static org.junit.Assert.*;

public class ProxyUserControllerTest {

    private IUserController userController;

    @Before
    public void before(){
        userController = new ProxyUserController();
    }

    @After
    public void after(){
        userController = null;
    }

    @Test
    public void registerUser() throws Exception{
        boolean actual = userController.registerUser("vad","3242","123qwe");
        Assert.assertEquals(true, actual);
    }

    @Test
    public void loginUser() {
    }
}