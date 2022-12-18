package model;

public class Tag {
    private TagType tagType;
    private User user;
    private Blog blog;

    public Tag(User user,TagType tagType) {
        this.tagType = tagType;
        this.user=user;
    }
    public Tag(Blog blog,TagType tagType) {
        this.tagType = tagType;
        this.blog=blog;
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

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
