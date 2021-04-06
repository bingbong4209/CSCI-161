package lab109.stepancj;

/**
 *
 * @author Calvin Stepan
 */
public class HashCode {

    public static int polynomialHashCode(String key, int a) {
        int h = 0;
        for (int i = 0; i < key.length(); i++) {
            if(isOddNumber(i))
                h += (int) key.charAt(i) * a;
            else
                h += (int) key.charAt(i);
        }
        return h;
    }
    
    public static int madCompression(int hashCode, int N, int p, int a, int b) {
        int h = 0;
        
        
        
        return h;
    }
    
    public static boolean isOddNumber(int number) {
        return number % 2 != 0; 
    }
    
}
