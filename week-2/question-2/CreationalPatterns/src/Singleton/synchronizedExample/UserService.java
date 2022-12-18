package Singleton.synchronizedExample;

import Singleton.Project.User;
import Singleton.Project.UserDao;

public class UserService {
    private static UserService instance = null;
    private static Object synchrınizedObject = new Object();
    private UserDao userDao = new UserDao();

    private UserService() {

    }

    public static UserService getInstance() {
        if (instance == null) {
            synchronized (synchrınizedObject){
                if (instance == null) {
                    instance = new UserService();
                }
            }

        }
        return instance;
    }

    public void createUser(User user) {

        userDao.createUser(user);
        System.out.println( userDao );


    }
}
