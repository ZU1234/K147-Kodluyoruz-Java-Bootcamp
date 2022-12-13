public class Product {
    private final int id;
    private final String name;
    private final int price;
    private final int stock;

//Ürünlerin ata sınıfı
    public Product(int id, String name, int price,int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock=stock;

    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }



    public int getPrice() {
        return price;
    }



    public int getStock() {
        return stock;
    }


}
