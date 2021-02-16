package lab104.stepancj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author Calvin Stepan
 */
public class Recursion {

    Scanner scan = new Scanner(System.in);
    File inputFile;

    /**
     * 
     * @param n any whole number greater than 0
     * @return the sum of the harmonic numbers through n
     */
    public static double Harmonic(double n) {
        if (n < 0) {
            System.err.print("Value for n is invalid, would you like to try again?");
        } else if (n == 1) {
            return 1.0;
        } else {
            return ((1.0 / n) + (Harmonic(n - 1.0)));
        }
        return 0;//for the compiler, should never actually be reached
    }

    /**
     * 
     * @return 
     */
    public static int Isabel(int n) {
        
        for(int i = 0; i < (n/2) - 1; i++) {
            
        }
        return 1;
    }

    public void find(String startPath, String filename) throws FileNotFoundException {

    }

}
