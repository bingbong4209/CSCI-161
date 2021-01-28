package lab102.stepancj;

import java.util.Random;

/*
 * @author Calvin Stepan
 */
public class Scores {

    int[] list;
    int count;
    Random rand = new Random();

    public Scores() {
        list = new int[50];
    }

    public Scores(int length) {
        list = new int[length];
    }

    public void add(int num) {
        if (list[list.length - 1] == 0) {
            list[list.length - 1] = num;
        } else {
            int[] temp = new int[list.length + 1];
            for(int i: list) {
                list[i] = temp[i];
            }
            temp[temp.length] = num;
        }
    }

    public boolean isEmpty() throws NullPointerException {
        for (int i : list) {
            if (!(list[i] == 0)) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        for (int i : list) {
            list[i] = 0;
        }
    }

    public int size() {
        return count;
    }

    public int getFrequencyOf(int num) {
        int numCount = 0;
        for (int i : list) {
            if (list[i] == num) {
                numCount++;
            }
        }
        return numCount;
    }

    public boolean contains(int num) {
        for (int i : list) {
            if (list[i] == num) {
                return true;
            }
        }
        return false;
    }

    public void remove(int num) {
        for (int i : list) {
            if (list[i] == num) {
                list[i] = 0;
                break;
            }
        }
    }

    public void remove() {
        if (isEmpty()) {
        } else {
            for (int i : list) {
                if (i == rand.nextInt(count)) {
                    list[i] = 0;
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
        for (int i : list) {
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
