package lab108.stepancj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Calvin Stepan
 */
public class ShuntingYard {
    
    public static File stringToFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        return file;
    }
    
    private boolean isOperator(String operator) {
        switch(operator) {
            case "+":
                return true;
            case "-":
                return true;
            case "*":
                return true;
            case "/":
                return true;
            default: 
                return false;
        }
    }
    
    public static ArrayQueue parseFile(File inputFile) throws FileNotFoundException {
        System.out.println("File Path: " + inputFile);
        ArrayQueue infixQueue = new ArrayQueue();
        Scanner scan = new Scanner(inputFile);
        while (scan.hasNext()) {
            /**
             * need to repeat the loop for each line but have it stop before it goes to a new line
             * evaluate each line one at a time
             */
            String token = scan.next();

        }

        
        return infixQueue;
    }
    
    public static ArrayQueue infixToPostfix(ArrayQueue infixQueue) {
        
        ArrayQueue postfixQueue = new ArrayQueue();
        
        return postfixQueue;
    }
    /**
     * Take in the file
     * Convert Infix to Postfix
     * -input: infix queue
     * -output: postfix queue
     * evaluate expression
     * input: postfix queue
     * output: double, number
     * convert into binary tree
     * run traversals
     */
}
