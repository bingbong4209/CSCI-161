package lab109.stepancj;

import java.util.Random;

/**
 *
 * @author Calvin Stepan
 */
public class HashCode {

    /**
     *
     * @param key the String key that is being hashed
     * @param a the variable changed
     * @return
     */
    public static int polynomialHashCode(String key, int a) {
        long longHashCode = 0;
        for (int i = 0; i < key.length(); i++) {
            long intValue = (int) key.charAt(i);
            longHashCode += (long) (intValue * Math.pow(a, i));
        }
        longHashCode = (int) longHashCode;
        return (int) Math.abs(longHashCode);
    }

    /**
     *
     * @param N the size of the bucket array
     * @return
     */
    public static int pValueCompute(int N) {
        int p = N;
        //find the next prime number, then the p values are +/- 5 off of that
        OUTER:
        while (p < N * 10) {
            p++;
            System.out.println("p-value:" + p);
            for (int i = 2; i < p; i++) {
                if (p % i == 0) {
                    System.out.println("dud at " + i);
                    break;
                } else if(i + 1 == p) {
                    System.out.println("This is a good one: " + p);
                    break OUTER;
                }
            }
        }
        System.out.println("p-values are " + (p - 5) + " and " + (p + 5));
        return p;
    }

    /**
     *
     * @param hashCode the hash code for the object to be compressed
     * @param N the size of the bucket array
     * @param p a prime number larger than N
     * @param a an integer chosen at random from the interval [0,p-1] with a > 0
     * @param b an integer chosen at random from the interval [0,p-1]
     * @return
     */
    public static int madCompression(int hashCode, int N, int p, int a, int b) {
        int upper_P = p + 5;
        int lower_P = p - 5;
        
        a = find_A_Or_B(p);
        b = find_A_Or_B(p);
        
        if (!(a > 0 && a <= (p - 1))) {
            throw new IllegalArgumentException("invalid 'a' parameter");
        } else if (!(b <= (p - 1) && b >= 0)) {
            throw new IllegalArgumentException("invalid 'b' parameter");
        } else {
            return (((a * hashCode) + b) % p) % N;
        }
    }
    
    public static int find_A_Or_B(int p) {
        Random rand = new Random();
        int new_A_B = rand.nextInt(p);
        System.out.println("new A / B value: " + new_A_B);
        return new_A_B;
    }

    public static void main(String[] args) {
        //System.out.println(pValueCompute(45402));
        //find_A_Or_B(45402);
    }
}
