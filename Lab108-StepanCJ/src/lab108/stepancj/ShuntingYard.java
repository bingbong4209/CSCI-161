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

    public static LinkedQueue parseFile(String expression) throws FileNotFoundException {
        //System.out.println("File Path: " + inputFile);
        LinkedQueue<String> infixQueue = new LinkedQueue<>();
        Scanner scan = new Scanner(expression);

        while (scan.hasNext()) {
            String token = scan.next();
            infixQueue.enqueue(token);
        }
        System.out.println("InfixQueue size: " + infixQueue.size());
        return infixQueue;
    }

    public static LinkedQueue infixToPostfix(LinkedQueue<String> infixQueue) {
        //left queue
        LinkedQueue<String> postfixQueue = new LinkedQueue<>();
        //bottom stack
        LinkedStack<String> stack = new LinkedStack<>();

        //loop to convert the infix to postfix
        int initialSize = infixQueue.size();
        for (int i = 0; i < initialSize; i++) {
            String dequeued = infixQueue.dequeue();
            if (isOperator(dequeued)) {
                stack.push(dequeued);
            } else if (isOpenGroupingSymbol(dequeued)) {
                stack.push(dequeued);
            } else if (!isClosedGroupingSymbol(dequeued)) {
                postfixQueue.enqueue(dequeued);
            }
        }
        while (!stack.isEmpty()) {
            //remove any grouping symbols and append any operators to the end of the postfix expression
            String pop = stack.pop();
            String dequeue = infixQueue.dequeue();
            try {
                if (isOperator(pop)) {
                postfixQueue.enqueue(pop);
            } else if (isOpenGroupingSymbol(pop) && isClosedGroupingSymbol(dequeue)) {
            } else
                throw new IllegalStateException("Not a valid expression");
            } catch (NullPointerException npe){}
            
        }
        System.out.println("PostfixQueue size: " + postfixQueue.size());
        System.out.println("Stack Size: " + stack.size());
        return postfixQueue;
    }

    public static double evaluateExpression(LinkedQueue<String> postfixQueue) {
        double answer = 0;
        double leftChild;
        double rightChild;
        String token;
        LinkedStack<Double> stack = new LinkedStack();

        while (!postfixQueue.isEmpty()) {
            token = postfixQueue.dequeue();

            if (!isOperator(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                rightChild = stack.pop();
                leftChild = stack.pop();
                System.out.println("Left Child: " + leftChild);
                System.out.println("Right Child: " + rightChild);
                switch (token) {
                    case "+":
                        answer = leftChild + rightChild;
                        break;
                    case "-":
                        answer = leftChild - rightChild;
                        break;
                    case "*":
                        answer = leftChild * rightChild;
                        break;
                    case "/":
                        answer = leftChild / rightChild;
                        break;
                    default:
                }
                System.out.println("Answer: " + answer);
                stack.push(answer);
            } else {
                throw new IllegalStateException("Expression was not valid");
            }
        }
        return answer;
    }
    /**
     * Take in the file Convert Infix to Postfix -input: infix queue -output:
     * postfix queue
     *
     * evaluate expression input: postfix queue output: double, number convert
     * into binary tree run traversals
     */
}
