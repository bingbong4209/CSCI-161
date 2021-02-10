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
        list = new SinglyLinkedList<>();
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
            if (this.get(i) == e) {
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
            if (this.get(i) == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * removes the first instance of the given number in the array
     *
     * @param e
     */
    public E remove(E e) {
        SinglyLinkedList<E> temp = new SinglyLinkedList<>();
        E removedElement = null;
        E tempElement;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            tempElement = list.removeFirst();
            if (tempElement.equals(e)) {
                removedElement = tempElement;
            } else {
                temp.addLast(tempElement);
            }
        }
        list = temp;
        return removedElement;
    }

    /**
     * removes the number at the pseudo-randomly generated index
     */
    public E remove() {
        SinglyLinkedList<E> temp = new SinglyLinkedList<>();
        E removedElement = null;
        E tempElement;
        int randomIndex = rand.nextInt(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            tempElement = list.removeFirst();
            if (i ==  randomIndex) {
                removedElement = tempElement;
            } else {
                temp.addLast(tempElement);
            }
        }
        list = temp;
        return removedElement;
    }

    /**
     *
     * @param i the index of the number to get from the array
     * @return the number at the index of i
     */
    public E get(int index) throws ArrayIndexOutOfBoundsException {
        E temp = null;
        if (index < 0 || index > list.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int j = 0; j < list.size(); j++) {
            temp = list.removeFirst();
            if (j == index) {
                return list.first();
            } else {
                list.addLast(temp);
            }

        }
        return temp;
    }

    /**
     * @return the name, length of the array, number of elements currently in
     * the array, and the whole array
     */
    public String toString() {
        String temp = getClass().getName() + "@" + list.size() + "\n";
        E element;
        for (int i = 0; i < list.size(); i++) {
            element = list.removeFirst();
            temp += " " + element.toString() + "\n";
            list.addLast(element);
        }
        return temp;
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
