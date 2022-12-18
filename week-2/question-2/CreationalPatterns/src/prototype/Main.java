package prototype;


public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee zeynep = new Employee("Zeynep","UYGUN");
        Employee zeynepClone =zeynep.clone();


        System.out.println(zeynep==zeynepClone);
    }
}
