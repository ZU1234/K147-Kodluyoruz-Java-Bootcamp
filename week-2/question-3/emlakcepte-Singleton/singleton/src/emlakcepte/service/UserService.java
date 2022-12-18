package emlakcepte.service;

import java.util.List;

import emlakcepte.dao.UserDao;
import emlakcepte.model.User;

public class UserService {

    // Singleton Pattern
    private static UserService instance = null;
    private UserDao userDao = new UserDao();

    private UserService() {

    }

    public static UserService getInstance() {
        return UserService.SingletonHelper.INSTANCE;
    }

    public void createUser(User user) {
        //UserDao userDao = new UserDao(); tekrar tekrar oluşturmamıza gerek yok


        userDao.createUser(user);
        System.out.println("ben bir userDao objesiyim:" + userDao);
        System.out.println("ben bir userService objesiyim:" + getInstance());
    }

    public List<User> getAllUser() {
        //UserDao userDao = new UserDao();
        return userDao.findAllUsers();
    }

    public void printAllUser() {

        getAllUser().forEach(user -> System.out.println(user.getName()));

    }

    public void updatePassword(User user, String newPassword) {
        // önce hangi user bul ve passwordü update et.
    }

    private static class SingletonHelper {
        private static final UserService INSTANCE = new UserService();
    }

}
