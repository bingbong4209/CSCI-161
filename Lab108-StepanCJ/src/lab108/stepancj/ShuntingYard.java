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
        //bottom binaryStack
        LinkedStack<String> binaryStack = new LinkedStack<>();

        //loop to convert the infix to postfix
        int initialSize = infixQueue.size();
        for (int i = 0; i < initialSize; i++) {
            String dequeued = infixQueue.dequeue();
            if (isOperator(dequeued)) {
                binaryStack.push(dequeued);
            } else if (isOpenGroupingSymbol(dequeued)) {
                binaryStack.push(dequeued);
            } else if (!isClosedGroupingSymbol(dequeued)) {
                postfixQueue.enqueue(dequeued);
            }
        }
        while (!binaryStack.isEmpty()) {
            //remove any grouping symbols and append any operators to the end of the postfix expression
            String pop = binaryStack.pop();
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
        System.out.println("Stack Size: " + binaryStack.size());
        return postfixQueue;
    }

    public static double evaluateExpression(LinkedQueue<String> postfixQueue) {
        double answer = 0;
        double leftChild;
        double rightChild;
        String token;
        LinkedStack<Double> binaryStack = new LinkedStack();

        while (!postfixQueue.isEmpty()) {
            token = postfixQueue.dequeue();

            if (!isOperator(token)) {
                binaryStack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                rightChild = binaryStack.pop();
                leftChild = binaryStack.pop();
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
                binaryStack.push(answer);
            } else {
                throw new IllegalStateException("Expression was not valid");
            }
        }
        return answer;
    }
    
    public static LinkedBinaryTree expressionToTree(LinkedQueue<String> postfixQueue) {
        System.out.println("Input Queue Size: " + postfixQueue.size());
        
        LinkedBinaryTree resultingTree = new LinkedBinaryTree();
        LinkedBinaryTree leftChild = new LinkedBinaryTree();
        LinkedBinaryTree rightChild = new LinkedBinaryTree();
        String token;
        LinkedStack<LinkedBinaryTree> binaryStack = new LinkedStack();

        while (!postfixQueue.isEmpty()) {
            token = postfixQueue.dequeue();
            if (!isOperator(token)) {
                LinkedBinaryTree temp = new LinkedBinaryTree();
                temp.addRoot(token);
                binaryStack.push(temp);
            } else if (isOperator(token)) {
                
                rightChild.addRoot(binaryStack.pop());
                leftChild.addRoot(binaryStack.pop());
                
                Position pos = resultingTree.addRoot(token);
                
                resultingTree.attach(pos, leftChild, rightChild);
                binaryStack.push(resultingTree);
            } else {
                throw new IllegalStateException("Expression was not valid");
            }
        }
        System.out.println("Binary Stack Size: " + binaryStack.size());
        //resultingTree = binaryStack.pop();
        return resultingTree;
    }
    /**
     * Take in the file Convert Infix to Postfix -input: infix queue -output:
     * postfix queue
     *
     * evaluate expression input: postfix queue output: double, number convert
     * into binary tree run traversals
     */
}
