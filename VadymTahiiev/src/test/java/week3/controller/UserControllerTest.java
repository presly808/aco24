package week3.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import week3.model.Ticket;

import static org.junit.Assert.*;

public class UserControllerTest {

    private UserController userController;

    @Before
    public void before(){
        userController = new ProxyUserController();
    }

    @After
    public void after(){
        userController = null;
    }

    @Test
    public void createUserAccount() throws Exception {
        boolean result = userController.createUserAccount("Vadym","+380963349190", 4444);
        Assert.assertEquals(true, result);
    }

    @Test
    public void createUserAccountNameEmpty() throws Exception {
        boolean result = userController.createUserAccount("","+380963349190", 4444);
        Assert.assertEquals(false, result);
    }


    @Test
    public void createUserAccountPhoneNumberEmpty() throws Exception {
        boolean result = userController.createUserAccount("Vadym","", 4444);
        Assert.assertEquals(false, result);
    }

    @Test
    public void giveItem() throws Exception {
        userController.createUserAccount("Vadym","+380674627864", 123);
        userController.createUserAccount("Oleh","+380674627800", 010);
        Ticket expected1 = new Ticket();
        Ticket expected2 = new Ticket();
        expected1.setProductName("Tesla");
        expected1.setProductModel("model S");
        expected1.setProductPrice(100000);
        expected1.setRepairingPrice(10000);
        expected1.setNotes("Electric");
        expected1.setStatus(false);
        expected1.setId(1);

        expected2.setProductName("Mazda");
        expected2.setProductModel("3");
        expected2.setProductPrice(100000);
        expected2.setRepairingPrice(10000);
        expected2.setNotes("No");
        expected2.setStatus(false);
        expected2.setId(1);

        Ticket actual1 = userController.giveItem(expected1.getProductName(), expected1.getProductModel(), expected1.getProductPrice(),
                expected1.getNotes(), expected1.getId(), 123);

        Ticket actual2 = userController.giveItem(expected2.getProductName(), expected2.getProductModel(), expected2.getProductPrice(),
                expected2.getNotes(), expected2.getId(), 123);

        Assert.assertEquals(expected1.toString(),actual1.toString());
        Assert.assertEquals(expected2.toString(),actual2.toString());
    }

    @Test
    public void giveItemFalse() throws Exception {
        userController.createUserAccount("Vadym","+380674627864", 123);
        Ticket expected = new Ticket();
        expected.setProductName("Tesla");
        expected.setProductModel("model S");
        expected.setProductPrice(100000);
        expected.setRepairingPrice(10000);
        expected.setNotes("Electric");
        expected.setStatus(false);
        expected.setId(1);
        Ticket actual = userController.giveItem("Audi", expected.getProductModel(), expected.getProductPrice(),
                expected.getNotes(), expected.getId(), 123);
        Assert.assertNotEquals(expected.toString(),actual.toString());
    }

    @Test
    public void giveItemInvalidPassword() throws Exception {
        userController.createUserAccount("Vadym","+380674627864", 123);
        Ticket expected = new Ticket();
        expected.setProductName("Tesla");
        expected.setProductModel("model S");
        expected.setProductPrice(100000);
        expected.setRepairingPrice(10000);
        expected.setNotes("Electric");
        expected.setStatus(false);
        expected.setId(1);
        Ticket actual = userController.giveItem(expected.getProductName(), expected.getProductModel(), expected.getProductPrice(),
                expected.getNotes(), expected.getId(), 1);
        Assert.assertNull(actual);
    }

    @Test
    public void checkTicketStatus() throws Exception {
        userController.createUserAccount("Sania","+380674627864", 33);
        userController.createUserAccount("Vadym","+380670627864", 123);
        Ticket expected = new Ticket();
        expected.setProductName("Tesla");
        expected.setProductModel("model S");
        expected.setProductPrice(100000);
        expected.setRepairingPrice(10000);
        expected.setNotes("Electric");
        expected.setStatus(false);
        expected.setId(2);
        userController.giveItem(expected.getProductName(), expected.getProductModel(), expected.getProductPrice(),
                expected.getNotes(), expected.getId(), 123);
        boolean actual = userController.checkTicketStatus(2,123);
        Assert.assertEquals(false , actual);
    }

    @Test
    public void checkTicketStatusInvalidID() throws Exception {
        userController.createUserAccount("Sania","+380674627864", 33);
        userController.createUserAccount("Vadym","+380670627864", 123);
        Ticket expected = new Ticket();
        expected.setProductName("Tesla");
        expected.setProductModel("model S");
        expected.setProductPrice(100000);
        expected.setRepairingPrice(10000);
        expected.setNotes("Electric");
        expected.setStatus(false);
        expected.setId(2);
        userController.giveItem(expected.getProductName(), expected.getProductModel(), expected.getProductPrice(),
                expected.getNotes(), expected.getId(), 123);
        boolean actual = userController.checkTicketStatus(3,123);
        Assert.assertEquals(false , actual);
    }

    @Test
    public void takeItemBack() throws Exception {
        userController.createUserAccount("Sania","+380674627864", 33);
        userController.createUserAccount("Vadym","+380670627864", 123);
        userController.createUserAccount("Kiril","+380670", 4444);
        Ticket expected = new Ticket();
        expected.setProductName(null);
        expected.setProductModel(null);
        expected.setProductPrice(0.0);
        expected.setRepairingPrice(0.0);
        expected.setNotes(null);
        expected.setStatus(false);
        expected.setId(2);
        userController.giveItem("Tesla", "model S", 100000,
                "Electric", 2, 123);
        Ticket actual = userController.takeItemBack(2,123);
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void takeItemBackInvalidID() throws Exception {
        userController.createUserAccount("Sania","+380674627864", 33);
        userController.createUserAccount("Vadym","+380670627864", 123);
        userController.createUserAccount("Kiril","+380670", 4444);

        userController.giveItem("Tesla", "model S", 100000,
                "Electric", 2, 123);

        Ticket actual = userController.takeItemBack(3,123);
        Assert.assertNull(actual);
    }

    @Test
    public void takeItemBackInvalidPassword() throws Exception {
        userController.createUserAccount("Sania","+380674627864", 33);
        userController.createUserAccount("Vadym","+380670627864", 123);
        userController.createUserAccount("Kiril","+380670", 4444);

        userController.giveItem("Tesla", "model S", 100000,
                "Electric", 2, 123);

        Ticket actual = userController.takeItemBack(2,122);
        Assert.assertNull(actual);
    }

    @Test
    public void leaveComment() throws Exception {
        userController.createUserAccount("Sania","+380674627864", 33);
        userController.createUserAccount("Vadym","+380670627864", 123);
        userController.createUserAccount("Kiril","+380670", 4444);
        Ticket expected = new Ticket();
        expected.setProductName("Tesla");
        expected.setProductModel("model S");
        expected.setProductPrice(100000);
        expected.setRepairingPrice(10000);
        expected.setNotes("none");
        expected.setStatus(false);
        expected.setId(2);
        userController.giveItem(expected.getProductName(), expected.getProductModel(), expected.getProductPrice(),
                expected.getNotes(), expected.getId(), 123);
        String actual = userController.leaveComment(2,123,"Electric");
        Assert.assertEquals("Electric", actual);
    }

    @Test
    public void leaveCommentInvalidID() throws Exception {
        userController.createUserAccount("Sania","+380674627864", 33);
        userController.createUserAccount("Vadym","+380670627864", 123);
        userController.createUserAccount("Kiril","+380670", 4444);
        Ticket expected = new Ticket();
        expected.setProductName("Tesla");
        expected.setProductModel("model S");
        expected.setProductPrice(100000);
        expected.setRepairingPrice(10000);
        expected.setNotes("none");
        expected.setStatus(false);
        expected.setId(2);
        userController.giveItem(expected.getProductName(), expected.getProductModel(), expected.getProductPrice(),
                expected.getNotes(), expected.getId(), 123);
        String actual = userController.leaveComment(4,123,"Electric");
        Assert.assertNull(actual);
    }

    @Test
    public void leaveCommentInvalidPassword() throws Exception {
        userController.createUserAccount("Sania","+380674627864", 33);
        userController.createUserAccount("Vadym","+380670627864", 123);
        userController.createUserAccount("Kiril","+380670", 4444);
        Ticket expected = new Ticket();
        expected.setProductName("Tesla");
        expected.setProductModel("model S");
        expected.setProductPrice(100000);
        expected.setRepairingPrice(10000);
        expected.setNotes("none");
        expected.setStatus(false);
        expected.setId(2);
        userController.giveItem(expected.getProductName(), expected.getProductModel(), expected.getProductPrice(),
                expected.getNotes(), expected.getId(), 123);
        String actual = userController.leaveComment(2,122,"Electric");
        Assert.assertNull(actual);
    }
}