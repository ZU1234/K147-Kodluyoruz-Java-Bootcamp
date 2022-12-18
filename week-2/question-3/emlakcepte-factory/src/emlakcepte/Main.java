package emlakcepte;

import emlakcepte.factory.RealtyServiceFactory;
import emlakcepte.factory.UserServiceFactory;
import emlakcepte.interfaces.IRealtyService;
import emlakcepte.interfaces.IUserService;
import emlakcepte.model.Realty;
import emlakcepte.model.User;


public class Main {
    public static void main(String[] args) {

        RealtyServiceFactory realtyServiceFactory=new RealtyServiceFactory();
        IRealtyService realtyService = realtyServiceFactory.getIRealtyService("REALTYSERVICE");

        UserServiceFactory userServiceFactory=new UserServiceFactory();
        IUserService userService= userServiceFactory.getIUserService("USERSERVICE");

        Realty realty1=new Realty();
        User user1=new User();

        realtyService.createRealty(realty1);
        userService.createUser(user1);

        userService.getAllUser();
        realtyService.getAll();
    }
}