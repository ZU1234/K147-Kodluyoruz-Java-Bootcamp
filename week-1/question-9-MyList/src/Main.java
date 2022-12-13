public class Main {
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        //test3();
        //test4();
        //test5();
        test6();

    }
    /*C harfi ile başlayan 4 adet verinin
     *print(), add(String value), add(int index,String value), size() ve print() methodlarının testi.
     */

    static void test0() {
        System.out.println("--------------------TEST-0--------------------");

        MyList<String> myList = new MyList<>();

        myList.add("Cem");//1
        myList.add("Ceyda");//2
        myList.add("Canan");//3
        myList.add("Canada");//4


        myList.print();
        System.out.println("Size : " + myList.size());

        myList.add(0, "Cevap");
        myList.add(1, "Cevap1");
        System.out.println();
        myList.print();
        System.out.println("Size : " + myList.size());



    }

    /*C harfi ile başlayan 4 adet verinin
     *print(), add(String value), add(int index,String value), size() ve print() methodlarının testi.
     *Capacite artışı testi1.
     * */
    static void test1() {
        System.out.println("--------------------TEST-1--------------------");
        MyList<String> myList = new MyList<>();

        myList.add("Cem");//1
        myList.add("Ceyda");//2
        myList.add("Canan");//3
        myList.add("Canada");//4
        myList.add("Candan");//5
        myList.add("Cuma");//6
        myList.add("Canli");//7
        myList.add("Cadde");//8

        myList.print();
        System.out.println("Size : " + myList.size());

        myList.add(0, "Cevap");
        myList.add(1, "Cevap1");

        System.out.println();
        myList.print();
        System.out.println("Size : " + myList.size());


    }

    /*C harfi ile başlayan 4 adet verinin
     *print(), add(String value), add(int index,String value), size() ve print() methodlarının testi.
     *Capacite artışı testi2.
     * clear() methodu testi.
     * */
    static void test2() {
        System.out.println("--------------------TEST-2--------------------");
        MyList<String> myList = new MyList<>();

        myList.add("Cem");//1
        myList.add("Ceyda");//2
        myList.add("Canan");//3
        myList.add("Canada");//4
        myList.add("Candan");//5
        myList.add("Cuma");//6
        myList.add("Canli");//7
        myList.add("Cadde");//8


        myList.add("Cevap");
        myList.add("Cevap1");
        myList.add("Cevap2");
        myList.add("Cevap3");
        myList.add("Cevap4");
        myList.add("Cevap5");
        myList.add("Cevap6");


        System.out.println();
        myList.print();
        System.out.println("Size : " + myList.size()+"\n");
        System.out.println("-------clear()");
        myList.clear();
        System.out.println("Size : " + myList.size());


    }

    /*
     * C harfi ile başlamayan verinin exception testi
     * */
    static void test3() {
        System.out.println("--------------------TEST-3--------------------");
        MyList<String> myList = new MyList<>();
        myList.add("JAVA");//1

        System.out.println("\n***********************************");
    }

    /*
     * Büyük harf küçük harf duyarlılık exception testi
     * */
    static void test4() {
        System.out.println("--------------------TEST-4--------------------");
        MyList<String> myList = new MyList<>();
        myList.add("cevap");//1

        System.out.println("\n***********************************");
    }

    /*
     * String dışında liste oluşturma ve veri girişi exception testi
     * */
    static void test5() {
        System.out.println("--------------------TEST-5--------------------");
        MyList<Integer> myList = new MyList<>();
        myList.add(5);//1


    }
    //get(int index) methodu test.
    static void test6() {
        System.out.println("--------------------TEST-6--------------------");
        MyList<String> myList = new MyList<>();
        myList.add("Candan");//1
        System.out.println(myList.get(0));

      ;
    }
}