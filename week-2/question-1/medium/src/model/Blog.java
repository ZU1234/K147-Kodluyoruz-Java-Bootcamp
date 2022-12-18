package model;

import java.time.LocalDateTime;
import java.util.List;

public class Blog {
    private Long no;
    private User user;
    private String title;
    private String text;
    private List<TagType> tagTypeList;
    private LocalDateTime publishedDate;
    private BlogType blogType;

    public Blog(Long no, User user, String title, String text, List<TagType> tagTypeList, LocalDateTime publishedDate,
                BlogType blogType) {
        this.no = no;
        this.user = user;
        this.title = title;
        this.text = text;
        this.tagTypeList = tagTypeList;
        this.publishedDate = publishedDate;
        this.blogType=blogType;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<TagType> getTagList() {
        return tagTypeList;
    }

    public void setTagList(List<TagType> tagTypeList) {
        this.tagTypeList = tagTypeList;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }

    @Override
    public String toString() {
        return "Blog [no=" + no + ", title=" + title + ", text="+ text + ", publishedDate=" + publishedDate + ", " +
                "user=" + user
                + ", tag=" + tagTypeList +"]";
    }
}
