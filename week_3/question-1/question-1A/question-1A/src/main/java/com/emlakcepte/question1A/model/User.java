package com.emlakcepte.question1A.model;

import com.emlakcepte.question1A.model.enums.UserState;
import com.emlakcepte.question1A.model.enums.UserType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String mail;
    private String password;
    private UserType type;
    private List<Realty> realtyList;
    private List<Realty> favoriteRealtyList;
    private List<Message> messages;
    private LocalDateTime createDate;
    private List<String> oldPassword = new ArrayList<>();
    private UserState userState;


    public User() {
        super();
    }

    public User(String name, String mail, String password, UserType type, List<Realty> realtyList, UserState userState) {
        super();
        this.name = name.trim();
        this.mail = mail.trim();
        this.password = password.trim();
        this.type = type;
        this.realtyList = realtyList;
        this.userState = userState;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public List<Realty> getRealtyList() {
        return realtyList;
    }

    public void setRealtyList(List<Realty> realtyList) {
        this.realtyList = realtyList;
    }

    public List<Realty> getFavoriteRealtyList() {
        return favoriteRealtyList;
    }

    public void setFavoriteRealtyList(List<Realty> favoriteRealtyList) {
        this.favoriteRealtyList = favoriteRealtyList;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public List<String> getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(List<String> oldPassword) {
        this.oldPassword = oldPassword;
    }

    public UserState getUserState() {
        return userState;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", mail=" + mail + ", password=" + password + ", type=" + type + "createDate="
                + createDate + "]";
    }


}
