package com.medium.model;

import com.medium.enums.TagType;

public class UserTag {
    private TagType tagType;
    private User user;


    public UserTag(User user, TagType tagType) {
        this.tagType = tagType;
        this.user=user;
    }

    public TagType getTagType() {
        return tagType;
    }

    public void setTagType(TagType tagType) {
        this.tagType = tagType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
