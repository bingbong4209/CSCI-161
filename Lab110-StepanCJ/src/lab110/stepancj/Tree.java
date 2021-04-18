package lab110.stepancj;

import java.util.Iterator;

/**
 * An interface for a tree where nodes can have an arbitrary number of children
 * Code Fragment8.1 from Data Structures and Algorithms, 6th Edition by
 * Michael T. Goodrich, Roberto Tamassia & Michael H. Goldwasser 
 * Transcribed by 
 * @author Calvin Stepan
 * @version 3.5.2021
 */
public interface Tree<E> extends Iterable<E> {

    Position<E> root();

    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

    int numChildren(Position<E> p) throws IllegalArgumentException;

    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    int size();

    boolean isEmpty();

    Iterator<E> iterator();

    Iterable<Position<E>> positions();
}
