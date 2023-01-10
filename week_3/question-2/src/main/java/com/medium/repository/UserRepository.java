package com.medium.repository;



import com.medium.enums.TagType;
import com.medium.model.Follow;
import com.medium.model.User;
import com.medium.model.UserTag;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private static List<User> userList = new ArrayList<>();
    private static List<UserTag> userTagTypeList = new ArrayList<>();
    private static List<Follow> followList = new ArrayList<>();

    public void createUser(User user) {
        userList.add(user);
    }
    public void createFollow(Follow follow) {
        followList.add(follow);
    }
    public void createTagType(UserTag userTag) {
        userTagTypeList.add(userTag);
    }

    public List<User> findAllUsers() {
        return userList;
    }
    public List<Follow> findAllFollow() {
        return followList;
    }
    public List<UserTag> findAlluserTagTypeList() {
        return userTagTypeList;
    }
}
