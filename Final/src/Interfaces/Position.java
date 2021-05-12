package Interfaces;

/**
 * Data Structures & Algorithms 6th Edition
 * Goodrich, Tamassia, Goldwasser
 * Code Fragment 7.7
 * Transcribed by
 * @author Calvin Stepan
 */

public interface Position<E> {
 /**
 * Returns the element stored at this position
 * 
 * @return the stored element
 * @throws IllegalStateException if position no longer valid
 */
 E getElement() throws IllegalStateException;
}
