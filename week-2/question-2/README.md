# Creational Design Pattern’lar incelenmelidir. Örneklerle anlatınız.(20 PUAN)

Creational-->Bir nesnenin yada grubun esnek ve tekrar kullanılabilir biçimde nasıl oluşturulacağı ile ilgilenir. 5
farklı yöntemi vardır.

* Sigleton
* Factory
* Abstract Factory
* Builder
* Prototype



## Singleton

Bir sınıfın sadece bir nesnesi olur ve bu nesneye global erişim noktası sağlanır.

-Constructor private olmalıdır. Bunun sebebi nesne oluşmunun tek yerden sağlanmasıdır ve new anahtar kelimesini
istemcinin kullanmasını engellemektir.

-Referansı tutmak için değişken static olmalıdır.

-Tutulan referansa erişmek için bir methos olmalıdır.



    public class User {
        private String name;

        public User() {

        }
    }

Önce boş bir user sınıfı oluşturduk. Yalnızca contructor var.

    public class UserDao {
    private static List<User> userList = new ArrayList<>();

        public void createUser(User user) {
            userList.add(user);
        }
    }

Sonra UserDao sınıfını oluşturduk. İçerisinine user'ları sakyalacağımız bir userList listesi ve listeye ekleme yapan
method oluşturduk.

    public class UserService {
        private UserDao userDao = new UserDao();

        private UserService() {

        }

        public void createUser(User user) {
            userDao.createUser(user);
            System.out.println( userDao );
        }
    }

Yöntemleri UserService sınıfı ile örneklendireceğiz. UserService sınıfında private olan bir constructor ve
createUser methodu bulunmaktadır. createUser methodu User tipinde nesne alır ve onu listeye eklemesi için userDao ya
ait olan createUser methoduna koyar. Sonrasında User'ları sakladığımız userList listesine eklenmiş olur.

    public class UserService {
        private static UserService instance = null;
        private UserDao userDao = new UserDao();

        private UserService() {

        }

        public static UserService getInstance() {
            if (instance == null) {
                instance = new UserService();
            }
            return instance;
        }

        public void createUser(User user) {
    
            userDao.createUser(user);
            System.out.println( userDao );
        }
    }
Yukarıda görüldüğü gibi UserService tipinde bir instance değişekni oluşturuyoruz ve buna null değerini atıyoruz. Bu 
değişkenin private olması önemlidir. Sonrasında getInstance methodunda bir kontrol yapıyoruz eğer instance 
değişkeninin değeri null ise nesne üretiyoruz. Aksi taktirde daha önceden üretilmiş nesneyi döndürüryoruz. Bu sayede 
bu sınıftan yalnızca 1 nesne üretmişoluyoruz dolayısı ile UserDao nesnesinden de yalnızca bir adet üretilmiş oluyor.

Aslında bu yöntem multi-thread uygulamalarda nesnenin daha örneğinin oluşmadığı zamanda if(instance==null) durumunda 
aynı anda birden fazla thread girebilir, bu sayede o sınıfa ait birden fazla nesne örneği oluşur. Bunu  synchronized 
ile çözebiliriz.

    public class UserService {
        private static UserService instance = null;
        private static Object synchrınizedObject = new Object(); 
        private UserDao userDao = new UserDao();

        private UserService() {

        }

        public static UserService getInstance() {
            if (instance == null) {
                synchronized (synchrınizedObject){
                    if (instance == null) {
                        instance = new UserService();
                    }
                }
            }
            return instance;
        }

        public void createUser(User user) {

            userDao.createUser(user);
            System.out.println( userDao );
        }
    }

synchrınizedObject değişkenini tanımladık ve getInstance methodunu düzenlediğimizde bu sorunu çözmüş olduk.

## Factory
Factory tasarım deseni birbirleri ile ilişkili nesneleri oluşturmak için bir arayüz sağlar ve alt sınıfların zorunlu 
olarak bulundurması gereken methodlarını gösteririr. Aslında nesnenin oluşturulma durumu soyutlanır. 
 
    public interface IProduct {
       void print();
    }
Önce interface bir sınıf oluşturduk.
      
    public class Chair implements IProduct {
      @Override
      public void print() {
        System.out.println("Ben bir sandalyeyim");
      }
    }
    public class Table implements IProduct {
      @Override
      public void print() {
        System.out.println("Ben bir masayim");
      }
    }
Sonra Chair ve Table sınıflarını oluşturup imlament ettik. Print methodunu geçersiz kılıp içerisini doldurduk.

    public class Factory {
      public IProduct createMarket(String product){
        if(product == "Table"){
           return new Table();
        }else if(product=="Chair"){
            return new Chair();
        }
        return null;
     }
    }
Factory sınıfını oluşturduk ve createMarket methodunu yazdık. Methodu kullanırken product değişkenine verdiğimiz 
değere göre hangi sınıftan nesne üretileceğine karar verilecek ve nesne üretilecek. Aksi taktirde null dönecek.

     public class Main {
        public static void main(String[] args) {
           Factory factory=new Factory();
           IProduct product = factory.createMarket("Table");
            product.print();

            IProduct product1= factory.createMarket("Chair");
            product1.print();
        }
     }
Main sınıfı içerisinde çalıştırdığımızda. hangi print methodunu döndüreceğini createMarket methodu içerisinde ki 
parametreye verilen değer belirleyecektir.

## Abstract Factory 

Factory tasarımında bir ürünün deseni soyutlanmışken Abstract Factory tasarımında birbirleri ile ilişkili ürün 
ailelerinin oluşturulması soyutlanır.


    public interface IFurnitureFactory {
        void createChair();
        void creteCoffeeTable();
        void createSofa();
    }
Önce IFurnitureFactory interface sınıfını oluşturuyoruz. içerisine override edilecek metodları yazıyoruz.

    public class VictorianFurnitureFactory implements IFurnitureFactory {
        @Override
        public void createChair() {
            System.out.println("Victoria chair");
        }

        @Override
        public void creteCoffeeTable() {
            System.out.println("Victoria coffee table");
        }

        @Override
        public void createSofa() {
            System.out.println("Victoria kanepe");
        }
    }
VictorianFurnitureFactory sınıfını IFurnitureFactory interface sınıfından implament ediyoruz. Override edilmiş 
methodların içini dolduruyoruz.

    public class ModernFurnitureFactory implements IFurnitureFactory {
        @Override
        public void createChair() {
            System.out.println("Modern chair");
        }

        @Override
        public void creteCoffeeTable() {
            System.out.println("Modern coffee table");
        }

        @Override
        public void createSofa() {
            System.out.println("Modern kanepe");
        }
    }
ModernFurnitureFactory sınıfını IFurnitureFactory interface sınıfından implament ediyoruz. Override edilmiş
methodların içini dolduruyoruz.

    public class Main {
        public static void main(String[] args) {
            ModernFurnitureFactory modern =new ModernFurnitureFactory();
            modern.createChair();

            VictorianFurnitureFactory victoria =new VictorianFurnitureFactory();
            victoria.createChair();
        }
    }
Şeklinde yazıp çalıştırğımızda createChair methodunun 2 kez çalıştırıldığını ve farklı sonuç verdiğini görmekteyiz.

    Modern chair
    Victoria chair
Şeklinde bize sonuç verir. Buda bize abstract Factory tasarımını doğru yaptığımızı gösterir.

## Builder

Karmaşık yapıdaki nesnelerin oluşturulmasında istemcinin sadece nesne tipini belirterek üretimi gerçekleştirmesini 
sağlar.

    public class Drinks {
        public int id;
        public String name;
        public double price;
        public double discountedPrice;
        public Boolean discountApplied;
        public String note;

        public Drinks() {

        }
    }
Drinks adında bir sınıf oluşturduk ve tüm değişkenlerini public yazdık.

    public abstract class DrinksBuilder {
        public abstract void getDrink();
        public abstract void applyDiscount();
        public abstract void addDrinksNote();
        public abstract Drinks getResult();
    }
Abstract DrinksBuilder sınıfını oluşturduk ve kalıtım yapan sınıfların override etmesi gerekenleri yazdık.

    public class Product {
        private DrinksBuilder drinksBuilder;
        
        public Product(DrinksBuilder drinksBuilder){
            this.drinksBuilder=drinksBuilder;
        }
        public void make(){
            drinksBuilder.getDrink();
            drinksBuilder.applyDiscount();
            drinksBuilder.addDrinksNote();
            drinksBuilder.getResult();
        }
    }
Product sınıfını oluşturduk make methodunda DrinksBuilder'a ait methodları çalıştırdık.
    
    public class OrderDrinksBuilder extends DrinksBuilder {
        Drinks drinks = new Drinks();

        @Override
        public void getDrink() {

            drinks.id = 1;
            drinks.name = "su";
            drinks.price = 10;
        }

        @Override
        public void applyDiscount() {
            drinks.discountedPrice = drinks.price * 0.5;
            drinks.discountApplied = true;
        }

        @Override
        public void addDrinksNote() {
            drinks.note = "indirim kodunuz uygulanmistir.";
        }

        @Override
        public Drinks getResult() {
            return drinks;
        }
    }

OrderDrinksBuilder sınıfını oluşturduk ve DrinksBuilder abstract sınıfından kalıtım aldık. Sonrasında override 
edilmiş methodların içini doldurduk.

        public class Main {
            public static void main(String[] args) {
                DrinksBuilder drinksBuilder =new OrderDrinksBuilder();

                Product product =new Product(drinksBuilder);
                product.make();

                Drinks drinks = drinksBuilder.getResult();

                System.out.format("%-15s%-15s%-15s%-30s%-15s%n","id","name","price","discountedPrice","note");
                System.out.format("%-15s%-15s%-15s%-30s%-15s%n",drinks.id,
                drinks.name, drinks.price,drinks.discountedPrice,drinks.note);

            }
        }
Şekilinde kodlarımızı yazıp çalıştırdığımızda ürünümüz için indirim uygulamasını beklemekteyiz.

        id             name           price          discountedPrice               note           
        1              su             10.0           5.0                           indirim kodunuz uygulanmistir.
Şeklinde çıktı vermektedir. Bu durumda builder tasarımı doğru bir şekilde tamamlanmıştır.

## Prototype

Prototype tasarımı nesnelerin kopyalarını elde etmeyi sağlar.

    public interface IClonablePrototype <T> extends Cloneable{
        T clone() throws CloneNotSupportedException;

    }
IClonablePrototype interface sınıfını oluşturuyoruz ve Cloneable'dan kalıtım yapıyoruz. İçerisine override 
edilecelek clone methodunu belirtiyoruz.

    public class Employee implements IClonablePrototype{
        String firstName;
        String lastName;

        public Employee(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public Employee clone() throws CloneNotSupportedException {
            return (Employee) super.clone();
        }
    }
Employee sınıfını oluşturuyoruz ve IClonablePrototype'dan implament ediyoruz. clone methodunu override ediyoruz ve 
içerisini dolduruyoruz. Bir de contructor ekliyoruz.

    public class Main {
        public static void main(String[] args) throws CloneNotSupportedException {
            Employee zeynep = new Employee("Zeynep","UYGUN");
            Employee zeynepClone =zeynep.clone();


            System.out.println(zeynep==zeynepClone);
        }
    }
Aynı nesne örneklerini farklı referanslarda tuttuğunu görmek için kodumuzu yukarıdaki gibi yazıyoruz eğer sonuc 
false olursa tasarım doğru yapılmıştır.

    false
Kodu çalıştırdığımızda false yanırını aldık bu durumda tasarım doğrudur. Birbirinin aynısı ama farklı referanslarda 
olan nesneler elde etmiş olduk.