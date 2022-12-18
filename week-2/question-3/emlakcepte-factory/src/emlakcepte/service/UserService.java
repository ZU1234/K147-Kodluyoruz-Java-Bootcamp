package emlakcepte.service;

import emlakcepte.dao.UserDao;
import emlakcepte.interfaces.IUserService;
import emlakcepte.model.User;

import java.util.List;


public class UserService implements IUserService {

    private UserDao userDao = new UserDao();

    @Override
    public void createUser(User user) {
        //UserDao userDao = new UserDao(); tekrar tekrar oluşturmamıza gerek yok
        System.out.println("ben bir userDao objesiyim:" + userDao.toString());

        userDao.createUser(user);
    }

    @Override
    public List<User> getAllUser() {
        //UserDao userDao = new UserDao();
        return userDao.findAllUsers();
    }

    @Override
    public void printAllUser() {

        getAllUser().forEach(user -> System.out.println(user.getName()));

    }

    @Override
    public void updatePassword(User user, String newPassword) {
        // önce hangi user bul ve passwordü update et.
    }

}
