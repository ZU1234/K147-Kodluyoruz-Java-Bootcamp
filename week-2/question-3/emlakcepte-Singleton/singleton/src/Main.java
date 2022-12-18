import emlakcepte.model.Realty;
import emlakcepte.model.User;
import emlakcepte.service.RealtyService;
import emlakcepte.service.UserService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        User user1=new User();
        User user2=new User();

        System.out.println();
        UserService.getInstance().createUser(user1);
        UserService.getInstance().createUser(user2);
        //Yalnızca tek sefer nesne oluşturdu.

        Realty realty1= new Realty();
        Realty realty2= new Realty();

        System.out.println();
        RealtyService.getInstance().createRealty(realty1);
        RealtyService.getInstance().createRealty(realty2);
        //Yalnızca tek sefer nesne oluşturdu.

        System.out.println("\nuser nesneleri birbirine esit mi--------> "+user1.equals(user2));
        System.out.println("realty nesneleri birbirine esit mi--------> "+realty1.equals(realty2));


    }
}