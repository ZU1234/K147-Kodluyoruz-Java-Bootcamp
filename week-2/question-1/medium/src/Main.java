import model.*;
import service.BlogService;
import service.UserService;

import java.time.LocalDateTime;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        UserService userService = new UserService();
        BlogService blogService = new BlogService();

        User userJhon = prepareUser("Jhon", "jhon@gmail.com", "456jhn");
        User userMarie = prepareUser("Marie", "marie@gmail.com", "marie526");
        User userJack = prepareUser("Jack", "Jack@gmail.com", "jck1514");
        User userNoah = prepareUser("Noah", "noah@gmail.com", "noah5236");


        userService.createUser(userJhon);
        userService.createUser(userMarie);
        userService.createUser(userJack);
        userService.createUser(userNoah);

        /**Blog taslağı oluşturuldu taslak oluşturuluyor.**/

        Blog blog1 = new Blog(123L, userJhon,
                "SQL'de Geçici Tablolar",
                "SQL'de geçici tablolar kullanmak, herhangi bir veri uzmanının bilmesi gereken bir beceridir. Bunu " +
                        "yapmanın birkaç yaygın yolu vardır.",
                Collections.singletonList(TagType.DataScience), LocalDateTime.now(), BlogType.PRIVATE);


        Blog blog2 = new Blog(1234L, userMarie,
                "Logolar: Nesnel Olarak İyi Bir Logo İçin 4 Test",
                "Logolar stresli olabilir. Onlar markanın yüzü. Onlar bir kimlik. Doğru yapıldığında logo, " +
                        "müşterilerin "+"markayla bağlantı kurma, paylaşma ve hatırlama şekli olacaktır. Logolar çok " +
                        "fazla zaman, çaba ve para gerektirebilir. ",
                Collections.singletonList(TagType.DataScience),
                LocalDateTime.now(),BlogType.PRIVATE);

        Blog blog3 = new Blog(3452L, userNoah,
                "Baslik Henuz yok yakında gelecek...",
                "Text ",
                Collections.singletonList(TagType.DataScience),
                LocalDateTime.now(),BlogType.PRIVATE);



        blogService.createBlog(blog1);
        blogService.createBlog(blog2);
        blogService.createBlog(blog3);


        /**Blog yayınlanıyor**/
        blog1.setBlogType(BlogType.PUBLISH);//Blogları halka açık hale getirdik.
        blog2.setBlogType(BlogType.PUBLISH);
        blog3.setBlogType(BlogType.PUBLISH);

        /**Blog siliniyor**/
        System.out.println(blog1.getNo()+" siliniyor.");
        blogService.deleteBlog(blog1);//Blog1'i sildi.
        System.out.println(blog1.getNo()+" silindi.");


        /**Kullanıcıları takip ediyor.**/
        userService.createFollow(userJack,userMarie);//Jack, Marie'yi takip ediyor.
        userService.createFollow(userJhon,userMarie);
        userService.createFollow(userJack,userNoah);
        userService.createFollow(userNoah,userMarie);

        userService.printAllFollowByUser(userJack);
        userService.printAllFollowByUser(userNoah);

        /**Kişilerin bloglarını listeleme**/

        blogService.userPrintByBlog(userMarie);//Kullanıcıya ait tüm publish blogları listeler.
        blogService.userPrintByBlog(userJhon);
        blogService.BlogPrint();

        /**Kullanıcıların tag’leri takip etmesi**/
        userService.createTag(userJack,TagType.DataScience);
        userService.createTag(userJack,TagType.Technology);
        userService.printAllUserTagList(userJack);



    }

    private static User prepareUser(String name, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setUserType(UserType.NORMAL);
        user.setBlogList(Collections.emptyList());
        user.setTag(Collections.emptyList());
        user.setFollow(Collections.emptyList());
        user.setCreateDateTime(LocalDateTime.now());
        return user;
    }

}