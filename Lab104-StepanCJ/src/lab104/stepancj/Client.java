package lab104.stepancj;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Calvin Stepan
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        showInputDialogMenuExample2();

    }

    public static void showInputDialogMenuExample2() {
        boolean tryAgainOuter = true;
        String response;

        String optionString = "Please Select the algorithm you would like to test: \n 1) nth Harmonic Number \n 2) Isabel's Technique \n 3) Find and Print \n 4) Exit";

        while (tryAgainOuter) {
            response = JOptionPane.showInputDialog(optionString);
            switch (response) {
                case "1":
                    int option = -1;
                    boolean tryAgain = true;
                    while (tryAgain) {
                        try {
                            System.out.println("Computing the nth Harmonic Number");
                            response = JOptionPane.showInputDialog("Please enter a positive integer value");

                            option = Integer.parseInt(response);

                            JOptionPane.showMessageDialog(null, "The Answer is " + Recursion.harmonicComputation(option));
                            int choice = JOptionPane.showConfirmDialog(null, "Invalid response, would you like to try again?");
                            if (choice == JOptionPane.NO_OPTION) {
                                break;
                            }
                        } catch (NumberFormatException nfe) {
                            System.err.println("error");
                            int choice = JOptionPane.showConfirmDialog(null, "Invalid response, would you like to try again?");
                            if (choice == JOptionPane.NO_OPTION) {
                                break;
                            }
                        }
                    }

                    break;
                case "2":
                    System.out.println("Using Isabel's Technique");
                    response = JOptionPane.showInputDialog(null, "Please enter a file path");
                    File isabelPath = new File(response);
                    while (!isabelPath.isFile()) {
                        int choice = JOptionPane.showConfirmDialog(null, "Invalid response, would you like to try again?");
                            if (choice == JOptionPane.NO_OPTION) {
                                break;
                            }
                        JOptionPane.showMessageDialog(null, "Your file path was not valid, please try again");
                        response = JOptionPane.showInputDialog(null, "Please enter a file path");
                        isabelPath = new File(response);
                    }
                    int[] A = Recursion.isabelsTechniqueSetup(response);
                    JOptionPane.showMessageDialog(null, "The summation of the array is " + Recursion.isabelsTechnique(A));
                    break;
                case "3":
                    System.out.println("Finding and Printing");
                    String pathName = JOptionPane.showInputDialog("Please enter the start path");
                    String fileName = JOptionPane.showInputDialog("Please enter the file name");
                    File findPath = new File(pathName);
                    while (!findPath.isDirectory()) {
                        JOptionPane.showMessageDialog(null, "Invalid input, please try again");
                        pathName = JOptionPane.showInputDialog("Please enter the start path");
                        fileName = JOptionPane.showInputDialog("Please enter the file name");
                    }
                    Recursion.find(pathName, fileName);
                case "4":
                    JOptionPane.showMessageDialog(null, "Thanks for using our interface, do come back again :)");
                    tryAgainOuter = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Your entry was not 1-4, please try again");
                    tryAgainOuter = true;
                    break;
            }
        }

    }
    //C:\\Users\\Calvin\\Downloads\\ab.txt
}
