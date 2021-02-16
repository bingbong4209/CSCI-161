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

        //showInputDialogExample("Please Select the algorithm you would like to test: \n 1) nth Harmonic Number \n 2) Isabel's Technique \n 3) Print and Find", "Algorithm Selection");

        showInputDialogMenuExample();

        //showMessageDialogExample();

        //showConfirmDialogExample();

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
        double option;

        switch (response) {
            case "1":
                System.out.println("Computing the nth Harmonic Number");
                response = JOptionPane.showInputDialog(null, "Please enter a positive double value", "nth Harmonic Number", 0);
                option = Double.parseDouble(response);
                JOptionPane.showMessageDialog(null, "The Answer is " + Recursion.Harmonic(option), "Answer", 0);
                break;
            case "2":
                System.out.println("Using Isabel's Technique");
                break;
            case "3":
                System.out.println("Printing and Finding");
            default:
                System.err.println("invalid entry");
        }
    }

    public static void showMessageDialogExample() {
        String response = "George";

        JOptionPane.showMessageDialog(null, null, response, 0);
    }

    public static void showConfirmDialogExample() {
        String response = "Are you sure your name is George?";

        int reply = JOptionPane.showConfirmDialog(null, null, response, 0);

        System.out.println(reply);
    }
}
