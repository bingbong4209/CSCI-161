package lab110.stepancj;

/**
 * Data Structures & Algorithms 6th Edition 
 * Goodrich, Tamassia, Goldwasser
 * Code Fragment 6.11
 * An implementation of the LinkedQueue class
 * This class implements the Queue Interface and uses the SinglyLinkedList as its container
 * Transcribed by 
 * 
 * @author Calvin Stepan
 * @version 2.23.2021
 * @param <E>
 */
//Realization of a FIFO queue as an adaptation of a SinglyLinkedList. ∗/
public class LinkedQueue<E> implements Queue<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>(); // an empty list

    public LinkedQueue() {
    } // new queue relies on the initially empty list

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(E element) {
        list.addLast(element);
    }

    public E first() {
        return list.first();
    }

    public E dequeue() {
        return list.removeFirst();
    }
}
