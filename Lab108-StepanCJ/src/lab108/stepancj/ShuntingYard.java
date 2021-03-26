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
        return symbol.equals("(") || symbol.equals("[") || symbol.equals("{");
    }

    private static boolean isClosedGroupingSymbol(String symbol) {
        return symbol.equals(")") || symbol.equals("]") || symbol.equals("}");
    }

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

    public static LinkedQueue infixToPostfix(LinkedQueue<String> infixQueue) {
        //left queue
        LinkedQueue<String> postfixQueue = new LinkedQueue<>();
        //bottom binaryStack
        LinkedStack<String> binaryStack = new LinkedStack<>();

        //loop to convert the infix to postfix
        int initialSize = infixQueue.size();
        for (int i = 0; i < initialSize; i++) {
            String token = infixQueue.dequeue();
            infixQueue.enqueue(token);

            if (isOperator(token)) {
                binaryStack.push(token);
            } else if (isOpenGroupingSymbol(token)) {
                binaryStack.push(token);
            } else if (!isClosedGroupingSymbol(token)) {
                postfixQueue.enqueue(token);
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
                } else {
                    throw new IllegalStateException("Not a valid expression");
                }
            } catch (NullPointerException npe) {
            }

        }
        return postfixQueue;
    }

    public static double evaluateExpression(LinkedQueue<String> postfixQueue) {
        double answer = 0;
        double leftChild;
        double rightChild;
        int initialSize = postfixQueue.size();
        String token;
        LinkedStack<Double> binaryStack = new LinkedStack();

        for (int i = 0; i < initialSize; i++) {
            token = postfixQueue.dequeue();
            postfixQueue.enqueue(token);

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
            } else {
                throw new IllegalStateException("Expression was not valid");
            }
        }

        return answer;
    }

    public static LinkedBinaryTree<String> expressionToTree(LinkedQueue<String> postfixQueue) {
        int intialSize = postfixQueue.size();
        LinkedBinaryTree<String> leftChild;
        LinkedBinaryTree<String> rightChild;
        String token;
        LinkedStack<LinkedBinaryTree<String>> binaryStack = new LinkedStack<>();

        for (int i = 0; i < intialSize; i++) {
            token = postfixQueue.dequeue();
            postfixQueue.enqueue(token);

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

    public static LinkedQueue traverseQueue(LinkedQueue<String> queue) {
        int initialSize = queue.size();
        LinkedQueue<String> tempQueue = new LinkedQueue<>();

        System.out.println("Original Queue");
        for (int i = 0; i < initialSize; i++) {
            String token = queue.dequeue();
            System.out.print(token + " ");
            tempQueue.enqueue(token);
        }

        System.out.println("\nRecycled Queue");
        initialSize = tempQueue.size();
        for (int i = 0; i < initialSize; i++) {
            String token = tempQueue.dequeue();
            queue.enqueue(token);
            System.out.print(token + " ");
        }
        System.out.println("\n" + queue.size());
        return queue;
    }
}
