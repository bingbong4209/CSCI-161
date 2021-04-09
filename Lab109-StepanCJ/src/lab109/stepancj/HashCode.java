package lab109.stepancj;

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
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) {

            hashCode += (int) key.charAt(i) * Math.pow(a, key.length() - (i + 1));
        }
        return hashCode;
    }
    
    /**
     * 
     * @param N the size of the bucket array
     * @return 
     */
    public static int pValueCompute(int N) {
        int p = 0;
        
        //find the next prime number, then the p values are +/- 5 off of that
        
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

        if (!(a > 0 && a <= (p - 1))) {
            throw new IllegalArgumentException("invalid 'a' parameter");
        } else if (!(b <= (p - 1) && b >= 0)) {
            throw new IllegalArgumentException("invalid 'b' parameter");
        } else {
            return (((a * hashCode) + b) % p) % N;
        }
    }
}
