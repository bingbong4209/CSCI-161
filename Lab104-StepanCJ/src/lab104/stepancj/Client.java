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
        String response;

        String optionString = "Please Select the algorithm you would like to test: \n 1) nth Harmonic Number \n 2) Isabel's Technique \n 3) Find and Print \n 4) Exit";

        response = JOptionPane.showInputDialog(optionString);  
        int answer = Integer.parseInt(response);
        while (!(answer > 0 && answer < 5)) {
            JOptionPane.showMessageDialog(null, "Your entry was not 1-4, please try again");
            response = JOptionPane.showInputDialog(optionString);
            answer = Integer.parseInt(response);
        }
        switch (response) {
            case "1":
                System.out.println("Computing the nth Harmonic Number");
                response = JOptionPane.showInputDialog("Please enter a positive integer value");
                int option = -1;
                boolean flag = false;
                try {
                    option = Integer.parseInt(response);
                } catch (NumberFormatException nfe) {
                    System.err.println("error");
                    flag = true;
                }
                while (!Recursion.harmonicSetup(option) || flag == true) {
                    JOptionPane.showMessageDialog(null, "Your entry was not valid, please try again");
                    response = JOptionPane.showInputDialog(null, "Please enter a positive double value");
                    option = Integer.parseInt(response);
                }
                JOptionPane.showMessageDialog(null, "The Answer is " + Recursion.harmonicComputation(option));
                break;
            case "2":
                System.out.println("Using Isabel's Technique");
                response = JOptionPane.showInputDialog(null, "Please enter a file path");
                File isabelPath = new File(response);
                while (!isabelPath.isFile()) {
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
                break;
            default:
            //JOptionPane.showInputDialog(response)
        }
    }
    //C:\\Users\\Calvin\\Downloads\\ab.txt
}
