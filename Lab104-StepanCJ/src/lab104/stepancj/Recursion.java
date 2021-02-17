package lab104.stepancj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Calvin Stepan
 */
public class Recursion {

    public static void harmonicSetup(double n) {
        if (n < 0) {
            System.err.print("Value for n is invalid, would you like to try again?");
        }
    }

    public static double harmonicComputation(double n) {
        if (n == 1) {
            return 1.0;
        } else {
            return ((1.0 / n) + (harmonicComputation(n - 1.0)));
        }
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        while (n != 1) {
            if (n % 2 != 0) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }

    public static int[] isabelsTechniqueSetup(String filePath) {
        Scanner scan = null;
        ArrayBag<Integer> Bag = new ArrayBag<>();
        int[] A = new int[2];

        try {
            scan = new Scanner(new File(filePath));
        } catch (FileNotFoundException fnfe) {
            System.err.println("Invalid file path");
        }
        while (scan.hasNext()) {
            String token = scan.next();

            try {
                int inInt = Integer.parseInt(token);
                Bag.add(inInt);
            } catch (NumberFormatException nfe) {
            }
        }

        //Power of 2 check
        if (isPowerOfTwo(Bag.count)) {
            A = new int[Bag.count];

            for (int i = 0; i < Bag.count; i++) {
                A[i] = Bag.get(i);
            }
        } else {
            System.err.println("The number of elements in the text file is not a power of two");
        }

        return A;
    }

    public static int isabelsTechnique(int[] A) throws IllegalArgumentException {
        /**
         * 1) open the ASCII text file 2) scan the contents of the document and
         * put the values into an array A 3) create an array B that is half the
         * size of A ASCII File is just a text file
         *
         */
        // base case
        if (A.length == 1) {
            return A[0];
        }

        // general case
        int[] arrayB = new int[A.length / 2];
        {
            for (int i = 0; i < arrayB.length; i++) {
                arrayB[i] = A[2 * i] + A[2 * i + 1];
            }

            return isabelsTechnique(arrayB);
        }

        /*
        int[] B = new int[A.length / 2];
        for (int i = 0; i < ((A.length / 2) - 1); i++) {
            B[i] = A[2 * i] + A[(2 * i) + 1];

        }
        if (B.length == 1) {
            return B[0];
        } else {
            return isabelsTechnique(B);
        }
         */
    }
    
    public static void find(String startPath, String filename) {
        File path = new File(startPath);
        if(path != null && path.isFile()) {
            
        }
    }

}
