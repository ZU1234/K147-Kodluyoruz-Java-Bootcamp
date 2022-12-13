import java.util.ArrayList;

public class Customer {

    private final int id;
    private final String name;
    private final String surName;
    private final int age;
    //Müşteri sınıfı
    public Customer(int id, String name,String surName, int age) {
        this.id = id;
        this.name = name;
        this.surName=surName;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getSurName() {
        return surName;
    }


}
