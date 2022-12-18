package builder;

import builder.abstracts.DrinksBuilder;

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
