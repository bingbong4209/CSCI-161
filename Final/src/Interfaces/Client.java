package Interfaces;

import java.util.Random;

/**
 *
 * @author Calvin Stepan
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        System.out.println(hashCode("POTS"));
    }
    static int hashCode(String s) {
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            h = (h << 2) | (h >>> 30);
            h += (int) s.charAt(i);
        }
        return h;
    }
     */
    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        System.out.println(runTimeTest(test, 250000));
    }

    public static <K> long runTimeTest(K container, int N) {
        Random rand = new Random();
        long runtime = 0;
        
        if (container instanceof ArrayStack) {
            ArrayStack<Integer> buckets = new ArrayStack<>();
            long start = System.nanoTime();
            for (int i = 0; i < N; i++) {
                buckets.push(rand.nextInt());
            }
            for (int i = 0; i < N; i++) {
                buckets.pop();
            }
            long stop = System.nanoTime();
            runtime = stop - start;
        } else if (container instanceof LinkedStack) {
            LinkedStack<Integer> stack = new LinkedStack<>();
            long start = System.nanoTime();
            for (int i = 0; i < N; i++) {
                stack.push(rand.nextInt());
            }
            long stop = System.nanoTime();
            runtime = stop - start;
        } else if (container instanceof ArrayQueue) {
            ArrayQueue<Integer> queue = new ArrayQueue<>(N);
            long start = System.nanoTime();

            for (int i = 0; i < N; i++) {
                queue.enqueue(rand.nextInt());
            }
            for (int i = 0; i < N; i++) {
                queue.dequeue();
            }
            long stop = System.nanoTime();
            runtime = stop - start;
            //----------------------
        } else if (container instanceof LinkedQueue) {
            LinkedQueue<Integer> queue = new LinkedQueue<>();
            long start = System.nanoTime();
            for (int i = 0; i < N; i++) {
                queue.enqueue(rand.nextInt());
            }
            for (int i = 0; i < N; i++) {
                queue.dequeue();
            }
            long stop = System.nanoTime();
            long total = stop - start;
        } else if (container instanceof ArrayList) {
            ArrayList<Integer> list = new ArrayList<>(N);
            long start = System.nanoTime();
            for (int i = 0; i < N; i++) {
                list.add(i, rand.nextInt());
            }
            for (int i = 0; i < N; i++) {
                list.remove(N - i - 1);
            }
            long stop = System.nanoTime();
            runtime = stop - start;
        }

        return runtime;
    }
    
    
    
}
