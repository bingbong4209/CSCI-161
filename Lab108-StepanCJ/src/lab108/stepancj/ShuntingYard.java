package lab108.stepancj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is the ShuntingYard Class, where all the methods for the Shunting Yard are stored
 * To make debugging and workflow go over smoothly, I separated each piece of the lab into a separate method
 * This allowed for easy debugging
 * 
 * @author Calvin Stepan
 * @version 3.27.2021
 */
public class ShuntingYard {

    /**
     * 
     * @param filePath String representing the absolute file path of the given file
     * @return the file at the specified location as a File object
     * @throws FileNotFoundException 
     */
    public static File stringToFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        return file;
    }

    /**
     * 
     * @param operator a String
     * @return whether or not String operator is in fact an operator
     */
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

    /**
     * 
     * @param symbol a String
     * @return whether or not String symbol is in fact an open grouping symbol
     */
    private static boolean isOpenGroupingSymbol(String symbol) {
        return symbol.equals("(") || symbol.equals("[") || symbol.equals("{");
    }

    /**
     * 
     * @param symbol a String
     * @return whether or not String symbol is in fact a closed grouping symbol
     */
    private static boolean isClosedGroupingSymbol(String symbol) {
        return symbol.equals(")") || symbol.equals("]") || symbol.equals("}");
    }

    /**
     * 
     * @param expression a String representing an arithmetic expression
     * @return a LinkedQueue of Strings representing the infix notation of the input string
     * @throws FileNotFoundException 
     */
    public static LinkedQueue parseFile(String expression) throws FileNotFoundException {
        LinkedQueue<String> infixQueue = new LinkedQueue<>();
        Scanner scan = new Scanner(expression);

        while (scan.hasNext()) {
            String token = scan.next();
            infixQueue.enqueue(token);
            System.out.print(token + " ");
        }
        return infixQueue;
    }

    /**
     * 
     * @param infixQueue the LinkedQueue in infix notation
     * @return a LinkedQueue called postfixQueue in postfix notation
     */
    public static LinkedQueue infixToPostfix(LinkedQueue<String> infixQueue) {
        String pop;
        String token;
        int initialSize;
        int stackSize;
        //left queue
        LinkedQueue<String> postfixQueue = new LinkedQueue<>();
        //bottom binaryStack
        LinkedStack<String> binaryStack = new LinkedStack<>();

        //loop to convert the infix to postfix
        initialSize = infixQueue.size();
        for (int i = 0; i < initialSize; i++) {
            token = infixQueue.dequeue();

            if (isOperator(token)) {
                binaryStack.push(token);
            } else if (isOpenGroupingSymbol(token)) {
                binaryStack.push(token);
            } else if (isClosedGroupingSymbol(token)) {

                while (!isOpenGroupingSymbol(binaryStack.top())) {
                    pop = binaryStack.pop();
                    postfixQueue.enqueue(pop);
                    System.out.print(pop + " ");
                }
            } else {
                postfixQueue.enqueue(token);
                System.out.print(token + " ");
            }
        }

        stackSize = binaryStack.size();
        for (int i = 0; i < stackSize; i++) {
            token = binaryStack.pop();
            if (isOperator(token)) {
                postfixQueue.enqueue(token);
                System.out.print(token + " ");
            }
        }
        return postfixQueue;
    }

    /**
     * 
     * @param postfixQueue the LinkedQueue in postfix notation
     * @return the Double answer corresponding to the postfixQueue
     */
    public static double evaluateExpression(LinkedQueue<String> postfixQueue) {
        double answer = 0;
        double leftChild;
        double rightChild;
        int initialSize = postfixQueue.size();
        String token;
        LinkedStack<Double> binaryStack = new LinkedStack<>();
        LinkedQueue<String> tempQueue = new LinkedQueue<>();
        
        //if the expression is a single number this makes sure it actually returns a valid answer
        if(initialSize == 1) {
            token = postfixQueue.dequeue();
            postfixQueue.enqueue(token);
            return Double.parseDouble(token);
        }
        
        for (int i = 0; i < initialSize; i++) {
            token = postfixQueue.dequeue();
            tempQueue.enqueue(token);//---------------------------------------------

            if (!isOperator(token)) {
                binaryStack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                rightChild = binaryStack.pop();
                leftChild = binaryStack.pop();
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
                binaryStack.push(answer);
            }
        }
        //refill the postfixQueue        
        initialSize = tempQueue.size();
        for (int i = 0; i < initialSize; i++) {
            token = tempQueue.dequeue();//--------------------------------------------
            postfixQueue.enqueue(token);
        }
        System.out.print("Stack count: " + binaryStack.size() + "  ");
        if(binaryStack.size() > 1) {
            throw new IllegalStateException("Not a valid expression");
        }
        return answer;
    }

    /**
     * 
     * @param postfixQueue the LinkedQueue in postfix notation
     * @return the LinkedBinaryTree corresponding to the given postfixQueue
     */
    public static LinkedBinaryTree<String> expressionToTree(LinkedQueue<String> postfixQueue) {
        int intialSize = postfixQueue.size();
        LinkedBinaryTree<String> leftChild;
        LinkedBinaryTree<String> rightChild;
        String token;
        LinkedStack<LinkedBinaryTree<String>> binaryStack = new LinkedStack<>();

        for (int i = 0; i < intialSize; i++) {
            token = postfixQueue.dequeue();

            if (!isOperator(token)) {
                LinkedBinaryTree<String> temp = new LinkedBinaryTree<>();
                temp.addRoot(token);
                binaryStack.push(temp);
            } else if (isOperator(token)) {
                LinkedBinaryTree<String> tempTree = new LinkedBinaryTree<>();

                rightChild = binaryStack.pop();
                leftChild = binaryStack.pop();

                tempTree.addRoot(token);

                tempTree.attach(tempTree.root(), leftChild, rightChild);
                binaryStack.push(tempTree);
            } else {
                throw new IllegalStateException("Expression was not valid");
            }
        }
        return binaryStack.pop();
    }
}
