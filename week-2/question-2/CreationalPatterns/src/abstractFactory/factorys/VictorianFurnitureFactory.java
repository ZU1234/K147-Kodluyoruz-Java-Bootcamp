package abstractFactory.factorys;

import abstractFactory.implaments.IFurnitureFactory;

public class VictorianFurnitureFactory implements IFurnitureFactory {
    @Override
    public void createChair() {
        System.out.println("Victoria chair");
    }

    @Override
    public void creteCoffeeTable() {
        System.out.println("Victoria coffee table");
    }

    @Override
    public void createSofa() {
        System.out.println("Victoria kanepe");
    }
}
