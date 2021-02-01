package lab102.stepancj;

import java.util.Random;

/*
 *   
 * @author Calvin Stepan
 */
public class Scores {

    int[] list;
    int count = 0;
    Random rand = new Random();

    public Scores() {
        list = new int[50];
    }

    public Scores(int length) {
        list = new int[length];
    }

    public void add(int num) {

        if (count == list.length - 1) {
            int[] temp = new int[list.length + 1];
            for (int i = 0; i < list.length - 1; i++) {
                list[i] = temp[i];
            }
            temp[temp.length] = num;
            count++;
        } else if (list[count] == 0) {
            list[count] = num;
            count++;
        }
    }

    public boolean isEmpty() throws NullPointerException {
        for (int i = 0; i < list.length - 1; i++) {
            if (!(list[i] == 0)) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < list.length - 1; i++) {
            list[i] = 0;
        }
    }

    public int size() {
        return count;
    }

    public int getFrequencyOf(int num) {
        int numCount = 0;
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == num) {
                numCount++;
            }
        }
        return numCount;
    }

    public boolean contains(int num) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == num) {
                return true;
            }
        }
        return false;
    }

    public void remove(int num) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == num) {
                list[i] = 0;
                count--;
                break;
            }
        }
    }

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

    public int get(int i) {
        int index = 0;
        list[i] = index;
        return index;
    }

    public String toString() {
        for (int i = 0; i < list.length - 1; i++) {
            System.out.println(list[i]);
        }
        return getClass().getName() + "@" + list.length + ":" + count;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Scores)) {
            return false;
        }
        Scores e = (Scores) o;

        return count == e.count;

    }
}
