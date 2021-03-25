package lab108.stepancj;

import java.io.File;
import java.io.FileNotFoundException;
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
        //for now, use C:\Users\Calvin\Downloads\data.txt
        //or C:\Users\User\Downloads\data.txt
        //convert it to a file
        try {
            File inputFile = ShuntingYard.stringToFile(filePath);

            ArrayQueue infixQueue = ShuntingYard.parseFile(inputFile);
            
            ArrayQueue postfixQueue = ShuntingYard.infixToPostfix(infixQueue);
            
            //ShuntingYard.evaluateExpression(postfixQueue);
        } catch (FileNotFoundException fnfe) {

        }

    }

}
