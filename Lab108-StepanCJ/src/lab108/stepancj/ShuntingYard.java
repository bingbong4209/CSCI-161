package lab108.stepancj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Calvin Stepan
 */
public class ShuntingYard {
    
    public static File stringToFile(String filePath) {
        File file = new File(filePath);
        return file;
    }
    
    
    public static ArrayQueue infixToPostfix(String filePath) throws FileNotFoundException {
        System.out.println("File Path: " + filePath);
        ArrayQueue infixQueue = new ArrayQueue();
        ArrayQueue postfixQueue = new ArrayQueue();
        Scanner scan = new Scanner(new File(filePath));
        while (scan.hasNext()) {
            /**
             * need to repeat the loop for each line but have it stop before it goes to a new line
             * evaluate each line one at a time
             */
            String token = scan.next();

        }

        
        return postfixQueue;
    }
    /**
     * Take in the file
     * Convert Infix to Postfix
     * -input: infix queue
     * -output: postfix queue
     * evaluate expression
     * convert into binary tree
     * run traversals
     */
}
