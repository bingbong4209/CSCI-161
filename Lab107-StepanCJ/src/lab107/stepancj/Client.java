package lab107.stepancj;

import java.util.Iterator;

/**
 * The client class holds the binary tree experiment code
 * We start by creating an instance of a binary tree and traversing it to test our methods
 * @author Calvin Stepan
 * @version 3.10.2021
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Subtree 1 on the left(2 + 9)
        LinkedBinaryTree two = new LinkedBinaryTree();
        two.addRoot("2");
        LinkedBinaryTree nine = new LinkedBinaryTree();
        nine.addRoot("9");
        LinkedBinaryTree leftAdd = new LinkedBinaryTree();
        leftAdd.addRoot("+");
        leftAdd.attach(leftAdd.root(), two, nine);    
        
        //Subtree 2 on the right(3 * 8)
        LinkedBinaryTree three = new LinkedBinaryTree();
        three.addRoot("3");
        LinkedBinaryTree eight = new LinkedBinaryTree();
        eight.addRoot("8");
        LinkedBinaryTree multiply = new LinkedBinaryTree();
        multiply.addRoot("*");
        multiply.attach(multiply.root(), three, eight);
        
        //Subtree 3 on the Right(7 - Subtree 2)
        LinkedBinaryTree seven = new LinkedBinaryTree();
        seven.addRoot("7");
        LinkedBinaryTree minus = new LinkedBinaryTree();
        minus.addRoot("-");
        minus.attach(minus.root(), seven, multiply);
        
        //Subtree 4(Left Subtree + Right Subtrees)
        LinkedBinaryTree finalTree = new LinkedBinaryTree();
        finalTree.addRoot("+");
        finalTree.attach(finalTree.root(), leftAdd, minus);

                
        System.out.println("String Literal Expression:\t(   2   +   9   )   +   (   7   -   (   3    *   8   )   )");
        
        Iterator<Position<String>> preorderTraversal = finalTree.preorder().iterator();
        Iterator<Position<String>> postorderTraversal = finalTree.postorder().iterator();
        Iterator<Position<String>> inorderTraversal = finalTree.inorder().iterator();
        Iterator<Position<String>> breadthfirstTraversal = finalTree.breadthfirst().iterator();
                
        System.out.print("Preorder Traversal:\t\t");
        while(preorderTraversal.hasNext())
            System.out.printf("%s  \t", preorderTraversal.next().getElement());
        
        System.out.print("\nPostorder Traversal:\t\t");
        while(postorderTraversal.hasNext())
            System.out.printf("%s  \t", postorderTraversal.next().getElement());
        
        System.out.print("\nInorder Traversal:\t\t");
        while(inorderTraversal.hasNext())
            System.out.printf("%s  \t", inorderTraversal.next().getElement());
        
        System.out.print("\nBreadthFirst Traversal:\t\t");
        while(breadthfirstTraversal.hasNext())
            System.out.printf("%s  \t", breadthfirstTraversal.next().getElement());
        
        System.out.print("\nTree Height:\t\t\t" + finalTree.height(finalTree.root()));
        System.out.print("\nParenthesized Tree:\t\t");
        
        finalTree.eulerTourBinary(finalTree, finalTree.root());
        System.out.println("\n");
    }
}
