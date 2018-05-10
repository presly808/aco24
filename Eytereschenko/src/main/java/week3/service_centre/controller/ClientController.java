package week3.service_centre.controller;

import week3.service_centre.dao.IClientDao;
import week3.service_centre.dao.IOrderDao;
import week3.service_centre.db.Database;
import week3.service_centre.model.*;
import week3.service_centre.model.utilits.DataValidator;

import javax.security.auth.login.LoginException;
import java.util.Date;

public class ClientController implements IClientController {

    private Client client;
    private IClientDao clientDao;
    private IOrderDao orderDao;

    public ClientController(Client client, IClientDao clientDao, IOrderDao orderDao) {
        this.client = client;
        this.clientDao = clientDao;
        this.orderDao = orderDao;
    }

    @Override
    public boolean loginInto(String email, String phone) throws LoginException {
        boolean check = false;
        if (DataValidator.checkEmail(email) && DataValidator.checkPhone(phone)) {
            for (int i = 0; i < Database.clients.size(); i++) {
                if (Database.clients.get(i).getEmail().equals(email) &&
                        Database.clients.get(i).getPhone().equals(phone)) {
                    check = true;
                    break;
                }
            }
        }
        if (check) {
            Database.logfile.add("Client " + this.client.getName() + " logged in at " + new Date());
            return true;
        } else {
            throw new LoginException("Incorrect email or phone");
        }
    }

    @Override
    public Status checkOrderStatus(int id) {
        if (id <= 0) {
            System.out.println("incorrect id " + id);
            return null;
        }
        if (orderDao.readOrder(id) == null) {
            System.out.println("there is no order with id = " + id);
            return null;
        }

        return orderDao.readOrder(id).getStatus();

    }

    @Override
    public int giveItemToRepair(String product) {

        if (product == null) {
            System.out.println("please, specify product to ne repaired");
            return -1;
        }

        return orderDao.createOrder(this.client, product);

    }

    @Override
    public boolean getProductBackForce(int orderId) {

        Order order = orderDao.readOrder(orderId);
        if (order == null) {
            return false;
        }
        order.setStatus(Status.UNSUCCESSFUL);
        return true;
    }
}
