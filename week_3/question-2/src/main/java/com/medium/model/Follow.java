package com.medium.model;

public class Follow {
    private User userFrom;
    private User userTo;

    public Follow(User userFrom, User userTo) {
        this.userFrom = userFrom;
        this.userTo = userTo;
    }



    public User getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public User getUserTo() {
        return userTo;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }
}
