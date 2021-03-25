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

    private static boolean isOperator(String operator) {
        switch (operator) {
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

    private static boolean isOpenGroupingSymbol(String symbol) {
        return symbol.equals("(") || symbol.equals("[");
    }
    
    private static boolean isClosedGroupingSymbol(String symbol) {
        return symbol.equals(")") || symbol.equals("]");
    }

    public static ArrayQueue parseFile(File inputFile) throws FileNotFoundException {
        System.out.println("File Path: " + inputFile);
        ArrayQueue<String> infixQueue = new ArrayQueue<>();
        Scanner scan = new Scanner(inputFile);

        while (scan.hasNext()) {
            String token = scan.next();
            infixQueue.enqueue(token);
        }
        System.out.println("InfixQueue size: " + infixQueue.size());
        return infixQueue;
    }

    public static ArrayQueue infixToPostfix(ArrayQueue<String> infixQueue) {
        //copy the infixQueue so we don't destroy the actual one in the process
        ArrayQueue<String> copyQueue = new ArrayQueue<>();

        //loop to copy the data over
        int initialSize = infixQueue.size();
        for (int i = 0; i < initialSize; i++) {
            String dequeued = infixQueue.dequeue();
            copyQueue.enqueue(dequeued);
        }
        System.out.println("CopyQueue Size: " + copyQueue.size());

        //left queue
        ArrayQueue<String> postfixQueue = new ArrayQueue<>();
        //bottom stack
        ArrayStack<String> stack = new ArrayStack<>();

        //loop to convert the infix to postfix
        initialSize = copyQueue.size();
        for (int i = 0; i < initialSize; i++) {
            String dequeued = copyQueue.dequeue();
            if (isOperator(dequeued)) {
                stack.push(dequeued);
            } else if (isOpenGroupingSymbol(dequeued)) {
                stack.push(dequeued);
            } else if(!isClosedGroupingSymbol(dequeued)) {
                postfixQueue.enqueue(dequeued);
            }
            //remove any grouping symbols and append any operators to the end of the postfix expression
            String pop = stack.pop();
            String dequeue = copyQueue.dequeue();
            try {
                if (isOperator(pop)) {
                    postfixQueue.enqueue(pop);
                } else if(isOpenGroupingSymbol(pop) && isClosedGroupingSymbol(dequeue)){}
                    
            } catch (NullPointerException npe) {
            }
        }
        //postfixQueue.enqueue(stack.pop());
        System.out.println("PostfixQueue size: " + postfixQueue.size());
        System.out.println("Stack Size: " + stack.size());
        return postfixQueue;
    }

    public static double evaluateExpression(ArrayQueue<String> postfixQueue) {
        double answer = 0;
        String dequeued = "";
        ArrayQueue<String> copyQueue = new ArrayQueue<>();
        //loop to copy the data over
        int initialSize = postfixQueue.size();
        for (int i = 0; i < initialSize; i++) {
            dequeued = postfixQueue.dequeue();
            copyQueue.enqueue(dequeued);
        }
        System.out.println("CopyQueue Size: " + copyQueue.size());

        //convert queue into string
        initialSize = copyQueue.size();

        for (int i = 0; i < initialSize; i++) {
            dequeued += postfixQueue.dequeue();
        }

        //put into a tree
        Scanner scan = new Scanner(dequeued);
//        while (scan.hasNext()) {
//            if(isOperator(scan.next()))
//        }

        return answer;
    }
    /**
     * Take in the file 
     * Convert Infix to Postfix 
     * -input: infix queue 
     * -output: postfix queue
     *
     * evaluate expression 
     * input: postfix queue 
     * output: double, number 
     * convert into binary tree run traversals
     */
}
