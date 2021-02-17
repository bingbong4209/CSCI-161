package lab104.stepancj;

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

        // showInputDialogExample("Please Select the algorithm you would like to test:
        // \n 1) nth Harmonic Number \n 2) Isabel's Technique \n 3) Print and Find",
        // "Algorithm Selection");

        showInputDialogMenuExample();

    }

    public static void showInputDialogExample(String message, String title) {
        String response;

        response = JOptionPane.showInputDialog(null, message, title, 0);

        System.out.println("respone = " + response);
    }

    public static void showInputDialogMenuExample() {
        String response;

        String optionString = "Please Select the algorithm you would like to test: \n 1) nth Harmonic Number \n 2) Isabel's Technique \n 3) Print and Find";

        response = JOptionPane.showInputDialog(null, optionString, "Algorithm Selection", 0);
        int answer = Integer.parseInt(response);
        while (!(answer > 0 && answer < 4)) {
            JOptionPane.showMessageDialog(null, "Your entry was not 1, 2, or 3, please try again");
            response = JOptionPane.showInputDialog(null, optionString, "Algorithm Selection", 0);
            answer = Integer.parseInt(response);
        }
        switch (response) {
            case "1":
                System.out.println("Computing the nth Harmonic Number");
                response = JOptionPane.showInputDialog(null, "Please enter a positive double value",
                        "nth Harmonic Number", 0);
                double option = Double.parseDouble(response);
                while (option < 0) {
                    JOptionPane.showMessageDialog(null, "Your entry was not valid, please try again");
                    response = JOptionPane.showInputDialog(null, "Please enter a positive double value",
                        "nth Harmonic Number", 0);
                    option = Double.parseDouble(response);
                }
                Recursion.harmonicSetup(option);
                JOptionPane.showMessageDialog(null, "The Answer is " + Recursion.harmonicComputation(option), "Answer", 0);
                break;
            case "2":
                System.out.println("Using Isabel's Technique");
                response = JOptionPane.showInputDialog(null, "Please enter a file path", "Size", 0);
                int[] A = Recursion.isabelsTechniqueSetup(response); 
                JOptionPane.showMessageDialog(null, "The summation of the array is " + Recursion.isabelsTechnique(A));
                break;
            case "3":
                String pathName = JOptionPane.showInputDialog("Please enter the start path");
                String fileName = JOptionPane.showInputDialog("Please enter the file name");
                Recursion.find(pathName, fileName);
                System.out.println("Printing and Finding");
            default:
                System.err.println("invalid entry");
        }
    }
    //C:\\Users\\Calvin\\Downloads\\ab.txt
}
