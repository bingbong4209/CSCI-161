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
        two.addRoot(2);
        LinkedBinaryTree nine = new LinkedBinaryTree();
        nine.addRoot(9);
        LinkedBinaryTree leftAdd = new LinkedBinaryTree();
        leftAdd.addRoot("+");
        leftAdd.addLeft(nine.root(), nine);
        leftAdd.addRight(two.root(), two);
        
        
        //Subtree 2 on the right(3 * 8)
        LinkedBinaryTree three = new LinkedBinaryTree();
        three.addRoot(3);
        LinkedBinaryTree eight = new LinkedBinaryTree();
        eight.addRoot(8);
        LinkedBinaryTree multiply = new LinkedBinaryTree();
        multiply.addRoot("*");
        multiply.addLeft(three.root(), three);
        multiply.addRight(eight.root(), eight);
        
        //Subtree 3 on the Right(7 - Subtree 2)
        LinkedBinaryTree seven = new LinkedBinaryTree();
        seven.addRoot(9);
        LinkedBinaryTree minus = new LinkedBinaryTree();
        minus.addRoot("-");
        minus.addLeft(seven.root(), seven);
        minus.addRight(multiply.root(), multiply);
        
        //Subtree 4(Left Subtree + Right Subtrees)
        LinkedBinaryTree finalTree = new LinkedBinaryTree();
        finalTree.addRoot("+");
        finalTree.addLeft(leftAdd.root(), leftAdd);
        finalTree.addRight(minus.root(), minus);
                
        System.out.println("(   2   +   9   )   +   (   7   -   (   3    *   8   )   )");
        
        Iterator<Position<String>> preorderTraversal = finalTree.preorder().iterator();
        Iterator<Position<String>> postorderTraversal = finalTree.postorder().iterator();
        Iterator<Position<String>> inorderTraversal = finalTree.inorder().iterator();
        Iterator<Position<String>> breathfirstTraversal = finalTree.inorder().iterator();
        //while(preorderTraversal.hasNext())
            System.out.println(preorderTraversal.next());
            System.out.println(finalTree.size());
        
        //System.out.println(finalTree.height(finalTree.root()));
        
        /**
         * create iterator for each traversal
         * while has next loop
         * print out contents
         */
        /**
         * Print out the following:
         * height of tree
         * preorder traversal results
         * inorder traversal results
         * postorder traversal results
         * breathfirst traversal results
         * parenthesized representation of tree(using fragments 8.4.6 and 8.29 NOT 8.26)
         */
        
    }
    
}
