import java.util.Objects;

public class Main {
    public static void main(String[] args) {


        Customer zeynep = new Customer(1, "Zeynep", "Uygun", 26);
        Customer tuba = new Customer(2, "Tuba", "Uygun", 25);
        Customer ali = new Customer(3, "Ali", "Sunal", 50);
        Customer veli = new Customer(4, "Veli", "Kefir", 60);
        Customer ada = new Customer(5, "ada", "Katip", 30);
        Customer cem1 = new Customer(6, "Cem", "Boyacı", 28);
        Customer cem2 = new Customer(7, "Cem", "Dirman", 27);
        Customer cem3 = new Customer(8, "Cem", "Yıldız", 30);
        Customer cem4 = new Customer(9, "Cem", "Karaca", 29);
        Customer cem5 = new Customer(10, "Cem", "Cay", 18);


        ShoppingSystem.customerAdd(zeynep);
        ShoppingSystem.customerAdd(tuba);
        ShoppingSystem.customerAdd(ali);
        ShoppingSystem.customerAdd(veli);
        ShoppingSystem.customerAdd(ada);
        ShoppingSystem.customerAdd(cem1);
        ShoppingSystem.customerAdd(cem2);
        ShoppingSystem.customerAdd(cem3);
        ShoppingSystem.customerAdd(cem4);
        ShoppingSystem.customerAdd(cem5);


        System.out.println("MUSTERI SAYISI : " + ShoppingSystem.customerAllListCountPrint());


        ShoppingSystem.orderAdd(1, zeynep);//Müşterilere ürün id'si ile ürün ekler.
        ShoppingSystem.orderAdd(1, zeynep);

        ShoppingSystem.invoiceAdd(zeynep);//Ürünleri Faturalandırır.

        ShoppingSystem.orderAdd(2, zeynep);//Müşterilere ürün id'si ile ürün ekler.
        ShoppingSystem.invoiceAdd(zeynep);

        ShoppingSystem.orderAdd(2, tuba);
        ShoppingSystem.orderAdd(2, tuba);
        ShoppingSystem.invoiceAdd(tuba);//Ürünleri Faturalandırır.

        ShoppingSystem.orderAdd(1, cem1);
        ShoppingSystem.orderAdd(2, cem1);
        ShoppingSystem.orderAdd(1, cem1);
        ShoppingSystem.invoiceAdd(cem1);//Ürünleri Faturalandırır.

        ShoppingSystem.orderAdd(1, cem2);
        ShoppingSystem.orderAdd(1, cem2);
        ShoppingSystem.orderAdd(1, cem2);
        ShoppingSystem.orderAdd(1, cem2);
        ShoppingSystem.orderAdd(2, cem2);
        ShoppingSystem.orderAdd(2, cem2);
        ShoppingSystem.orderAdd(2, cem2);
        ShoppingSystem.invoiceAdd(cem2);//Ürünleri Faturalandırır.

        ShoppingSystem.orderAdd(2, cem3);
        ShoppingSystem.invoiceAdd(cem3);//Ürünleri Faturalandırır.

        ShoppingSystem.orderAdd(2, cem4);
        ShoppingSystem.orderAdd(2, cem4);
        ShoppingSystem.invoiceAdd(cem4);//Ürünleri Faturalandırır.

        ShoppingSystem.orderAdd(1, cem5);
        ShoppingSystem.invoiceAdd(cem5);//Ürünleri Faturalandırır.


        //İsmi Cem olan müşterilerin aldıkları ürün sayısını bulan,
        int count = 0;

        for (Invoice obj : ShoppingSystem.getInvoiceList()) {
            if (Objects.equals(obj.getCustomer().getName(), "Cem")) {
                for (Product pro : obj.getProduct()) {
                    count++;
                }

            }
        }
        System.out.println("Ismi Cem olan musterilerin aldiklari uruün sayisi : " + count);

        //İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarını hesaplayın
        int totalPrice = 0;
        for (Invoice obj : ShoppingSystem.getInvoiceList()) {
            if (Objects.equals(obj.getCustomer().getName(), "Cem") &&
                    obj.getCustomer().getAge() > 25 &&
                    obj.getCustomer().getAge() < 30) {


                totalPrice = totalPrice + obj.getTotalPrice();


            }
        }
        System.out.println("Ismi Cem olup yasi 30 dan kucuk 25 ten buyuk musterilerin toplam alisveris tutarı : " + totalPrice);
        //Sistemdeki 1500 TL üzerindeki faturaları listeleyin

        for (Invoice obj : ShoppingSystem.getInvoiceList()) {
            if (obj.getTotalPrice() > 1500) {
                ShoppingSystem.invoicePrint(obj.getId());
            }
        }


    }


}