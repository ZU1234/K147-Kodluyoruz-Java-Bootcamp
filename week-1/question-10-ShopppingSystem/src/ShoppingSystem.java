import java.util.ArrayList;
import java.util.Objects;

public final class ShoppingSystem {
    //Methodların ve listlerin buluduğusınıf.
    private static final ArrayList<Customer> customerList = new ArrayList<>();
    private static final ArrayList<Order> orderList = new ArrayList<>();
    private static final ArrayList<Invoice> invoiceList = new ArrayList<>();
    private static final Product[] productsList = {new Chair(), new Table()};


    //Listeye Müşteri ekleme metodu
    public static void customerAdd(Object name) {

        customerList.add((Customer) name);

    }

    //Listeye Sipariş ekleme metodu
    public static void orderAdd(int id, Customer customer) {

        if (id > 0 && id <= productsList.length) {
            for (Product obj : productsList) {
                if (obj.getId() == id) {
                    orderList.add(new Order(orderList.size() + 1, customer, obj, obj.getPrice()));
                }
            }
        }

    }

    //Listeye Fatura ekleme metodu
    public static void invoiceAdd(Customer customer) {
        int id = invoiceList.size() + 1;


        invoiceList.add(new Invoice(id, customer, customerOrderList(customer), invoiceTotalPrice(customer)));
        orderList.clear();


    }

    //Tüm müşlerileri ekrana yazdırma
    public static void customerAllListPrint() {
        System.out.println("MUSTERILER");
        System.out.println("---------------------------------------------------");
        System.out.format("%15s%15s%15s%n", "ID", "NAME", "AGE");
        System.out.println("---------------------------------------------------");

        for (Customer obj : customerList) {
            System.out.format("%15s%15s%15s%n", obj.getId(), obj.getName(), obj.getAge());

        }
    }

    //Toplam müşteri sayısını ekrana yazdırma.
    public static int customerAllListCountPrint() {

        return customerList.size();
    }

    //Tüm ürünleri ekrana yazdırma
    public static void productAllListPrint() {
        System.out.println("URUNLER");
        System.out.println("-----------------------------------------------------------------");
        System.out.format("%15s%15s%15s%15s%n", "ID", "NAME", "FIYAT", "Stok");
        System.out.println("-----------------------------------------------------------------");

        for (Product obj : productsList) {
            System.out.format("%15s%15s%15s%15s%n", obj.getId(), obj.getName(), obj.getPrice(), obj.getStock());

        }
    }

    //Müşteriye ait faturaları ekrana yazdırma
    public static void invoiceAllPrint(Customer customer) {
        System.out.println("*****************************************************************");
        System.out.println("Tum Faturalar");


        for (Invoice obj : invoiceList) {
            invoicePrint(obj.getId());


        }

    }

    //Müşteriiye ait son faturayı ekrana yazdırma
    public static void invoiceEndShoppingPrint(Customer customer) {
        int result = 0;
        for (Invoice obj : invoiceList) {
            if (obj.getCustomer().getId() == customer.getId()) {
                result = obj.getId();
            }
        }
        invoicePrint(result);
    }

    //Fatura id si ile faturayı ekrana yazdırma.
    public static void invoicePrint(int id) {


        int totalPrice = 0;
        for (Invoice obj : invoiceList) {
            if (obj.getId() == id && invoiceList.size() >= id && id > 0) {

                System.out.println("*****************************************************************");
                System.out.println("Fatura Hesap id : " + id);
                System.out.println("-----------------------------------------------------------------");
                System.out.format("%15s%15s%15s%n", "ID", "NAME", "FIYAT");
                for (Product pro : obj.getProduct()) {
                    System.out.format("%15s%15s%15s%n", pro.getId(), pro.getName(),
                            pro.getPrice());
                    totalPrice = totalPrice + pro.getPrice();
                }
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Toplam Tutar : " + totalPrice);
                System.out.println("Musteri Adi : " + obj.getCustomer().getName() + " " + obj.getCustomer().getSurName());
                System.out.println("*****************************************************************");
                totalPrice = 0;


            }


        }

    }

    //Müşteriye ait siparişlerin listesini ekrana yazdırırç
    public static void customerOrderListPrint(Customer customer) {


        System.out.println("Musterinin Siparisleri");
        System.out.println("-----------------------------------------------------------------");
        System.out.format("%15s%15s%15s%n", "ID", "NAME", "FIYAT");
        System.out.println("-----------------------------------------------------------------");

        for (Order obj : orderList) {
            if (Objects.equals(obj.getCustomer().getName(), customer.getName())) {
                System.out.format("%15s%15s%15s%n", obj.getId(), obj.getProduct().getName(), obj.getProduct().getPrice());

            }


        }

    }

    //Faturada bulunan siparişlerin toplam fiyat tutarını döndürür.
    public static int invoiceTotalPrice(Customer customer) {


        int totalPrice = 0;
        for (Order obj : orderList) {
            if(obj.getCustomer().getId()==customer.getId()) {


                totalPrice = totalPrice + obj.getProduct().getPrice();
            }


        }

        return totalPrice;
    }

    //Faturaya eklemek için geçici sipariş listesine siparişleri ekler.
    public static ArrayList<Product> customerOrderList(Customer customer) {
        ArrayList<Product> customerOrderProductList = new ArrayList<>();


        for (Order obj : orderList) {
            if (Objects.equals(obj.getCustomer().getName(), customer.getName()))
                customerOrderProductList.add(obj.getProduct());

        }

        return customerOrderProductList;
    }


    public static ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public static ArrayList<Order> getOrderList() {
        return orderList;
    }

    public static ArrayList<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public static Product[] getProductsList() {
        return productsList;
    }
}



