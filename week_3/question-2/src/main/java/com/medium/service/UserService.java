package com.medium.service;


import com.medium.repository.UserRepository;
import com.medium.enums.TagType;
import com.medium.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //Kullanıcı oluşturur.
    public void createUser(User user) {
        userRepository.createUser(user);
    }

    //Kullanıcı için takipçi oluşturur.
    public void createFollow(Follow follow) {
        userRepository.createFollow(follow);
    }

    //Kullanıcı için tag oluşturur.
    public void createTagType(UserTag userTag) {
        userRepository.createTagType(userTag);
    }

    //Tüm kullanıcı listesini döndürür.
    public List<User> getAllUser() {
        return userRepository.findAllUsers();
    }

    //Tüm takip listesini döndürür.
    public List<Follow> getAllFollow() {
        return userRepository.findAllFollow();
    }

    //Tüm kullanıcıları liteler
    public void printAllUser() {
        userRepository.findAllUsers().forEach(user -> System.out.println(user.getName()));
    }


    //Kullanıcının takip listesini listeler
    public List<String> printAllFollowByUser(User user) {
      return   userRepository.findAllFollow().stream().filter(obj -> obj.getUserFrom().getName().equals(user.getName()))
              .map(s->s.getUserFrom().getName()+" "+s.getUserTo().getName())
              .toList();
    }

    //Kullanıcının taglerini listener
    public List<TagType> printAllUserTagList(User user) {
        System.out.println("------------------------------------------------");
        System.out.println(user.getName() + " kisisinin takip ettigi tagler.");
       return userRepository.findAlluserTagTypeList().stream()
                .map(s->s.getTagType()).toList();
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

    public User getByEmail(String email) {
        return userRepository.findAllUsers()
                .stream()
                .filter(obj -> obj.getEmail().equals(email))
                .findFirst()
                .get();
    }
}
