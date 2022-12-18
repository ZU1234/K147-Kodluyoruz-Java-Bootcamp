package factory;

import factory.implaments.IProduct;
import factory.products.Chair;
import factory.products.Table;

public class Factory {
    public IProduct createMarket(String product){
            if(product == "Table"){
                return new Table();
            }else if(product=="VictorianChair"){
                return new Chair();
        }
            return null;
    }
}
