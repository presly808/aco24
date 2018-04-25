package week3.servicecenter.dao;

import week3.servicecenter.model.DB;
import week3.servicecenter.model.User;
import week3.servicecenter.utils.ObjectFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private TicketDao ticketDao;
    private DB db;

    private UserDaoImpl(){
        db = (DB) ObjectFactory.get("DB");
    }

    @Override
    public boolean create(User user) {
        return db.getUserList().add(user);
    }

    @Override
    public List<User> read() {
        return db.getUserList();
    }

    @Override
    public void update() {

    }

    @Override
    public boolean delete(User user) {
        return db.getUserList().remove(user);
    }
}
