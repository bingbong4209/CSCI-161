package lab104.stepancj;

import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

/**
 * This is the client class. I used a switch case statement to control the menu functions and try-catch blocks to catch unexpected input for each method.
 * The menu is typesafe and asks the user if they wish to try again if given incorrect input.
 * @version 2.18.21
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
        int option;
        String response;

        String optionString = "Please Select the algorithm you would like to test: \n 1) nth Harmonic Number \n 2) Isabel's Technique \n 3) Find and Print \n 4) Exit";

        while (tryAgainOuter) {
            boolean tryAgain = true;
            response = JOptionPane.showInputDialog(optionString);
            switch (response) {
                case "1":
                    while (tryAgain) {
                        try {
                            System.out.println("Computing the nth Harmonic Number");
                            response = JOptionPane.showInputDialog("Please enter a positive integer value");
                            
                            option = Integer.parseInt(response);
                            Recursion.harmonicSetup(option);
                            System.out.println("Input Value: " + option);
                            JOptionPane.showMessageDialog(null, "The Answer is " + Recursion.harmonicComputation(option));
                            int choice = JOptionPane.showConfirmDialog(null, "Would you like to try again?");
                            if (choice == JOptionPane.NO_OPTION) {
                                tryAgain = false;
                            }
                        } catch (NumberFormatException nfe) {
                            System.err.println("Input was not a number");
                            int choice = JOptionPane.showConfirmDialog(null, "Invalid response, would you like to try again?");
                            if (choice == JOptionPane.NO_OPTION) {
                                tryAgain = false;
                            }
                        }
                    }

                    break;
                case "2":
                    while (tryAgain) {
                        try {
                            System.out.println("Using Isabel's Technique");
                            response = JOptionPane.showInputDialog("Please enter a file path");

                            int[] A = Recursion.isabelsTechniqueSetup(response);
                            JOptionPane.showMessageDialog(null, "The summation of the array is " + Recursion.isabelsTechnique(A));

                            int choice = JOptionPane.showConfirmDialog(null, "Would you like to try again?");
                            if (choice == JOptionPane.NO_OPTION) {
                                tryAgain = false;
                            }
                        } catch (FileNotFoundException fnfe) {
                            System.err.println("File Not Found");
                            int choice = JOptionPane.showConfirmDialog(null, "Invalid response, would you like to try again?");
                            if (choice == JOptionPane.NO_OPTION) {
                                tryAgain = false;
                            }
                        }
                    }

                    break;
                case "3":
                    while (tryAgain) {
                        try {
                            System.out.println("Finding and Printing");
                            String pathName = JOptionPane.showInputDialog("Please enter the start path");
                            String fileName = JOptionPane.showInputDialog("Please enter the file name");

                            Recursion.find(pathName, fileName);

                            int choice = JOptionPane.showConfirmDialog(null, "Would you like to try again?");
                            if (choice == JOptionPane.NO_OPTION) {
                                tryAgain = false;
                            }
                        } catch (NullPointerException npe) {
                            System.err.println("File Not Found");
                            int choice = JOptionPane.showConfirmDialog(null, "Invalid response, would you like to try again?");
                            if (choice == JOptionPane.NO_OPTION) {
                                tryAgain = false;
                            }
                        }
                    }
                    break;
                case "4":
                    System.out.println("Thanks for using our interface, do come back again :)");
                    JOptionPane.showMessageDialog(null, "Thanks for using our interface, do come back again :)");
                    tryAgainOuter = false;
                    break;
                default:
                    System.out.println("Invalid Input");
                    JOptionPane.showMessageDialog(null, "Your entry was not 1-4, please try again");
                    tryAgainOuter = true;
                    break;
            }
        }

    }
}
