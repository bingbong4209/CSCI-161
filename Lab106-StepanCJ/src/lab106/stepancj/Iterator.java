package lab106.stepancj;

/**
 * Data Structures & Algorithms 6th Edition Goodrich, Tamassia, Goldwasser
 * Section 7.4 
 * Transcribed by
 *
 * @author Calvin Stepan
 * @version 3.3.2021
 */
public interface Iterator<E> {

    boolean hasNext(); // Returns true if there is at least one additional 
    // element in the sequence, and false otherwise.

    E next();          // Returns the next element in the sequence.

    void remove() throws IllegalStateException;
    // Removes from the collection the element returned by
    // the most recent call to next( ).  Throws an 
    // IllegalStateException if next has not yet been called,
    // or if remove was already called since the most recent
    // call to next.

}
