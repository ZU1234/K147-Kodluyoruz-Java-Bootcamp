package factory.products;

import factory.implaments.IProduct;

public class Chair implements IProduct {
    @Override
    public void print() {
        System.out.println("Ben bir sandalyeyim");
    }
}
