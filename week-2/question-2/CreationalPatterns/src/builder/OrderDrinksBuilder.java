package builder;

import builder.abstracts.DrinksBuilder;

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
