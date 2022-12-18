package Singleton.Project;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> userList = new ArrayList<>();

    public void createUser(User user) {
        userList.add(user);
    }


}
