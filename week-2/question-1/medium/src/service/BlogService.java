package service;

import dao.BlogDao;
import model.*;

public class BlogService {
    private static BlogDao blogDao = new BlogDao();
    //Blog oluşturur.
    public void createBlog(Blog blog) {
        blogDao.saveBlog(blog);
    }
    //Blog siler
    public void deleteBlog(Blog blog) {
        blogDao.deleteBlog(blog);
    }
    //Blog için Tag oluşturur.
    public void createTag(Blog blog, TagType tagType){
        blogDao.saveTag(new Tag(blog,tagType));
    }
    //Tüm blogları listeler.
    public void BlogPrint() {
        System.out.println("--------------------------------------------------------------------");
        System.out.format("%-15s%-15s%-60s%n", "Yayinlayan", "Blog no", "Title\n");
        blogDao.findAllBlog()
                .stream().filter(s -> s.getBlogType().equals(BlogType.PUBLISH))
                .forEach(obj ->
                        System.out.format("%-15s%-15s%-60s%n",obj.getUser().getName(), obj.getNo(),  obj.getTitle()));
    }
    //Kullanıcıya ait blogları listeler.
    public void userPrintByBlog(User user) {
        System.out.println("--------------------------------------------------------------------");
        System.out.format("%-15s%-10s%-60s%n", user.getName(), "Blog no", "Title\n");
        blogDao.findAllBlog()
                .stream().filter(s -> s.getBlogType().equals(BlogType.PUBLISH) && s.getUser().equals(user))
                .forEach(obj ->
                        System.out.format("%-15s%-10s%-60s%n","", obj.getNo(),
                                obj.getTitle()));
    }

}
