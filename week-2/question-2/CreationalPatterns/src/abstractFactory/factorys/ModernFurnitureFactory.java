package abstractFactory.factorys;

import abstractFactory.implaments.IFurnitureFactory;

public class ModernFurnitureFactory implements IFurnitureFactory {
    @Override
    public void createChair() {
        System.out.println("Modern chair");
    }

    @Override
    public void creteCoffeeTable() {
        System.out.println("Modern coffee table");
    }

    @Override
    public void createSofa() {
        System.out.println("Modern kanepe");
    }
}
