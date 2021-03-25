package lab108.stepancj;

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

        String filePath = JOptionPane.showInputDialog("Please enter an absolute path with a file name");
        
        //convert it to a file
        ShuntingYard.stringToFile(filePath);
    }
    
}
