package factory;

import factory.implaments.IProduct;

public class Main {
    public static void main(String[] args) {
        Factory factory=new Factory();
        IProduct product = factory.createMarket("Table");
        product.print();

        IProduct product1= factory.createMarket("VictorianChair");
        product1.print();
    }
}
