package Singleton.unSynchronizedExample;

import Singleton.Project.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------Singleton----------");
        System.out.println("-----------unSynchronized----------");

        User user1=new User();
        User user2=new User();
        UserServiceUnsynchronized userServiceUnsynchronized1 = UserServiceUnsynchronized.getInstance();

        UserServiceUnsynchronized userServiceUnsynchronized2 = UserServiceUnsynchronized.getInstance();
        System.out.println(userServiceUnsynchronized1);
        System.out.println(userServiceUnsynchronized2);

        System.out.println();

        UserServiceUnsynchronized.getInstance().createUser(user1);
        UserServiceUnsynchronized.getInstance().createUser(user2);
        System.out.println("\n-----------------------------------------------");


    }
}