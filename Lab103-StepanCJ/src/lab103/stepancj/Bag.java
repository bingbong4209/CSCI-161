package lab103.stepancj;

/**
 *
 * @author Calvin Stepan
 * @param <E> Generic Object
 */
public interface Bag <E> {
    int size();
    boolean isEmpty();
    void clear();
    int getFrequencyOf(E e);
    boolean contains(E e);
    void add(E e);
    E remove(E e);
    E remove();
    E get(int i);
    String toString();
    boolean equals(Object o);
}
