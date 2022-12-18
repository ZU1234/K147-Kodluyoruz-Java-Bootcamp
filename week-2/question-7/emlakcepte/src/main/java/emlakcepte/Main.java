package emlakcepte;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import emlakcepte.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import emlakcepte.service.RealtyService;
import emlakcepte.service.UserService;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        RealtyService realtyService = new RealtyService();


        List<User> userList = testUserAdd(userService);
        User userPelin = userList.get(0);
        User userSami = userList.get(1);
        User userCem = userList.get(2);

        testLogin("mimar.pelin@gmail.com", "Pelin123", userService);
        testLogin("sami@gmail.com", "123456", userService);
        testLogin("abc@gmail.com", "1321", userService);
        testLogin("cem@gmail.com", "123456", userService);


        testPasswordUpdate(userPelin, userService);

        /**-------------------Ödev cevapları----------------------------**/
        /**Bireysel kullanıcılar sadece Konut tipinde ve en fazla 3 ilan yayınlayabilirler
         Yukarıda zaten bireysellere ilan eklenmişti yeniden eklemeye çalıştık ve 3 ilandan fazla ilan eklenemediği
         için hata mesajı verdi ekleme yapmadı.
         **/
        System.out.println("------Bireysel kullanıcılar sadece Konut tipinde ve en fazla 3 ilan " +
                "yayınlayabilirler Test-----");
        testRealtyAdd(userList, realtyService);

        /**Şehir ve ilçe bazlı ilan arama.kaydetme**/

        realtyService.getAllByProvince("İstanbul");
        realtyService.getAllByCounty("Taksim");

        /**Kullanıcı yaptığı aramaları listeleyebilmeli.**/
        System.out.println("-------Kayitli Aramalar--------------");
        realtyService.getAllSearch().stream().forEach(obj -> System.out.println("Search : " + obj));

        /**Şehir vitrini 10 ilandan oluşur. Şehir bazlı vitrinler oluşturun.**/
        System.out.println("----Sehir Vitrini-----");
        realtyService.provinceShowcasePrint(10);

        /**İstanbul,Ankara,İzmir Şehirlerindeki İlanlarının sayısını bulun.**/
        System.out.println("----------------Sehir ve Ilan Sayisi Listesi--------");
        System.out.println("Istanbul : " + realtyService.getAllByProvinceCount("Istanbul"));
        System.out.println("Ankara : " + realtyService.getAllByProvinceCount("Ankara"));
        System.out.println("Izmir : " + realtyService.getAllByProvinceCount("Izmir"));

        /**İstanbul,Ankara,İzmir Şehirlerindeki Satılık konut İlanlarının sayısını bulun.**/
        System.out.println("----------------Sehir ve Satilik konut Ilan Sayisi Listesi--------");
        System.out.println("Istanbul : " + realtyService.getRealtyByProvinceByTypeByTypeOfStructureCount("Istanbul",
                RealtyCategory.SALE, TypeOfStructure.HOUSE));
        System.out.println("Ankara : " + realtyService.getRealtyByProvinceByTypeByTypeOfStructureCount("Ankara",
                RealtyCategory.SALE, TypeOfStructure.HOUSE));
        System.out.println("Izmir : " + realtyService.getRealtyByProvinceByTypeByTypeOfStructureCount("Izmir",
                RealtyCategory.SALE, TypeOfStructure.HOUSE));

    }


    private static User prepareUser(String name, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setMail(email);
        user.setPassword(password);
        user.setType(UserType.CORPARETE);
        user.setCreateDate(LocalDateTime.now());
        user.setUserState(UserState.OUT);
        return user;
    }

    public static List<User> testUserAdd(UserService userService) {


        User userPelin = prepareUser("Pelin", "mimar.pelin@gmail.com", "Pelin123");
        // User userPelin1 = prepareUser("Pelin1", "mimar.pelin@gmail.com", "Pelin123");

        User userSami = new User("Sami", "sami@gmail.com", "123456", UserType.INDIVIDUAL, Collections.emptyList(),
                UserState.OUT);
        User userCem = new User("Cem", "cem@gmail.com", "123456", UserType.CORPARETE, Collections.emptyList(),
                UserState.OUT);


        userService.createUser(userPelin);
        userService.createUser(userSami);
        userService.createUser(userCem);
        //userService.createUser(userPelin1);

        List<User> userList = new ArrayList<>();

        userList.add(userPelin);
        userList.add(userSami);
        userList.add(userCem);
        return userList;
    }

    public static void testRealtyAdd(List<User> userList, RealtyService realtyService) {
        User userPelin = userList.get(0);
        User userSami = userList.get(1);
        User userCem = userList.get(2);

        //-------------------------------------------------------
        Realty realty0 = new Realty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userSami,
                RealtyType.ACTIVE, RealtyCategory.SALE, Type.VILLA, TypeOfStructure.HOUSE, 72000000);
        realty0.setProvince("Ankara");
        realty0.setCounty("Zekeriyaköy");

        //-------------------------------------------------------
        Realty realty = new Realty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userPelin,
                RealtyType.ACTIVE, RealtyCategory.SALE, Type.VILLA, TypeOfStructure.HOUSE, 72000000);

        realty.setProvince("Izmir");
        realty.setCounty("Zekeriyaköy");
        //--------------------------------------------------------
        Realty realty1 = new Realty();
        realty1.setNo(124L);
        realty1.setTitle("Büyükdere Ana Cadde üstünde 16.060 m2 kapalı alanlı PLAZA");
        realty1.setPublishedDate(LocalDateTime.of(2022, 3, 1, 2, 8));
        realty1.setStatus(RealtyType.ACTIVE);
        realty1.setUser(userPelin);
        realty1.setProvince("Ankara");
        realty1.setCounty("Buyukdere");
        realty1.setCategory(RealtyCategory.RENT);
        realty1.setType(Type.BUILDING);
        realty1.setTypeOfStructure(TypeOfStructure.STORE);
        realty1.setPrice(1200000);

        //--------------------------------------------------------
        Realty favori1 = new Realty();
        favori1.setNo(125L);
        favori1.setTitle("KAVAKPINAR MAHALLESİNDE 2+1 80 M2 ARAKAT İSKANLI");
        favori1.setPublishedDate(LocalDateTime.of(2022, 2, 5, 4, 3));
        favori1.setStatus(RealtyType.ACTIVE);
        favori1.setUser(userPelin);
        favori1.setProvince("Ankara");
        favori1.setCounty("Kavakpinar");
        favori1.setCategory(RealtyCategory.RENT);
        favori1.setTypeOfStructure(TypeOfStructure.HOUSE);
        favori1.setType(Type.DETACHED);
        favori1.setPrice(950000);

        //--------------------------------------------------------
        Realty realty2 = new Realty(121543L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA",
                LocalDateTime.of(2022, 10, 15, 3, 5),
                userPelin,
                RealtyType.ACTIVE, RealtyCategory.SALE, Type.VILLA, TypeOfStructure.HOUSE, 15000000);
        realty2.setProvince("Izmir");
        realty2.setCounty("Zekiyaköy");
        //--------------------------------------------------------
        Realty realty3 = new Realty(10523L, "ŞİLE MERKEZE YÜRÜME MESAFESİNDE BOĞAZİÇİ VİLLARINDA VATANDAŞLIĞA UYGUN " +
                "YEŞİLLİKLER İÇERİSİNDE",
                LocalDateTime.of(2021, 5, 6, 6, 50), userPelin,
                RealtyType.ACTIVE, RealtyCategory.SALE, Type.VILLA, TypeOfStructure.HOUSE, 60000000);
        realty3.setProvince("Istanbul");
        realty3.setCounty("Sile");
        //--------------------------------------------------------
        Realty realty4 = new Realty(12263L, "REMAX İNCİ'DEN SARIYER'DE SATILIK DENİZ MANZARALI MÜSTAKİL BİNA",
                LocalDateTime.of(2022, 1, 12, 5, 40), userPelin,
                RealtyType.ACTIVE, RealtyCategory.DAILY, Type.DETACHED, TypeOfStructure.STORE, 20000000);
        realty4.setProvince("Ankara");
        realty4.setCounty("Sariyer");
        //--------------------------------------------------------
        Realty realty5 = new Realty(12053L, "Avcılar Firüzköy Mahallesi Satılık Bina",
                LocalDateTime.of(2019, 10, 27, 9, 20), userPelin,
                RealtyType.ACTIVE, RealtyCategory.RENT, Type.BUILDING, TypeOfStructure.STORE, 40000000);
        realty5.setProvince("Istanbul");
        realty5.setCounty("Avcilar");
        //--------------------------------------------------------
        Realty realty6 = new Realty(1230251L, "GÜNEŞLİ BAĞCILAR BASIN EKSPRES KİRALIK OFİS KATI 350M2",
                LocalDateTime.of(2020, 3, 15, 4, 30), userCem,
                RealtyType.ACTIVE, RealtyCategory.RENT, Type.APARTMENT, TypeOfStructure.STORE, 1200000);
        realty6.setProvince("Istanbul");
        realty6.setCounty("Bagcilar");
        //--------------------------------------------------------
        Realty realty7 = new Realty(123020L, "BAĞDAT CADDESİNDE İŞYERİNE UYGUN KİRALIK DAİRE", LocalDateTime.now(),
                userSami,
                RealtyType.ACTIVE, RealtyCategory.RENT, Type.OFIS, TypeOfStructure.STORE, 2500000);
        realty7.setProvince("Izmir");
        realty7.setCounty("Bagdat");
        //--------------------------------------------------------
        Realty realty8 = new Realty(1225L, "Sedadkent 'te Büyük Bahçeli, Havuzlu, Manzaralı ÇOK ŞIK Villa",
                LocalDateTime.now(), userCem,
                RealtyType.ACTIVE, RealtyCategory.SALE, Type.VILLA, TypeOfStructure.HOUSE, 80000000);
        realty8.setProvince("Istanbul");
        realty8.setCounty("Taksim");
        //-------------------------------------------------------------
        Realty realty9 = new Realty(12362L, "Üçkuyular'da Demokrasi Üniversitesi Yakını Satılık Dükkan",
                LocalDateTime.now(), userCem,
                RealtyType.ACTIVE, RealtyCategory.SALE, Type.OFIS, TypeOfStructure.STORE, 80000000);
        realty9.setProvince("Izmir");
        realty9.setCounty("Demokrasi");
        //-------------------------------------------------------------
        Realty realty10 = new Realty(1215L, "Üçkuyular'da Demokrasi Üniversitesi Yakını Satılık Dükkan",
                LocalDateTime.now(), userCem,
                RealtyType.ACTIVE, RealtyCategory.SALE, Type.OFIS, TypeOfStructure.STORE, 80000000);
        realty10.setProvince("Canakkale");
        realty10.setCounty("Demokrasi");
        //-------------------------------------------------------------
        Realty realty11 = new Realty(12156L, "Üçkuyular'da Demokrasi Üniversitesi Yakını Satılık Dükkan",
                LocalDateTime.now(), userCem,
                RealtyType.ACTIVE, RealtyCategory.SALE, Type.OFIS, TypeOfStructure.STORE, 80000000);
        realty11.setProvince("Canakkale");
        realty11.setCounty("Demokrasi");
        //-------------------------------------------------------------
        Realty realty12 = new Realty(1256L, "Üçkuyular'da Demokrasi Üniversitesi Yakını Satılık Dükkan",
                LocalDateTime.now(), userCem,
                RealtyType.ACTIVE, RealtyCategory.SALE, Type.OFIS, TypeOfStructure.STORE, 80000000);
        realty12.setProvince("Hatay");
        realty12.setCounty("Demokrasi");
        //-------------------------------------------------------------
        Realty realty13 = new Realty(1254L, "Üçkuyular'da Demokrasi Üniversitesi Yakını Satılık Dükkan",
                LocalDateTime.now(), userCem,
                RealtyType.ACTIVE, RealtyCategory.SALE, Type.OFIS, TypeOfStructure.STORE, 80000000);
        realty13.setProvince("Izmit");
        realty13.setCounty("Demokrasi");
        //--------------------------------------------------------
        Realty realty14 = new Realty(1215L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA",
                LocalDateTime.of(2022, 10, 15, 3, 5),
                userPelin,
                RealtyType.ACTIVE, RealtyCategory.SALE, Type.VILLA, TypeOfStructure.HOUSE, 15000000);
        realty14.setProvince("Bursa");
        realty14.setCounty("Zekiyaköy");
        //--------------------------------------------------------
        Realty realty15 = new Realty(124L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA",
                LocalDateTime.of(2022, 10, 15, 3, 5),
                userPelin,
                RealtyType.ACTIVE, RealtyCategory.SALE, Type.VILLA, TypeOfStructure.HOUSE, 15000000);
        realty15.setProvince("Bursa");
        realty15.setCounty("Zekiyaköy");
        //--------------------------------------------------------
        Realty realty16 = new Realty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userPelin,
                RealtyType.ACTIVE, RealtyCategory.SALE, Type.VILLA, TypeOfStructure.HOUSE, 72000000);

        realty16.setProvince("Ardahan");
        realty16.setCounty("Zekeriyaköy");
        //--------------------------------------------------------
        Realty realty17 = new Realty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userPelin,
                RealtyType.ACTIVE, RealtyCategory.SALE, Type.VILLA, TypeOfStructure.HOUSE, 72000000);

        realty17.setProvince("Balikesir");
        realty17.setCounty("Zekeriyaköy");
        //--------------------------------------------------------
        Realty realty18 = new Realty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userPelin,
                RealtyType.ACTIVE, RealtyCategory.SALE, Type.VILLA, TypeOfStructure.HOUSE, 72000000);

        realty18.setProvince("Antalya");
        realty18.setCounty("Zekeriyaköy");
        //--------------------------------------------------------
        Realty realty19 = new Realty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userPelin,
                RealtyType.ACTIVE, RealtyCategory.SALE, Type.VILLA, TypeOfStructure.HOUSE, 72000000);

        realty19.setProvince("Balikesir");
        realty19.setCounty("Zekeriyaköy");
        //-------------------------------------------------------
        Realty realty20 = new Realty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userSami,
                RealtyType.ACTIVE, RealtyCategory.SALE, Type.VILLA, TypeOfStructure.HOUSE, 72000000);
        realty20.setProvince("Ankara");
        realty20.setCounty("Zekeriyaköy");
        //-------------------------------------------------------
        Realty realty21 = new Realty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userSami,
                RealtyType.ACTIVE, RealtyCategory.SALE, Type.VILLA, TypeOfStructure.HOUSE, 72000000);
        realty21.setProvince("Ankara");
        realty21.setCounty("Zekeriyaköy");

        realtyService.createRealty(realty0);
        realtyService.createRealty(realty);

        realtyService.createRealty(realty1);
        realtyService.createRealty(favori1);

        realtyService.createRealty(realty2);
        realtyService.createRealty(realty3);
        realtyService.createRealty(realty4);
        realtyService.createRealty(realty5);
        realtyService.createRealty(realty6);
        realtyService.createRealty(realty7);
        realtyService.createRealty(realty8);
        realtyService.createRealty(realty9);
        realtyService.createRealty(realty10);
        realtyService.createRealty(realty11);
        realtyService.createRealty(realty12);
        realtyService.createRealty(realty13);
        realtyService.createRealty(realty14);
        realtyService.createRealty(realty15);
        realtyService.createRealty(realty16);
        realtyService.createRealty(realty17);
        realtyService.createRealty(realty18);
        realtyService.createRealty(realty19);
        realtyService.createRealty(realty20);
        realtyService.createRealty(realty21);

    }


    public static void testPasswordUpdate(User user, UserService userService) {
        //System.out.println("Pelin password : "+userPelin.getPassword());
        userService.updatePassword(user, "12pelin12");
        //System.out.println("Pelin new password : "+userPelin.getPassword());
        userService.updatePassword(user, "Pelin1");
        userService.updatePassword(user, "Pelin12");
        userService.updatePassword(user, "Pelin125");
        //userService.updatePassword(userPelin,"Pelin12");//Burada hata verir son 3 şifre ile aynı olmaz.
        userService.updatePassword(user, "pelin123");

    }

    public static void testMessageAdd(List<User> userList) {
        User userPelin = userList.get(0);
        User userSami = userList.get(1);
        User userCem = userList.get(2);

        Message message = new Message("acil dönüş", "ilan ile ilgili bilgilendirme verebilir misiniz?",
                userPelin,
                userSami);

        Message message1 = new Message("acil dönüş", "Merhaba, merak ettiklerinizi sormaniz daha iyi olur diye " +
                "dusunuyorum. Ilanda bir cok bilgi mevcut.",
                userSami,
                userPelin);
        Message message2 = new Message("acil dönüş", "Pazarlik payi var mi?",
                userPelin,
                userSami);
        Message message3 = new Message("acil dönüş", "Malesef pazarlik payi yok.",
                userSami,
                userPelin);
        Message message4 = new Message("acil dönüş", "Tesekkurler iyi gunler.",
                userPelin,
                userSami);
        Message message5 = new Message("acil dönüş", "Merhaba",
                userCem,
                userPelin);

        userSami.setMessages(List.of(message, message1, message2, message3, message4));
        userPelin.setMessages(List.of(message, message1, message2, message3, message4, message5));
        userCem.setMessages(List.of(message5));


    }

    public static void testMessageInboxContacts(UserService userService, User user) {
        System.out.println("-------Gelen kutusu kisileri------");

        userService.inboxContactsListPrint(user);
    }

    public static void testMessageSentBoxContacts(UserService userService, User user) {
        System.out.println("-------Gönderilen kutusu kisileri------");

        userService.sentBoxContactsListPrint(user);
    }

    public static void testMessageChatPrint(User userTo, User userFrom, UserService userService) {
        System.out.println("----------Mesajlar--------------");
        userService.chatListPrint(userFrom, userTo);

    }

    public static void testRealtySortingByCurrentDate(RealtyService realtyService) {
        System.out.println("----------Tarihe Gore Siralama--------------");
        realtyService.sortingByCurrentDate().stream().forEach(obj -> {
            System.out.println("Ilan sahibi : " + obj.getUser().getName() + "---->Fiyat : " + obj.getPublishedDate());
        });

    }

    public static void testRealtySortingByLowPrice(RealtyService realtyService) {
        System.out.println("----------Dusuk fiyata Gore Siralama--------------");
        realtyService.sortingByLowPrice().stream().forEach(obj -> {
            System.out.println("Ilan sahibi : " + obj.getUser().getName() + "---->Fiyat : " + obj.getPrice());
        });

    }

    public static void testRealtySortingByHighPrice(RealtyService realtyService) {
        System.out.println("----------Yuksek fiyata Gore Siralama--------------");
        realtyService.sortingByHighPrice().stream().forEach(obj -> {
            System.out.println("Ilan sahibi : " + obj.getUser().getName() + "---->Fiyat : " + obj.getPrice());
        });

    }

    public static void testRealtySortingByHighPriceAndUser(User user, RealtyService realtyService) {
        System.out.println("----------Yuksek fiyata ve Kullanıcıya Gore Siralama--------------");
        realtyService.sortingByHighPrice().stream()
                .filter(obj -> obj.getUser().getName().equals(user.getName()))
                .forEach(obj -> {
                    System.out.println("Ilan sahibi : " + obj.getUser().getName() + "---->Fiyat : " + obj.getPrice());
                });

    }

    public static void testLogin(String mail, String password, UserService userService) {
        //Kullanıcı hesabına giriş yapıyor.
        userService.login(mail, password);


    }

    public static void testOnlineList(UserService userService) {
        System.out.println("---------------Cevrimici Kullanicilar-------------------");
        userService.onlineList().stream().forEach(obj -> System.out.println(obj.getName()));
    }

    public static void testAccountIsOpenByUserList(UserService userService) {
        System.out.println("---------------Oturumu Acik Kullanicilar-------------------");
        userService.accountIsOpenListByUser().stream().forEach(obj -> System.out.println(obj.getName()));
    }


}
