package lab104.stepancj;

import java.util.Random;

/*
 *   
 * @author Calvin Stepan
 */
public class Scores {

    int[] list;
    int count = 0;
    Random rand = new Random();

    /**
     * This is the default constructor for the Scores class.
     */
    public Scores() {
        list = new int[50];
    }

    /**
     *
     * @param length to represent the length of the array
     */
    public Scores(int length) {
        list = new int[length];
    }

    /**
     * adds a number "num" to the array at the next available slot. 
     * If no slots are open, then it resizes the array to be twice as large.
     * @param num any real whole number
     */
    public void add(int num) {

        if (count == list.length) {
            int[] temp = new int[list.length * 2];
            for (int i = 0; i < list.length - 1; i++) {
                temp[i] = list[i];
            }
            list = temp;
        }
        list[count++] = num;
    }

    /**
     *
     * @return whether or not the array is empty
     * @throws NullPointerException
     */
    public boolean isEmpty() throws NullPointerException {
        for (int i = 0; i < list.length - 1; i++) {
            if (!(list[i] == 0)) {
                return false;
            }
        }
        return true;
    }

    /**
     *Clears out the list by putting zeros into each slot in the array
     */
    public void clear() {
        for (int i = 0; i < list.length - 1; i++) {
            list[i] = 0;
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
    public int getFrequencyOf(int num) {
        int numCount = 0;
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == num) {
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
    public boolean contains(int num) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * removes the first instance of the given number in the array
     * @param num any whole number to be removed from the array
     */
    public void remove(int num) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == num) {
                list[i] = 0;
                count--;
                break;
            }
        }
    }

    /**
     * removes the number at the pseudorandomly generated index
     */
    public void remove() {
        if (isEmpty()) {
        } else {
            for (int i = 0; i < list.length - 1; i++) {
                if (i == rand.nextInt(count)) {
                    list[i] = 0;
                    count--;
                    break;
                }
            }
        }
    }

    /**
     *
     * @param i the index of the number to get from the array
     * @return the number at the ith index
     */
    public int get(int i) {
        int index = 0;
        index = list[i];
        return index;
    }

    /**
     * @return the name, length of the array, number of elements currently in the array, and the whole array
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
     * @param o takes in any Object, will only return true if the object is an instance of the Scores class
     * @return a boolean indicating whether or not the object is an instance of the Scores class
     */
    public boolean equals(Object o) {
        if (!(o instanceof Scores)) {
            return false;
        }
        Scores e = (Scores) o;

        return count == e.count;

    }
}
