package dao;

import model.Follow;
import model.Tag;
import model.TagType;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> userList = new ArrayList<>();
    private List<Tag> userTagTypeList = new ArrayList<>();
    private static List<Follow> followList = new ArrayList<>();

    public void createUser(User user) {
        userList.add(user);
    }
    public void createFollow(Follow follow) {
        followList.add(follow);
    }
    public void createTagType(Tag tag) {
        userTagTypeList.add(tag);
    }

    public List<User> findAllUsers() {
        return userList;
    }
    public List<Follow> findAllFollow() {
        return followList;
    }
    public List<Tag> findAlluserTagTypeList() {
        return userTagTypeList;
    }
}
