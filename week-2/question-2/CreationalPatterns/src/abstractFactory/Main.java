package abstractFactory;

import abstractFactory.factorys.ModernFurnitureFactory;
import abstractFactory.factorys.VictorianFurnitureFactory;

public class Main {
    public static void main(String[] args) {
        ModernFurnitureFactory modern =new ModernFurnitureFactory();
        modern.createChair();

        VictorianFurnitureFactory victoria =new VictorianFurnitureFactory();
        victoria.createChair();
    }
}
