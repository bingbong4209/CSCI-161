package lab109.stepancj;

/**
 *
 * @author Calvin Stepan
 */
public class PolynomialHashCode {

    public static int hashCode(String s) {
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            h = (h << 5) | (h >>> 27); // 5-bit cyclic shift of the running sum
            h += (int) s.charAt(i); // add in next character
        }
        return h;
    }
    
    public static int madCompression(int hashCode, int N, int p, int a, int b) {
        int h = 0;
        
        
        
        return h;
    }
}
