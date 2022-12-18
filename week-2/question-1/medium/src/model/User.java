package model;

import java.time.LocalDateTime;
import java.util.List;

public class User {
    private String name;
    private String email;
    private String password;
    private UserType userType;
    private List<Blog> blogList;
    private List<String> oldPassword;
    private List<Follow> follow;
    private List<Tag> tagType;
    private LocalDateTime createDateTime;

    public User(String name, String email, String password, UserType userType, List<Blog> blogList, List<Tag> tagType,
                List<Follow>follow,LocalDateTime createDateTime) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType=userType;
        this.blogList = blogList;
        this.tagType = tagType;
        this.follow=follow;
        this.createDateTime=createDateTime;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public List<Follow> getFollow() {
        return follow;
    }

    public void setFollow(List<Follow> follow) {
        this.follow = follow;
    }

    public List<Tag> getTag() {
        return tagType;
    }

    public void setTag(List<Tag> tagType) {
        this.tagType = tagType;
    }

    public List<String> getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(List<String> oldPassword) {
        this.oldPassword = oldPassword;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", mail=" + email + ", password=" + password + ", type=" + userType +"]";
    }

}
