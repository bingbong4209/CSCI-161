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
        //temp queue
        LinkedQueue<String> tempQueue = new LinkedQueue<>();//--------------------------------

        //loop to convert the infix to postfix
        int initialSize = infixQueue.size();
        for (int i = 0; i < initialSize; i++) {
            String token = infixQueue.dequeue();
            
            //add the token to the temporary queue
            tempQueue.enqueue(token);//--------------------------------------------------
            
            
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
            } else
                throw new IllegalStateException("Not a valid expression");
            } catch (NullPointerException npe){}
            
        }
        System.out.println("PostfixQueue size: " + postfixQueue.size());
        System.out.println("Stack Size: " + binaryStack.size());
        
        //refill the postfixQueue        
        System.out.println("Recycled Queue");
        initialSize = tempQueue.size();
        for(int i = 0; i < initialSize; i++) {
            String token = tempQueue.dequeue();//--------------------------------------------
            postfixQueue.enqueue(token);
            System.out.print(token + " ");
        }
        System.out.println("");
        
        return postfixQueue;
    }

    public static double evaluateExpression(LinkedQueue<String> postfixQueue) {
        double answer = 0;
        double leftChild;
        double rightChild;
        int initialSize;
        String token;
        LinkedStack<Double> binaryStack = new LinkedStack();
        //temp queue
        LinkedQueue<String> tempQueue = new LinkedQueue<>();
        
        while (!postfixQueue.isEmpty()) {
            token = postfixQueue.dequeue();
            
            //add the token to the temporary queue
            tempQueue.enqueue(token);
            
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
        //refill the postfixQueue        
        System.out.println("\nRecycled Queue");
        initialSize = tempQueue.size();
        for(int i = 0; i < initialSize; i++) {
            token = tempQueue.dequeue();//--------------------------------------------
            postfixQueue.enqueue(token);
            System.out.print(token + " ");
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
        
        LinkedQueue<String> tempQueue = new LinkedQueue<>();
        
        while (!postfixQueue.isEmpty()) {
            token = postfixQueue.dequeue();
            
            //add the token to the temporary queue
            tempQueue.enqueue(token);
            System.out.println("Token Value: " + token);
            
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
        
        //refill the postfixQueue
        int intialSize = tempQueue.size();
        for(int i = 0; i < intialSize; i++) {
            System.out.println("Postfix Queue Size: " + postfixQueue.size());
            postfixQueue.enqueue(tempQueue.dequeue());
        }
        
        System.out.println("Binary Stack Size: " + binaryStack.size());
        //resultingTree = binaryStack.pop();
        return resultingTree;
    }
    
    public static LinkedQueue traverseQueue(LinkedQueue<String> queue) {
        int initialSize = queue.size();
        LinkedQueue<String> tempQueue = new LinkedQueue<>();
        
        System.out.println("Original Queue");
        for(int i = 0; i < initialSize; i++) {
            String token = queue.dequeue();
            System.out.print(token + " ");
            tempQueue.enqueue(token);
        }
        
        System.out.println("\nRecycled Queue");
        initialSize = tempQueue.size();
        for(int i = 0; i < initialSize; i++) {
            String token = tempQueue.dequeue();
            queue.enqueue(token);
            System.out.print(token + " ");
        }
        
        System.out.println("\n" + queue.size());
        return queue;
    }
}
