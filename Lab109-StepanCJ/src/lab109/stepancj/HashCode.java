package lab109.stepancj;

import java.util.Random;

/**
 * The HashCode class houses all the methods that compute the final hash code values
 * The flow begins with the polynomialHashCode function, followed by the pValueCompute function
 * Finally, we compress the hash keys in the madCompression method
 * @author Calvin Stepan
 */
public class HashCode {

    /**
     * given a String key and a corresponding a-value, generate a hash code based on the underlying unicode character values
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
     * given the size of the array (underlying bucket), compute the corresponding p-value
     * @param N the size of the bucket array
     * @return
     */
    public static int pValueCompute(int N) {
        int p = N;
        //find the next prime number, then the p values are +/- 5 off of that
        OUTER:
        while (p < N * 10) {
            p++;
            for (int i = 2; i < p; i++) {
                if (p % i == 0) {
                    break;
                } else if(i + 1 == p) {
                    break OUTER;
                }
            }
        }
        return p;
    }

    /**
     * given a hash code, we can compress the hash key with all our given parameters
     * @param hashCode the hash code for the object to be compressed
     * @param N the size of the bucket array
     * @param p a prime number larger than N
     * @param a an integer chosen at random from the interval [0,p-1] with a > 0
     * @param b an integer chosen at random from the interval [0,p-1]
     * @return the compressed hash key
     */
    public static int madCompression(int hashCode, int N, int p, int a, int b) {
        
        a = find_A_Or_B(p, "a");
        b = find_A_Or_B(p, "b");
        //System.out.println("A value: " + a);
        //System.out.println("B Value: " + b);
        if (!(a > 0 && a <= (p - 1))) {
            System.out.println("p value: " + p);
            throw new IllegalArgumentException("invalid 'a' parameter: " + a);
        } else if (!(b <= (p - 1) && b >= 0)) {
            System.out.println("p value: " + p);
            throw new IllegalArgumentException("invalid 'b' parameter: " + b);
        } else {
            return (((a * hashCode) + b) % p) % N;
        }
    }
    
    //Note: this was not used in my final solution; however, this would be the way to randomly compute 'a' and 'b' values
    /**
     * given a p-value and a String indicating if it is an 'a' or 'b' value, we compute a randomly generated 'a' or 'b' value
     * @param p the p-value input
     * @param ab the String indicating whether we need to compute an 'a' or 'b' value
     * @return the randomly generated 'a' or 'b' value
     */
    public static int find_A_Or_B(int p, String ab) {
        Random rand = new Random();
        int new_A_B = 0;
        if(ab.equals("a"))
            new_A_B = rand.nextInt(p - 1) + 1;
        else 
            new_A_B = rand.nextInt(p - 1);
        //System.out.println("new A / B value: " + new_A_B);
        return new_A_B;
    }
}
