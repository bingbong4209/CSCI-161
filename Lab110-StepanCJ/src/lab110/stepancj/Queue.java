package lab110.stepancj;

/**
 * Data Structures & Algorithms 6th Edition 
 * Goodrich, Tamassia, Goldwasser
 * Code Fragment 6.9
 * An implementation of the Queue Interface
 * Transcribed by 
 * 
 * @author Calvin Stepan
 * @version 2.23.2021
 * @param <E>
 */
public interface Queue<E> {
 //Returns the number of elements in the queue. ∗/
 int size( );
 //Tests whether the queue is empty. ∗/
 boolean isEmpty( );
 //Inserts an element at the rear of the queue. ∗/
 void enqueue(E e);
 //Returns, but does not remove, the first element of the queue (null if empty). ∗/
 E first( );
 //Removes and returns the first element of the queue (null if empty). ∗/
 E dequeue( );
 }
