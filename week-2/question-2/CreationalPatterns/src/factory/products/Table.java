package factory.products;

import factory.implaments.IProduct;

public class Table implements IProduct {
    @Override
    public void print() {
        System.out.println("Ben bir masayim");
    }
}
