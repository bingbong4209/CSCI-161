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
        
        int maxN = 1000000000;
        int capacity = 6;
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
        /*
        long startTime = 0;
        long stopTime = 0;
        long totalTime = 0;

        /*
        while (n < 100) {
            for (int i = 0; i < capacity; i++) {
                for (int j = 0; j < capacity; j++) {
                    startTime = System.nanoTime();
                    for (int k = 0; k < n; k++) {
                        arrayStack.push(10);
                        arrayStack.pop();
                    }
                    stopTime = System.nanoTime();
                    totalTime = stopTime - startTime;

                    n = (n * 10);
                    AsciiTable.addTime(j, i, totalTime, times);
                }
            }

        }
         */
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
        ArrayList<Integer> list = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.add(i, rand.nextInt());
            System.out.println("made it");
        }
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
            System.out.println("made it");
        }
        long stop = System.nanoTime();
        long total = stop - start;

        return total;
    }

}
