package lab109.stepancj;

/**
 *
 * @author Calvin Stepan
 */
public class HashCode {

    public static int polynomialHashCode(String key, int a) {
        int value = 0;
        for (int i = 0; i < key.length(); i++) {

            value += (int) key.charAt(i) * (i + a);
        }
        return value;
    }

    public static int madCompression(int hashCode, int N, int p, int a, int b) {
        int value = 0;

        return value;
    }

    public static boolean isOddNumber(int number) {
        return number % 2 != 0;
    }

}
