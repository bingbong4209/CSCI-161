package lab104.stepancj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Calvin Stepan
 */
public class Recursion {
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
        return 0;// for the compiler, should never actually be reached
    }

    /**
     * 
     * @param file
     * @return
     */
    public static int Isabel(File file) {
        /**
         * 1) open the ASCII text file
         * 2) scan the contents of the document and put the values into an array A
         * 3) create an array B that is half the size of A
         * ASCII File is just a text file
         * 
         */
        Scores A = new Scores();
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch(FileNotFoundException fnfe) {
            System.err.print("Invalid File");
        }
        while(scan.hasNextInt()) {
            A.add(scan.nextInt());
        }

//        Scores B = new Scores(A / 2);
//        if (B.size() == 1) {
//            return B.get(0);
//        } else {
//            return B.get(B.size()) + Isabel(B.size() - 1);
//        }
return 0;
  }

    public void find(String startPath, String filename) throws FileNotFoundException {
        throw new FileNotFoundException("Invalid file path");
    }

}