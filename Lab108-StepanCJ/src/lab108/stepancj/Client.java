package lab108.stepancj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
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
        
        try {
            File inputFile = ShuntingYard.stringToFile(filePath);
            Scanner scan = new Scanner(inputFile);
            
            while(scan.hasNextLine()) {
            String expression = scan.nextLine();
            
            LinkedQueue infixQueue = ShuntingYard.parseFile(expression);
                        
            LinkedQueue postfixQueue = ShuntingYard.infixToPostfix(infixQueue);
            
            double finalAnswer = ShuntingYard.evaluateExpression(postfixQueue);
            
            System.out.println( "\nExpression Answer: " + finalAnswer + "\n");
            /*
            LinkedBinaryTree expressionTree = ShuntingYard.expressionToTree(postfixQueue);
            System.out.println(expressionTree.size());
            
            Iterator<Position<String>> preorderTraversal = expressionTree.preorder().iterator();
            Iterator<Position<String>> postorderTraversal = expressionTree.postorder().iterator();
            Iterator<Position<String>> inorderTraversal = expressionTree.inorder().iterator();
            while(inorderTraversal.hasNext()) {
                System.out.printf("%s  \t", inorderTraversal.next().getElement());
            }
            */
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("Invalid File");
        }
        
    }

}
