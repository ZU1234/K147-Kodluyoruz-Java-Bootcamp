package dao;

import model.Blog;
import model.Tag;
import model.TagType;

import java.util.ArrayList;
import java.util.List;

public class BlogDao {
    private static final List<Blog> blogList = new ArrayList<>();
    private List<Tag> tagTypeList = new ArrayList<>();
    //Blog'u ekler.
    public void saveBlog(Blog blog){
        blogList.add(blog);
    }
    //Blog'u siler.
    public void deleteBlog(Blog blog){
        blogList.remove(blog);
    }
    //Tag ekler.
    public void saveTag(Tag tagType) {
        tagTypeList.add(tagType);
    }
    //Tag siler.
    public void deleteTag(Tag tagType) {
        tagTypeList.remove(tagType);
    }
    //Blog listesini döndürür.
    public List<Blog> findAllBlog(){
        return blogList;
    }
    public List<Tag> findAllTag(){
        return tagTypeList;
    }

}
