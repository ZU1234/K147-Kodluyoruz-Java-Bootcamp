package com.medium.service;

import com.medium.repository.BlogRepository;
import com.medium.enums.BlogType;
import com.medium.enums.TagType;
import com.medium.model.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Objects;


public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    //Blog oluşturur.
    public void createBlog(Blog blog) {
        blogRepository.saveBlog(blog);
    }

    //Blog siler
    public void deleteBlog(Long id) {
        blogRepository.deleteBlog(id);
    }

    //Blog için hh oluşturur.
    public void createTagType(TagType tagType) {
        blogRepository.saveTagType(tagType);
    }

    //Tüm blogları listeler.
    public void BlogPrint() {
        System.out.println("--------------------------------------------------------------------");
        System.out.format("%-15s%-15s%-60s%n", "Yayinlayan", "Blog no", "Title\n");
        blogRepository.findAllBlog()
                .stream().filter(s -> s.getBlogType().equals(BlogType.PUBLISH))
                .forEach(obj ->
                        System.out.format("%-15s%-15s%-60s%n", obj.getUser().getName(), obj.getNo(), obj.getTitle()));
    }

    //Kullanıcıya ait blogları listeler.
    public List<String> userByBlogList(String email) {
        System.out.println("--------------------------------------------------------------------");
        System.out.format("%-15s%-10s%-60s%n", email, "Blog no", "Title\n");
        return blogRepository.findAllBlog()
                .stream()
                .filter(s -> Objects.equals(s.getUser().getEmail(), email))
                .map(s->s.toString())
                .toList();
    }

    public List<Blog> getAllBlog() {
        System.out.println(blogRepository);
        return blogRepository.findAllBlog();
    }

    public List<Blog> getByEmail(String email) {
        return blogRepository.findAllBlog()
                .stream().filter(s -> s.getUser().getEmail().equals(email))
                .toList();
    }

    public void setBlogPublish(Long no) {

        blogRepository.findAllBlog().stream()
                .filter(s -> s.getNo().equals(no))
                .findFirst().get().setBlogType(BlogType.PUBLISH);
    }
}
