package emlakcepte.interfaces;

import emlakcepte.model.User;

import java.util.List;

public interface IUserService {
    void createUser(User user);
    List<User> getAllUser();
    void printAllUser();
    void updatePassword(User user, String newPassword);
}
