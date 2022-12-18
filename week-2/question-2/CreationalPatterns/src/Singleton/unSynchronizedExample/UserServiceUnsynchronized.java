package Singleton.unSynchronizedExample;

import Singleton.Project.User;
import Singleton.Project.UserDao;

public class UserServiceUnsynchronized {
    private static UserServiceUnsynchronized instance = null;
    private UserDao userDao = new UserDao();

    private UserServiceUnsynchronized() {

    }

    public static UserServiceUnsynchronized getInstance() {
        if (instance == null) {
            instance = new UserServiceUnsynchronized();
        }
        return instance;
    }

    public void createUser(User user) {

        userDao.createUser(user);
        System.out.println( userDao );


    }
}
