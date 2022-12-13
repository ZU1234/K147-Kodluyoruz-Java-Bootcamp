public class Order {
    private final int id;
    private final Customer customer;
    private final Product product;
    private final int totalPrice;


//Sipariş sınfı
    public Order(int id, Customer customer, Product product, int totalPrice) {
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


    public Product getProduct() {
        return product;
    }


    public int getTotalPrice() {
        return totalPrice;
    }





}
