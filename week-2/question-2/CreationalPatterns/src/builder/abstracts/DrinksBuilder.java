package builder.abstracts;

import builder.Drinks;

public abstract class DrinksBuilder {
    public abstract void getDrink();
    public abstract void applyDiscount();
    public abstract void addDrinksNote();
    public abstract Drinks getResult();
}
