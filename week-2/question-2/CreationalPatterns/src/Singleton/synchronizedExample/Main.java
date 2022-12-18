package Singleton.synchronizedExample;

import Singleton.Project.User;
import Singleton.unSynchronizedExample.UserServiceUnsynchronized;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------Singleton----------");
        System.out.println("-----------Synchronized----------");

        User user1=new User();
        User user2=new User();
        UserService userService1 = UserService.getInstance();

        UserService userService2 = UserService.getInstance();
        System.out.println(userService1);
        System.out.println(userService2);

        System.out.println();

        UserService.getInstance().createUser(user1);
        UserService.getInstance().createUser(user2);
        System.out.println("\n-----------------------------------------------");


    }
}