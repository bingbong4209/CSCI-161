package lab104.stepancj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * The Recursion class uses recursion to compute algorithms and complete file
 * searches within directories I got some help on various parts of this class
 * from Qianqian, the TA. Those parts are denoted by comments or noted within
 * the javadoc header for that method The basis for my find() method came from
 * Stack Overflow
 * (https://stackoverflow.com/questions/2534632/list-all-files-from-a-directory-recursively-with-java)
 *
 * Transcribed by
 *
 * @author Calvin Stepan
 * @version 2.17.21
 */
public class Recursion {

    /**
     * Setup for the harmonicComputation method Only needs to run once to verify
     * the input will work for the method, then passes the value to the
     * recursive method
     *
     * @param n a positive integer representing what harmonic number to compute
     */
    public static boolean harmonicSetup(int n) {
        System.out.println("N value: " + n);
        if (n < 0) {
            System.out.println("Invalid input, sad day");
            return false;
        } else {
            System.out.println("Valid input, nice");
            return true;
        }
    }

    /**
     * Recursive method to compute the nth harmonic number
     *
     * @param n a positive integer value
     * @return the double value of the nth harmonic number
     */
    public static double harmonicComputation(int n) {
        if (n == 1) {
            return 1;
        } else {
            double finalAnswer = ((1.0 / n) + (harmonicComputation(n - 1)));
            System.out.println("Total: " + finalAnswer);
            return finalAnswer;
        }
    }

    /**
     * This method came from Qianqian during her office hours Separate method to
     * determine if the size of the array is a power of 2
     *
     * @param n the size of the array;
     * @return true if the size is a power of 2, else false
     */
    public static boolean isPowerOfTwo(int n) {
        System.out.println("N value: " + n);
        if (n == 0) {
            System.out.println("This array is NOT power of two :(");
            return false;
        }

        while (n != 1) {
            if (n % 2 != 0) {
                System.out.println("This array is NOT power of two :(");
                return false;
            }
            n = n / 2;
        }
        System.out.println("This array is a power of two!");
        return true;
    }

    /**
     * This is the setup method for Isabel's Technique. It determines if the
     * file is valid and if it is a power of two. After checking for validity,
     * it parses the file and puts the contents into an int[] array to be
     * returned.
     *
     * @param filePath the String representing the path of the file to be
     * scanned
     * @return an int[] array with all the integers from the parsed file
     */
    public static int[] isabelsTechniqueSetup(String filePath) throws FileNotFoundException {
        System.out.println("File Path: " + filePath);
        ArrayBag<Integer> Bag = new ArrayBag<>();
        int[] A = new int[2];

        Scanner scan = new Scanner(new File(filePath));
        while (scan.hasNext()) {
            String token = scan.next();

            try {
                int inInt = Integer.parseInt(token);
                Bag.add(inInt);
                System.out.println("New int added: " + inInt);
            } catch (NumberFormatException nfe) {
                System.out.println("Number Formatting Error");
            }
        }

        //Power of 2 check
        if (isPowerOfTwo(Bag.count)) {
            A = new int[Bag.count];

            for (int i = 0; i < Bag.count; i++) {
                A[i] = Bag.get(i);
                System.out.println("Value of A[] where i = " + i + ": " + A[i]);
            }
        } else {
            System.out.println("Invalid input, sad day");
            throw new IllegalStateException("array length is not a power of 2");
        }
        return A;
    }

    /**
     * Uses Isabel's Technique to sum all the integers in an array
     *
     * @param A the int[] array from the setup method
     * @return the sum of all the integers in the array
     */
    public static int isabelsTechnique(int[] A) {

        // base case
        if (A.length == 1) {
            System.out.println(A[0]);
            return A[0];
        }

        // general case
        int[] B = new int[A.length / 2];
        {
            for (int i = 0; i < B.length; i++) {
                B[i] = A[2 * i] + A[2 * i + 1];
            }
            System.out.println("Total: " + isabelsTechnique(B));
            return isabelsTechnique(B);
        }
    }

    /**
     * This method was taken from Stack Overflow
     * (https://stackoverflow.com/questions/2534632/list-all-files-from-a-directory-recursively-with-java)
     * Given a starting directory and a file name, parse the directory for any
     * files matching the given name
     *
     * @param startPath the starting directory to begin the file search from
     * @param fileName the file name to search the directory for
     */
    public static void find(String startPath, String fileName) throws NullPointerException {
        System.out.println("Starting Directory: " + startPath);
        System.out.println("Target File: " + fileName);
        File[] fileList = new File(startPath).listFiles();
        for (File file : fileList) {
            if (file.getName().matches(fileName)) {
                System.out.println("Matching file found at " + file.getAbsolutePath());
                JOptionPane.showMessageDialog(null, "Matching file found at " + file.getAbsolutePath());
            } else {
                System.out.println("File match not found");
            }
            if (file.isDirectory()) {
                find(file.getAbsolutePath(), fileName);
            }
        }
    }
}
