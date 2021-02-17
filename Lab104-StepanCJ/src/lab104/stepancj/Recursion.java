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
    public static int Isabel(int n) {
        /**
         * 1) open the ASCII text file 2) scan the contents of the document and put the
         * values into an array A 3) create an array B that is half the size of A ASCII
         * File is just a text file
         * 
         */
        /*
        Scores A = new Scores(n);
        Scanner scan = null;
        try {
            scan = new Scanner(new File("Lab104-StepanCJ\\src\\lab104\\asciFileTest.txt"));
        } catch (FileNotFoundException fnfe) {
            System.err.println("Invalid file path");
        }
        while (scan.hasNextInt()) {
            A.add(scan.nextInt());
        }

        Scores B = new Scores(A.count / 2);
        for(int i = 0; i < ((n/2) - 1); i++) {
            int asdf = A.get(2 * i) + A.get((2 * i) + 1);
            asdf = B;
        }
        if (B.size() == 1) {
            return B.get(0);
        } else {
            return B.get(B.count + Isabel(B.count - 1));
        }
*/
        Scores A = new Scores(Math.abs(n));//why does this return a negative value?
        Scanner scan = null;
        try {
            scan = new Scanner(new File("Lab104-StepanCJ\\src\\lab104\\asciFileTest.txt"));
        } catch (FileNotFoundException fnfe) {
            System.err.println("Invalid file path");
        }
        while (scan.hasNextInt()) {
            A.add(scan.nextInt());
        }

        Scores B = new Scores(A.count / 2);
        for(int i = 1; i < ((n/2) - 1); i++) {
            B.add(A.get(2 * i) + A.get((2 * i) + 1));  
        }
        if (B.size() == 1) {
            return B.get(0);
        } else {
            return B.get(B.count + Isabel(B.size() - 1));
        }
    }

    public void find(String startPath, String filename) throws FileNotFoundException {
        throw new FileNotFoundException("Invalid file path");
    }

}