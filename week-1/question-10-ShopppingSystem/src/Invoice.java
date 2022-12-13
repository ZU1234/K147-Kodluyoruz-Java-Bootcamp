import java.util.ArrayList;

public final class Invoice {
    private int id;
    private Customer customer;
    private ArrayList<Product> product;
    private int totalPrice;

    //Fatura sınıfı
    public Invoice(int id, Customer customer, ArrayList<Product> product, int totalPrice) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }


    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Product> getProduct() {
        return product;
    }


    public int getTotalPrice() {
        return totalPrice;
    }


}
