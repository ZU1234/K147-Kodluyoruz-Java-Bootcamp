package builder;

import builder.abstracts.DrinksBuilder;

public class Product {
 private DrinksBuilder drinksBuilder;
 public Product(DrinksBuilder drinksBuilder){
     this.drinksBuilder=drinksBuilder;
 }
 public void make(){
     drinksBuilder.getDrink();
     drinksBuilder.applyDiscount();
     drinksBuilder.addDrinksNote();
     drinksBuilder.getResult();
 }
}
