package lab105.stepancj;

/**
 * Data Structures & Algorithms 6th Edition 
 * Goodrich, Tamassia, Goldwasser
 * Code Fragment 6.1
 * An implementation of the Stack Interface
 * Transcribed by 
 * 
 * @author Calvin Stepan
 * @version 2.23.2021
 * @param <E>
 */
public interface Stack<E> {

    /**
     * @return number of elements in the stack
     */
    int size();

    /**
     * Tests whether the stack is empty.
     * @return true if the stack is empty, false otherwise 
     */
    boolean isEmpty();
    
    /**
     * Inserts an element at the top of the stack.
     * @param e the element to be inserted
     */
    void push(E e);

    /**
     * Returns, but does not remove, the element at the top of the stack
     * @return top element in the stack (or null if empty
     */
    E top();

    /**
     * Removes and returns the top element from the stack
     * @return element removed(or null if empty)
     */
    E pop();
}
