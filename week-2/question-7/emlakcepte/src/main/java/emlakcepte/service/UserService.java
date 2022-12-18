package emlakcepte.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import emlakcepte.dao.UserDao;
import emlakcepte.model.ErrorMessage;
import emlakcepte.model.Message;
import emlakcepte.model.User;
import emlakcepte.model.UserState;


public class UserService {


    private UserDao userDao = new UserDao();


    // Singleton Pattern
/*	private static UserService userService = new UserService();
	
	private UserService() {
		
	}
	
	public static UserService getDifferentInstance() {
		return  new UserService();
	}
	
	public static UserService getSameInstance() {
		return userService;
	}
	*/
    public void createUser(User user) {
        //UserDao userDao = new UserDao(); tekrar tekrar oluşturmamıza gerek yok
        //System.out.println("ben bir userDao objesiyim:" + userDao.toString());
        if (isTheUserRegistered(user)) {
            System.out.println(ErrorMessage.login("register"));
        } else if (isStringSizeGreaterThenFive(user.getPassword())) {
            userDao.createUser(user);
            user.getOldPassword().add(user.getPassword());
            System.out.println(ErrorMessage.login("success"));

        } else {
            System.out.println(ErrorMessage.password("password<5"));
        }
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
        //Şifre kontrolu true olursa şifreyi günceller.

        boolean isStringSize = isStringSizeGreaterThenFive(newPassword);
        boolean isOldPassword = isOldPasswordControl(user, newPassword);

        if (!isStringSize) {
            System.out.println(ErrorMessage.password("password<5"));


        } else if (!isOldPassword) {
            System.out.println(ErrorMessage.password("oldPassword"));
        } else {
            user.setPassword(newPassword.trim());
            user.getOldPassword().add(user.getPassword());
        }


    }

    //girilen şifre son 3 şifre ile aynı ise false döner.
    private boolean isOldPasswordControl(User user, String newPassword) {

        boolean isControl = true;
        int size = user.getOldPassword().size();

        if (user.getOldPassword() != null) {
            for (int i = size - 1; i > size - 4; i--) {
                if (i < 0) {
                    break;
                } else {
                    if (user.getOldPassword().get(i).equals(newPassword)) {
                        isControl = false;
                    }
                }
            }
        }

        return isControl;
    }

    public List<String> inboxContactsList(User user) {


        return user.getMessages().stream()
                .filter(obj -> obj.getFrom().getName().equals(user.getName()))
                .map(s -> s.getTo().getName())
                .distinct()
                .toList();

    }

    public void inboxContactsListPrint(User user) {


        inboxContactsList(user).forEach(obj -> System.out.println(obj));

    }


    public List<String> sentBoxContactsList(User user) {
        return user.getMessages().stream()
                .filter(obj -> obj.getTo().getName().equals(user.getName()))
                .map(s -> s.getFrom().getName())
                .distinct()
                .toList();
    }

    public void sentBoxContactsListPrint(User user) {
        sentBoxContactsList(user).forEach(obj -> System.out.println(obj));
    }

    public List<Message> chatList(User userFrom, User userTo) {
        return userFrom.getMessages().stream()
                .filter(obj -> obj.getTo().getName().equals(userTo.getName())
                        || obj.getFrom().getName().equals(userTo.getName()))
                .toList();

    }

    public void chatListPrint(User userFrom, User userTo) {
        chatList(userFrom, userTo).stream()
                .forEach(obj -> {
                    System.out.println(obj.getFrom().getName() + " : " + obj.getContent());

                });

    }


    //String uzunluğu 5ten büyük ise true döndürür.
    public boolean isStringSizeGreaterThenFive(String word) {
        return word.length() > 5;
    }

    public boolean isLogin(String mail, String password) {
        return userDao.findAllUsers().stream()
                .parallel()
                .anyMatch(obj -> obj.getMail().equals(mail.trim()) && obj.getPassword().equals(password.trim()));

    }

    //Kullanıcı hesabına giriş yapıyor.
    public void login(String mail, String password) {
        if (isLogin(mail, password)) {
            userDao.findAllUsers().stream()
                    .filter(obj -> obj.getMail().equals(mail.trim()) && obj.getPassword().equals(password.trim()))
                    .forEach(obj -> {
                        obj.setUserState(UserState.ONLINE);
                        System.out.println(obj.getName() + " : " + obj.getUserState());
                    });
        } else {
            System.out.print(ErrorMessage.password("error"));
            System.out.println("  :  " + mail);
        }
    }

    public List<User> onlineList() {
        return userDao.findAllUsers().stream()
                .filter(obj -> obj.getUserState().equals(UserState.ONLINE))

                .toList();

    }

    public List<User> accountIsOpenListByUser() {
        return userDao.findAllUsers().stream()
                .filter(obj -> !obj.getUserState().equals(UserState.OUT))

                .toList();
    }

    public boolean isTheUserRegistered(User user) {
        return userDao.findAllUsers()
                .stream()
                .anyMatch(obj -> obj.getMail().equals(user.getMail()));
    }

}
