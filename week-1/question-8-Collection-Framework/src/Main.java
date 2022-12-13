import java.util.*;

public class Main {
    public static void main(String[] args) {
//ListDeğerleri sıralı şekilde hafıza tutar. Ilk veri 0’ıncı indiste ikinci veri 1. İndiste vb.

//>>ArrayList>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        ArrayList<String> list = new ArrayList<>();//ArrayList objesi oluşturulur.
        list.add("deger1");//Listeye değer atanır.
        list.add("deger2");
        list.add("deger3");
        list.add("aaaa");
        list.add("bbbbb");
        list.add(0, "deger2");// Belirtilen index'e eleman ekler
        list.size();//Listenin uzunluğunu verir.
        list.get(0);//Belirtilen indisteki değeri döndürür.
        list.set(0, "değer0");//Belirtilen indisteki değeri değiştirir.
        list.isEmpty();//Liste boşmu kontrol eder. Boolean değer döndürür.
        list.get(0).equals("deger");//Listenin belirtilen indisindeki degeri karşılaştırır.
        list.equals("deger");//Listenin içinde varlığını karşılaştırır.
        list.remove(0);//Listenin sıfırıncı indisindeki değeri kaldırır.
        list.contains("value");//Belirtilen değer listede var mı kontrol eder. boolean deger döndürür.
        Collections.sort(list);//Listeyi sıralar.

        list.stream()
                .filter(a -> a.startsWith("d"))
                .toList();//d harfi ile başlayan tüm değerleri listeler.Ama yazdırmaz.

        list.stream()
                .filter(a -> a.startsWith("d"))
                .toList()
                .forEach(System.out::println); //d  harfi ile başlayan değerleri yazdırır.

        Arrays.asList("y", "c", "n")
                .stream()
                .forEach(System.out::println);//y,c,n eğerlerini yazdırır.

        list.clear();//Listenin içini boşaltır.


// >>LinkedList>>>>>>Listler gibi depolanmaz işaretçiler ilebirbirlerine bağlanırlar.
        LinkedList<String> filmler = new LinkedList<String>();//LinkedList objesi oluşturulur.
        filmler.add("Person of Interest");//listeye değer ekler.
        filmler.add("Black Books");
        filmler.addLast("Seinfeld");//Listenin son indisine eleman ekler.
        filmler.addFirst("Fargo");//Listenin ilk indisine eleman ekler.

        filmler.add(4, "Akasya Durağı");// Belirtilen index'e eleman ekler.
        filmler.forEach(film -> System.out.print(film + " "));//listeyi yazdırır.
        //Iterator ile tüm listeyi yazdırır.
        Iterator<String> iterator = filmler.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }



// >>Vector>>>>>>ArrayListler gibi davranırlar ama düşük performans gösterirler.
        Vector vec = new Vector<>();//vektör objesi oluşturulur.
        vec.addElement("Elma");//vektöre eleman ekler
        vec.addElement("Turuncu");
        vec.addElement("Mango");
        vec.addElement("Armut");


        vec.size();//vektör uzunluğunu verir.
        vec.clear();//vektörü temizler.



//SetBenzersiz verileri hafızata tutar ve sıralı değildir. Aslında setler kümelerdir.

// >>>>>>>>>>>>>>>>HashSet
        HashSet<String> setA = new HashSet<>();

        setA.add("elma");
        setA.add("elma");
        setA.add("armut");
        setA.add("armut");

        System.out.println(setA.contains("elma") );//küme içerisinde değer var mı diye kontrol eder boolean değer
        // döndürür.


        Set<String> setB = new HashSet<>();

        setB.add("element 1");
        setB.add("element 2");
        setB.add("element 2");
        setB.add("element 3");
        setB.add("element 3");
        setB.add("element 3");

        Iterator<String> itr = setB.iterator();

        while(itr.hasNext()){
            String element = itr.next();
            System.out.println(element);
        }
        //Iterator ile kümeyi yazdırdık.

        for(Object object : setB) {
            String element = (String) object;
            System.out.println(element);
        }
        //for-each ile kümeyi yazdırdık.

        setA.size();//Kümenin eleman sayısını verir.
        Iterator<String> itre = setA.iterator();
        while(itr.hasNext()) {
            while(itre.hasNext()) {
                if(setB.contains(itr)){//Eğer kümede itr objesinin işaret ettiği eleman varise true döndürür.
                    System.out.println(itr.next());
                }


            }
        }//Iterable ile kümede varlığını konroledip yazdırdık.

//>>QueueKuyruk anlamına gelir. İlk giren ilk çıkar mantığı vardır. Bu mantığa FIFO yapısı deriz.
        Queue<String> queue = new LinkedList<>();//Queue objesi oluşturulur.


        queue.add("element 1");//eleman eklenir.

        queue.offer("element 2");//Kuyrukta yer varsa ekleyebilir.

        Queue<String> tail = new LinkedList<>();

        tail.add("value1");
        tail.add("value2");

       String value1= tail.poll();// kuyruktaki ilk öğeyi kaldırır.

        String  value2 = tail.remove();// value 1 öğesi kalktığında kuyruktaki ilk öğe value2 olur ve kuyruktaki ilk
        // öğeyi
        // kaldırır.

        Queue<String> queue1 = new LinkedList<>();

        queue1.add("element 1");
        queue1.add("element 2");
        queue1.add("element 3");

        String firstElement = queue.element();//kuyruktaki ilk öğeyi getirir.
        queue.size();//Kuyruktaki öğe sayısını verir.

        Queue<String> queue3 = new LinkedList<>();

        queue3.add("ev");
        queue3.add("araba");
        queue3.add("mağaza");


        Iterator<String> iterator1 = queue3.iterator();
        while(iterator1.hasNext()){
            String element = iterator1.next();
            System.out.println(element);
        }//Kuyruktaki elemanları iterable ile yazdırır.


        for(String element : queue3) {
            System.out.println(element);
            System.out.println(element);
        }//Kuyruktaki elemanları yazdırır.

    }
}