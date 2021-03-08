package lab107.stepancj;

/**
 * Data Structures & Algorithms 6th Edition
 * Goodrick, Tamassia, Goldwasser
 * Section 7.4.1
 * Pulled from IteratorExample1 by
 * @Joe Latimer
 * 
 * Used by
 * @author Calvin Stepan
 */
public interface Iterable<E> {
    
    Iterator<E> iterator( ); // Returns an iterator of the elements in the collection
   
}
