package exam.pkg3.code.bits;

/**
 * An interface for a binary tree, in which each node has at most two children
 * Code Fragment 8.6 from Data Structures and Algorithms, 6th Edition by
 * Michael T. Goodrich, Roberto Tamassia & Michael H. Goldwasser 
 * Transcribed by 
 * @author Calvin Stepan
 * @version 3.5.2021
 */
public interface BinaryTree<E> extends Tree<E> {
    
    //Returns the Position of p's left child (or null if no child exists)
    Position<E> left(Position<E> p) throws IllegalArgumentException;
    
    //Returns the Position of p's right child (or null if no child exists)
    Position<E> right(Position<E> p) throws IllegalArgumentException;
    
    //Returns the Position of p's sibling (or null if no sibling exists)
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
} 
