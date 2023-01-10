package com.medium.repository;



import com.medium.enums.TagType;
import com.medium.model.Blog;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class BlogRepository {
    private static List<Blog> blogList = new ArrayList<>();
    private static List<TagType> tagTypeList = new ArrayList<>();
    //Blog'u ekler.
    public void saveBlog(Blog blog){
        blogList.add(blog);
        System.out.println("işlem başarılı");
    }
    //Blog'u siler.
    public Blog deleteBlog(Long id){
      Blog blog=  blogList.stream()
              .filter(s->s.getNo().equals(id))
              .findFirst().get();
      blogList.remove(blog);
      return blog;
    }
    //hh ekler.
    public void saveTagType(TagType tagType) {
        tagTypeList.add(tagType);
    }
    //hh siler.
    public void deleteTag(TagType tagType) {
        tagTypeList.remove(tagType);
    }
    //Blog listesini döndürür.
    public List<Blog> findAllBlog(){
        return blogList;
    }
    public List<TagType> findAllTagType(){
        return tagTypeList;
    }

}
