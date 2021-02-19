package lab104.stepancj;

import java.util.Random;

/**
 * Scores Class in its entirety from Lab102-StepanCJ transcribed by
 *
 * @author Calvin Stepan
 * Reused from Lab103-StepanCJ
 * @param <E> Generic Type
 * @version 1.9.2021
 */
public class ArrayBag<E> implements Bag<E> {

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
     * @param e any generic object adds an element e to the array at the next
     * available slot.If no slots are open, then it resizes the array to be
     * twice as large.
     *
     */
    public void add(E e) {

        if (count == list.length) {
            E[] temp = (E[]) new Object[list.length * 2];
            for (int i = 0; i < list.length; i++) {
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
        for (int i = 0; i < count; i++) {
            if (!(list[i] == null)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Clears out the list by putting zeros into each slot in the array
     */
    public void clear() {
        for (int i = 0; i < count; i++) {
            list[i] = null;
            count = 0;
        }
    }

    /*
     * @return the size of the array
     */
    public int size() {
        return count;
    }

    /**
     * @param e a generic type object
     * @return the frequency of the generic e
     */
    public int getFrequencyOf(E e) {
        int numCount = 0;
        for (int i = 0; i < count; i++) {
            if (list[i].equals(e)) {
                numCount++;
            }
        }
        return numCount;
    }

    /**
     * @param e a generic type object
     * @return whether or not the array contains the given number
     */
    public boolean contains(E e) {
        for (int i = 0; i < count; i++) {
            if (list[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param e a generic type object
     * removes the first instance of the given number in the array
     */
    public E remove(E e) {
        int i;
        
        for (i = 0; i < count; i++) {
            if (list[i] == e) {
                break;
            }
        }
        if(i == count) {
            return null;
        } 
        for(int j = i; j < count - 1; j++) {
            list[j] = list[j + 1];
        }
        count--;
        return e;
    }

    /**
     * removes the number at the pseudo-randomly generated index
     */
    public E remove() {
        E temp = null;
        int index = rand.nextInt(count);
        if (isEmpty()) {
        } else {
            temp = this.remove(list[index]);
        }
        return temp;
    }

    /**
     *
     * @param i the index of the number to get from the array
     * @return the number at the given index
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
        String temp = getClass().getName() + "@" + list.length + ":" + count + "\n";
        for (int i = 0; i < count; i++) {
            System.out.print(i);
            temp += list[i].toString() + "\n";
        }
        return temp;
    }

    /**
     *
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

        return count == e.count;

    }
}
