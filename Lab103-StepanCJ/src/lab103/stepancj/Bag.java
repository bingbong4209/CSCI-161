package lab103.stepancj;

/**
 *
 * @author Calvin Stepan
 * @param <E> Generic Object
 * @version 1.9.2021
 */
public interface Bag<E> {

    /**
     * @return the size of the Bag
     */
    int size();

    /**
     * @return whether or not the Bag is empty
     */
    boolean isEmpty();

    /**
     * clears the Bag of all values and objects
     */
    void clear();

    /**
     * @param e a generic type
     * @return the frequency that e comes up in the bag
     */
    int getFrequencyOf(E e);

    /**
     * @param e a generic type
     * @return a Boolean telling the user whether or not the Bag contains e
     */
    boolean contains(E e);

    /**
     * @param e a generic type of object to be added to the Bag
     */
    void add(E e);

    /**
     * @param e the generic type object to remove from the bag
     * @return the type E
     */
    E remove(E e);

    /**
     * @return the type E
     */
    E remove();

    /**
     * @param i an integer representing the index of the bag to get
     * @return the data stored at bag index i
     */
    E get(int i);

    /**
     * @return the objects in the bag
     */
    String toString();

    /**
     * @return whether or not two objects are of the same type
     */
    boolean equals(Object o);
}
