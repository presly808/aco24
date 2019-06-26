package exclude.week2.mvc.dao;

import exclude.week2.mvc.model.User;
import exclude.week2.mvc.utils.NumberUtil;
import exclude.week2.mvc.utils.ObjectHolder;

/**
 * Created by serhii on 13.05.18.
 */
public class UserDaoImpl implements Dao<User> {
    
    private DbContainer container = (DbContainer) ObjectHolder.getBean("db");

    public UserDaoImpl() {
    }

    @Override
    public boolean create(User user) {
        user.setId(NumberUtil.generateId());
        container.userMap.put(user.getId(), user);
        return true;
    }

    @Override
    public User read(String id) {
        return container.userMap.get(id);
    }

    @Override
    public boolean update(User user) {
        User oldOne = container.userMap.put(user.getId(), user);
        return true;
    }

    @Override
    public User delete(String id) {
        return container.userMap.remove(id);
    }

    @Override
    public User[] all() {
        return container.userMap.values().toArray(new User[container.userMap.size()]);
    }
}
