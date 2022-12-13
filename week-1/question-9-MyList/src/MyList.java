import java.util.*;

public class MyList<E> implements ImyList<E> {

    private static final int DEFAULT_CAPACITY = 5;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};


    private Object[] elementData;
    private int size;
    //Contructor
    public MyList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
    //Liste uzunluğunu verir.
    @Override
    public int size() {

        return size;

    }
    //Liste boş mu konrol eder boş işe true döndürür.
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    //String'in ilk karakteri büyük C mi diye kontrol eder. Değilse exception verir.
    private void isFirstTypeValueC(E value) {
        boolean firstChar = String.valueOf(value).startsWith("C");

        if (!firstChar)
            throw new IndexOutOfBoundsException("Yalnizca C harfi ile baslayan String degerler icin bu sinifi " +
                    "kullaniniz.");

    }

    //>> sağa kaydırma operatörü
    //preferred growth = tercih edilen büyüme
    //Listenin kapasitesi arttırılacak mı karar verilir arttırılacak ise 7 arttırır.
    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            int newCapacity = size + 7;
            System.out.println("Yeni kapasite : " + newCapacity);
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    private Object[] grow() {
        return grow(size + 7);
    }
    //Diziye eleman ekleme ve size=size+1 işlemi yapar.
    //Kapasite artışı olacakmı kontrol eder gerekli ise arttırır.
    private void add(E value, E[] elementData, int s) {
        if (s == elementData.length)
            elementData = (E[]) grow();
        elementData[s] = value;
        size = s + 1;
    }
    //Listeye eleman ekler
    @Override
    public void add(E value) {

        typeControlforAdd(value);
        isFirstTypeValueC(value);

        add((E) value, (E[]) elementData, size);

    }
    //Listenin belirtilen indexine eleman ekler
    @Override
    public void add(int index, E value) {

        typeControlforAdd(value);
        isFirstTypeValueC(value);
        rangeCheckForAdd(index);
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elementData).length)
            elementData = grow();
        System.arraycopy(elementData, index,
                elementData, index + 1,
                s - index);
        elementData[index] = value;
        size = s + 1;


    }
    //index değeri liste uzunluğuna eşit yada büyükse yada negatif ise hata fırlatır.
    private void rangeCheckForAdd(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    //Type kontrolü yapar String değil ise hata fırlatır.
    private void typeControlforAdd(E value) {
        if (!Objects.equals(value.getClass().toString(), "class java.lang.String")) {
            throw new IndexOutOfBoundsException("MyList sinifi yalnizca String listeleri icin tanimlidir.");
        }
    }
    //Belirtilen indexteki değeri getirir.
    @Override
    public E get(int index) {

        rangeCheckForAdd(index);


        return (E) elementData[index];
    }
    //dizi listesini dizi nesnesine dönüştürür.
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }
    //listeyi yazdırır.
    @Override
    public void print() {
        int count = 0;
        System.out.print("[");
        for (Object obj : elementData) {
            if (count == size - 1) {
                System.out.println(obj + "]");
                break;
            }
            System.out.print(obj + ",");
            count++;

        }

    }
    //Liste değerlerini siler dizi uzunluğu 0 olur.
    @Override
    public void clear() {
        final Object[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }
    //Exception(hata) mesajı olarak kullanılır. String dödürür.
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }


}



