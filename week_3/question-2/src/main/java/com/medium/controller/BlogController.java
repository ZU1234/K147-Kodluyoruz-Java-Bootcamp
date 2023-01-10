package com.medium.controller;

import com.medium.model.Blog;
import com.medium.model.Follow;
import com.medium.model.User;
import com.medium.service.BlogService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/blogs")
//Bu sınıf dışarı ile olan bağlantıyı sağlayacak.
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping //GET  /blogs  şeklinde methodu kullanmamızı sağlar.Tüm blogları getirir.
    public List<Blog> getAll() {
        return blogService.getAllBlog();
    }

    @PostMapping  //POST /blogs şeklinde methodu kullanmamızı sağlar. Yeni blog oluşturur.
    public ResponseEntity<Blog> create(@RequestBody Blog blog) {

        blogService.createBlog(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }

    @PostMapping(value = "/publish/{no}")   //POST /publish/{no} blog yayınlar.
    public ResponseEntity<Long>setBlogType(@PathVariable Long no) {
        blogService.setBlogPublish(no);
        return new ResponseEntity<>(no, HttpStatus.OK);

    }


    @GetMapping(value = "/{email}")  //GET /blogs/{email} şeklinde methodu kullanmamızı sağlar.
    public List<String> getByEmail(@PathVariable String email) {
        return blogService.userByBlogList(email);
    }

    @DeleteMapping(value = "/{no}")  //DELETE/blogs/{no}  Blog nosuna ait blog silinir.
    public ResponseEntity<Long> removeBlog(@PathVariable Long no) {
        blogService.deleteBlog(no);
        return new ResponseEntity<>(no, HttpStatus.OK);
    }


}
