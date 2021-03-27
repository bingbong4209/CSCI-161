package lab108.stepancj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * This is the client class, which is the culmination of all the work done in the ShuntingYard class
 * This lab builds off of Lab107-StepanCJ and uses the following classes and interfaces from it:
 * AbstractBinaryTree, AbstractTree, BinaryTree, LinkedBinaryTree, LinkedQueue, LinkedStack, Position, Queue
 * SinglyLinkedList, Stack, and Tree
 * The premise is to prompt the user 
 * 
 * @author Calvin Stepan
 * @version 3.27.2021
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String filePath = JOptionPane.showInputDialog("Please enter an absolute path with a file name");
        //for now, use C:\Users\Calvin\Downloads\data.txt
        
        //make sure we are given a valid filetype
        try {
            File inputFile = ShuntingYard.stringToFile(filePath);
            Scanner scan = new Scanner(inputFile);
            
            while(scan.hasNextLine()) {
            String expression = scan.nextLine();
            
            System.out.print("Expression Read From File: ");
            LinkedQueue infixQueue = ShuntingYard.parseFile(expression);
                      
            System.out.print("\nPostfix Expression: ");
            LinkedQueue postfixQueue = ShuntingYard.infixToPostfix(infixQueue);
            
            double finalAnswer = ShuntingYard.evaluateExpression(postfixQueue);
            
            System.out.println("\nExpression Answer: " + finalAnswer);
            
            LinkedBinaryTree expressionTree = ShuntingYard.expressionToTree(postfixQueue);
            
            Iterator<Position<String>> preorderTraversal = expressionTree.preorder().iterator();
            Iterator<Position<String>> postorderTraversal = expressionTree.postorder().iterator();
            Iterator<Position<String>> inorderTraversal = expressionTree.inorder().iterator();
            
            System.out.print("Preorder Traversal:\t");
            while(preorderTraversal.hasNext())
                System.out.printf("%s ", preorderTraversal.next().getElement());
        
            System.out.print("\nPostorder Traversal:\t");
            while(postorderTraversal.hasNext())
                System.out.printf("%s ", postorderTraversal.next().getElement());
        
            System.out.print("\nInorder Traversal:\t");
            while(inorderTraversal.hasNext())
                System.out.printf("%s ", inorderTraversal.next().getElement());
            
            System.out.print("\nEuler's Tour:\t");
            expressionTree.eulerTourBinary(expressionTree, expressionTree.root());
            System.out.println("\n");
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("Invalid File Path");
        }
        
    }

}
