package lab105.stepancj;

import java.util.Random;

/**
 *
 * @author Calvin Stepan
 * @version 2.23.2021
 */
public class Client {

    static Random rand = new Random();

    public static void main(String[] args) {
        
        int maxN = 100000000;
        int capacity = 8;
        long[][] times = new long[capacity][capacity];

        int row = 0;
        for (int i = 10; i < maxN && row < capacity; i *= 10) {
            times[row][0] = i;
            times[row][1] = testArrayStack(i);
            times[row][2] = testLinkedStack(i);
            times[row][3] = testArrayQueue(i);
            times[row][4] = testLinkedQueue(i);
            times[row][5] = testArrayList(i);
            row++;
        }
        AsciiTable.asciiOutput(times);
    }

    public static long testArrayStack(int n) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stack.push(rand.nextInt());
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        long stop = System.nanoTime();
        long total = stop - start;

        return total;
    }

    public static long testLinkedStack(int n) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stack.push(rand.nextInt());
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        long stop = System.nanoTime();
        long total = stop - start;

        return total;
    }

    public static long testArrayQueue(int n) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            queue.enqueue(rand.nextInt());
        }
        for (int i = 0; i < n; i++) {
            queue.dequeue();
        }
        long stop = System.nanoTime();
        long total = stop - start;

        return total;
    }

    public static long testLinkedQueue(int n) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            queue.enqueue(rand.nextInt());
        }
        for (int i = 0; i < n; i++) {
            queue.dequeue();
        }
        long stop = System.nanoTime();
        long total = stop - start;

        return total;
    }

    public static long testArrayList(int n) {
        ArrayList<Integer> list = new ArrayList<>(n);
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            list.add(i, rand.nextInt());
        }
        for (int i = 0; i < n; i++) {
            list.remove(n-i-1);
        }
        long stop = System.nanoTime();
        long total = stop - start;

        return total;
    }

}
