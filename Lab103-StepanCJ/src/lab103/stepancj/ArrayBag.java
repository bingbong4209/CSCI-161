package lab103.stepancj;

import java.util.Random;

/**
 * Scores Class in its entirety
 * from Lab102-StepanCJ
 * transcribed by 
 * @author Calvin Stepan
 * @param <E> Generic Type
 * @version 1.9.2021
 */
public class ArrayBag<E> implements Bag<E>{

    E[] list;
    int count = 0;
    Random rand = new Random();

    /**
     * This is the default constructor for the ArrayBag class.
     */
    public ArrayBag() {
        list = (E[]) new Object[50];
    }

    /**
     *
     * @param length to represent the length of the array
     */
    public ArrayBag(int length) {
        list = (E[]) new Object[length];
    }

    /**
     * adds a number "num" to the array at the next available slot. If no slots
     * are open, then it resizes the array to be twice as large.
     *
     * @param num any real whole number
     */
    public void add(E e) {

        if (count == list.length) {
            E[] temp = (E[]) new Object[list.length * 2];
            for (int i = 0; i < list.length - 1; i++) {
                temp[i] = list[i];
            }
            list = temp;
        }
        list[count++] = e;
    }

    /**
     *
     * @return whether or not the array is empty
     * @throws NullPointerException
     */
    public boolean isEmpty() throws NullPointerException {
        for (int i = 0; i < list.length - 1; i++) {
            if (!(list[i] == null)) {
                return false;
            }
        }
        return true;
    }
//-----------------------------------------FIX THE CLEAR METHOD
    /**
     * Clears out the list by putting zeros into each slot in the array
     */
    public void clear() {
        for (int i = 0; i < list.length - 1; i++) {
            list[i] = null;
        }
    }

    /*
     * @return the size of the array
     */
    public int size() {
        return count;
    }

    /**
     * @param num any whole number
     * @return the frequency of the number "num"
     */
    public int getFrequencyOf(E e) {
        int numCount = 0;
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == e) {
                numCount++;
            }
        }
        return numCount;
    }

    /**
     *
     * @param num any whole number
     * @return whether or not the array contains the given number
     */
    public boolean contains(E e) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * removes the first instance of the given number in the array
     *
     * @param num any whole number to be removed from the array
     */
    public E remove(E e) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == e) {
                list[i] = null;
                count--;
                break;
            }
        }
        return null;
    }

    /**
     * removes the number at the pseudorandomly generated index
     */
    public E remove() {
        int index = 0;
        if (isEmpty()) {
        } else {
            for (int i = 0; i < list.length - 1; i++) {
                if (i == rand.nextInt(count)) {
                    list[i] = null;
                    i = index;
                    count--;
                    break;
                }
            }
        }
        return list[index];
    }

    /**
     *
     * @param i the index of the number to get from the array
     * @return the number at the ith index
     */
    public E get(int i) {
        E index = list[i];
        return index;
    }

    /**
     * @return the name, length of the array, number of elements currently in
     * the array, and the whole array
     */
    public String toString() {
        String temp = "";
        for (int i = 0; i < list.length - 1; i++) {
            temp += list[i] + " ";
        }
        temp += "\n";
        return getClass().getName() + "@" + list.length + ":" + count + ":" + temp;
    }

    /**
     *
     * @param o takes in any Object, will only return true if the object is an
     * instance of the ArrayBag class
     * @return a boolean indicating whether or not the object is an instance of
     * the ArrayBag class
     */
    public boolean equals(Object o) {
        if (!(o instanceof ArrayBag)) {
            return false;
        }
        ArrayBag e = (ArrayBag) o;

        return count == e.count;

    }
}
