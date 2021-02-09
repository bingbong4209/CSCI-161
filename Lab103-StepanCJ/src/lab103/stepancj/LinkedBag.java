package lab103.stepancj;

import java.util.Random;

/**
 *
 * @author Calvin Stepan
 * @version 1.9.2021
 * @param <E> Generic Type
 */
public class LinkedBag<E> implements Bag<E> {

    SinglyLinkedList<E> list;
    Random rand = new Random();

    public LinkedBag() {
        list = new SinglyLinkedList();
    }

    public LinkedBag(int size) {
        this();
    }

    /**
     *
     * @param e any generic object
     */
    public void add(E e) {
        list.addLast(e);
    }

    /**
     *
     * @return whether or not the array is empty
     * @throws NullPointerException
     */
    public boolean isEmpty() throws NullPointerException {
        return list.isEmpty();
    }

    /**
     * Clears out the list by removing all objects from the list
     */
    public void clear() {
        for (int i = 0; i < list.size(); i++) {
            list.removeFirst();
        }
    }

    /*
     * @return the size of the array
     */
    public int size() {
        return list.size();
    }

    /**
     * @param e
     * @return the frequency of generic object e
     */
    public int getFrequencyOf(E e) {
        int numCount = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.getElement(i) == e) {
                numCount++;
            }
        }
        return numCount;
    }

    /**
     * @param e any generic object e
     * @return whether or not the array contains the given number
     */
    public boolean contains(E e) {
        for (int i = 0; i < list.size(); i++) {
            if (list.getElement(i) == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * removes the first instance of the given number in the array
     * @param e
     */
    public E remove(E e) {
       list.removeFirst();
    }

    /**
     * removes the number at the pseudo-randomly generated index
     */
    public E remove() {
        int index = 0;
        if (isEmpty()) {
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (i == rand.nextInt(list.size())) {
                    list.getElement(i) = null;
                    i = index;
                    break;
                }
            }
        }
        return list.getElement(index);
    }

    /**
     *
     * @param i the index of the number to get from the array
     * @return the number at the index of i
     */
    public E get(int i) throws ArrayIndexOutOfBoundsException{
        E index = list.getElement(i);
        return index;
    }

    /**
     * @return the name, length of the array, number of elements currently in
     * the array, and the whole array
     */
    public String toString() {
        String temp = "";
        for (int i = 0; i < list.size(); i++) {
            temp += list.getElement(i) + " ";
        }
        temp += "\n";
        return getClass().getName() + "@" + list.size() + ":" + temp;
    }

    /**
     * @param o takes in any Object, will only return true if the object is an
     * instance of the ArrayBag class
     * @return a Boolean indicating whether or not the object is an instance of
     * the ArrayBag class
     */
    public boolean equals(Object o) {
        if (!(o instanceof ArrayBag)) {
            return false;
        }
        ArrayBag e = (ArrayBag) o;

        return list.size() == e.count;

    }
}
