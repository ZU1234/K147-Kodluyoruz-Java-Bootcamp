package emlakcepte.factory;

import emlakcepte.interfaces.IUserService;
import emlakcepte.service.UserService;


public class UserServiceFactory {
    public IUserService getIUserService(String userServiceType) {
        if (userServiceType == null) {
            return null;
        }
        if (userServiceType.equalsIgnoreCase("USERSERVICE")) {
            return new UserService();
        }
        return null;
    }
}
