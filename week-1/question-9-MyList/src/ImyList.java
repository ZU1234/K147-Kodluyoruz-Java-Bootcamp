public interface ImyList<E> {
    //İmplement edildiğinde @Override edilecek methodları içerir.
    int size();

    boolean isEmpty();

    void add(E value);

    void add(int index, E value);

    E get(int index);

    Object[] toArray();

    void print();

    void clear();


}
