package service;

import dao.UserDao;
import model.*;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();
    //Kullanıcı oluşturur.
    public void createUser(User user) {
        userDao.createUser(user);
    }
    //Kullanıcı için takipçi oluşturur.
    public void createFollow(User userFrom,User userTo){
        userDao.createFollow(new Follow(userFrom,userTo));
    }
    //Kullanıcı için tag oluşturur.
    public void createTag(User user,TagType tagType){
        userDao.createTagType(new Tag(user,tagType));
    }
    //Tüm kullanıcı listesini döndürür.
    public List<User> getAllUser() {
        return userDao.findAllUsers();
    }
    //Tüm takip listesini döndürür.
    public List<Follow> getAllFollow() {
        return userDao.findAllFollow();
    }
    //Tüm kullanıcıları liteler
    public void printAllUser() {
        getAllUser().forEach(user -> System.out.println(user.getName()));
    }


    //Kullanıcının takip listesini listeler
    public void printAllFollowByUser(User user) {
        getAllFollow().stream().filter(obj->obj.getUserFrom().getName().equals(user.getName()))
                .forEach(s-> System.out.println(s.getUserFrom().getName()+" kisisi, "+s.getUserTo().getName()+" " +
                "kisisini takip " +
                "ediyor."));
    }
    //Kullanıcının taglerini listeler
    public void printAllUserTagList(User user) {
        System.out.println("------------------------------------------------");
        System.out.println(user.getName()+" kisisinin takip ettigi tagler.");
        userDao.findAlluserTagTypeList().stream()
                .filter(obj->obj.getUser().getName().equals(user.getName()))
                .forEach(s-> System.out.println(s.getTagType()));
    }

    //Şifre güncelleme
    public void updatePassword(User user, String newPassword) {

        //Sifrenin en az 5 karakterli mi kontrol eder. Eğer en az 5 karakterli ise true döner.
        boolean isStringSize = isStringSizeGreaterThenFive(newPassword);
        //Yeni girilen sifre son 3 sifre ile aynı ise false olur.
        boolean isOldPassword = isOldPasswordControl(user, newPassword);

        if (!isStringSize) {
            //Sifre 5 karakterden az ise hata mesajı verir.
            System.out.println(ErrorMessage.password("password<5"));


        } else if (!isOldPassword) {
            //Yeni şifre son 3 şifre ile aynı ise hata mesajı verir.
            System.out.println(ErrorMessage.password("oldPassword"));
        } else {
            //Şifre hem 5 karakterden fazla hemde son 3 şifre ile aynı değilse şifreyi günceller.
            user.setPassword(newPassword.trim());
            //Eski şifre listesine kayıt eder.
            user.getOldPassword().add(user.getPassword());
        }


    }
    //Şifre 5 karakterden uzun mu kontrol eder.
    public boolean isStringSizeGreaterThenFive(String word) {
        //Sifrenin en az 5 karakterli mi kontrol eder. Eğer en az 5 karakterli ise true döner.
        return word.length() >= 5;
    }
    //Son 3 şifre ile aynı mı kontrol eder.
    private boolean isOldPasswordControl(User user, String newPassword) {

        boolean isControl = true;
        int size = user.getOldPassword().size();

        if (user.getOldPassword() != null) {
            for (int i = size - 1; i > size - 4; i--) {
                if (i < 0) {
                    break;
                } else {
                    if (user.getOldPassword().get(i).equals(newPassword)) {
                        isControl = false;//Yeni şifre son 3 şifre ile aynı ise false döner;
                    }
                }
            }
        }

        return isControl;
    }

}
