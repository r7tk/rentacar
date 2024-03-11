package business;

import dao.UserDao;
import entity.User;

public class UserManager {
    private final UserDao userDao;

    public UserManager() {
        this.userDao = new UserDao();
    }
    public User findByLoging(String username, String password){
        // Farklı işlemler yapabiliriz ...
        return this.userDao.findByLogin(username,password);

    }
}