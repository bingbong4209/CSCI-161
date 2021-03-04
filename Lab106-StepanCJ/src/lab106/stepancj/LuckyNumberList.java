package lab106.stepancj;

import java.util.NoSuchElementException;

/**
 * The LuckyNumberList class uses a LinkedPositionalList to take in LuckyNumber objects
 * There are three iterators included in this class: the default, prime, and even
 * All 3 iterate in different ways
 * 
 * Data Structures & Algorithms 6th Edition Goodrich, Tamassia, Goldwasser Code
 * Fragment 7.14 
 * Code was cross referenced with the Alphabet class by
 * @author Joe Latimer
 *
 * Transcribed by
 * @author Calvin Stepan
 * @version 3.4.2021
 */
public class LuckyNumberList {
    //create an empty LinkedPositionalList
    private LinkedPositionalList<LuckyNumber> luckyList = null; 

    /**
     * Default Constructor
     */
    public LuckyNumberList() {
        luckyList = new LinkedPositionalList<>();
    }

    /**
     * 
     * @return the size of the list
     */
    public int size() {
        return luckyList.size();
    }
    
    /**
     * 
     * @return the first element in the list
     */
    public LuckyNumber first() {
        if(luckyList.first() == null)
            return null;
        return luckyList.first().getElement();
    }
    
    /**
     * 
     * @param n a LuckyNumber object to be added to the end of the list
     */
    public void addLuckyNumber(LuckyNumber n) {
        luckyList.addLast(n);
    }

    @Override
    public String toString() {
        String returnString = "";
        returnString += luckyList.size();
        Iterator<LuckyNumber> luckyIterator = luckyList.iterator();

        while (luckyIterator.hasNext()) {
            returnString += luckyIterator.next() + " ";
        }

        return returnString;
    }

    /**
     * 
     * @param n an int representing the luckyNumber
     * @return boolean denoting whether or not the luckyNumber parameter it was passed is even
     */
    public boolean isEven(int n) {
        return (n == 2 || n == 4 || n == 6 || n == 8);
    }
    
    /**
     * 
     * @param n an int representing the luckyNumber
     * @return boolean denoting whether or not the luckyNumber parameter it was passed is prime
     */
    public boolean isPrime(int n) {
        return (n == 1 || n == 2 || n == 3 || n == 5 || n == 7 || n == 9);
    }
    
    //The default iterator iterates over all the contents in the LinkedPositionalList and does not skip and element
    //----- nested PositionIterator class -------------------------------------
    private class DefaultPositionIterator implements Iterator<Position<LuckyNumber>> {

        private Position<LuckyNumber> cursor = luckyList.first();   // position of the next element to report
        private Position<LuckyNumber> recent = null;                // position of last reported element

        //Tests whether the iterator has a next object.
        @Override
        public boolean hasNext() {
            return (cursor != null);
        }

        //Returns the next position in the iterator.
        @Override
        public Position<LuckyNumber> next() throws NoSuchElementException {
            if (cursor == null) {
                throw new NoSuchElementException("nothing left ");
            }
            recent = cursor;
            cursor = luckyList.after(cursor);
            return recent;
        }

        //Removes the element returned by most recent call to next.
        @Override
        public void remove() throws IllegalStateException {
            if (recent == null) {
                throw new IllegalStateException("nothing to remove");
            }
            luckyList.remove(recent);         // remove from outer list
            recent = null;                    // do not allow remove again until next is called
        }
    } //----- end of nested PositionIterator class -----

    //----- nested PositionIterable class -----
    private class DefaultPositionIterable implements Iterable<Position<LuckyNumber>> {

        @Override
        public Iterator<Position<LuckyNumber>> iterator() {
            return new DefaultPositionIterator();
        }
    } //----- end of nested PositionIterable class -----

    //Returns an iterable representation of the list's positions.
    public Iterable<Position<LuckyNumber>> defaultpositions() {
        return new DefaultPositionIterable();  // create a new instace of the inner class
    }
    
    //The prime iterator iterates over the whole list and checks to see which ones are prime and keeps track of the prime ones
    //-----------------start of primePositionIterator Class----------------------
    private class primePositionIterator implements Iterator<Position<LuckyNumber>> {

        private Position<LuckyNumber> cursor = luckyList.first();   // position of the next element to report
        private Position<LuckyNumber> recent = null;                // position of last reported element

        //Tests whether the iterator has a next object.
        @Override
        public boolean hasNext() {
            return (cursor != null);
        }

        //Returns the next position in the iterator.
        @Override
        public Position<LuckyNumber> next() throws NoSuchElementException {
            
            if(recent == null) {
                while(cursor != null && !isPrime(cursor.getElement().luckyNumber))
                    cursor = luckyList.after(cursor);
            }
            
            if (cursor == null) {
                throw new NoSuchElementException("nothing left");
            }
            recent = cursor;
            cursor = luckyList.after(cursor);
            
            while(cursor != null && !isPrime(cursor.getElement().luckyNumber))
                    cursor = luckyList.after(cursor);
            
            return recent;
        }

        //Removes the element returned by most recent call to next.
        @Override
        public void remove() throws IllegalStateException {
            if (recent == null) {
                throw new IllegalStateException("nothing to remove");
            }
            luckyList.remove(recent);         // remove from outer list
            recent = null;                    // do not allow remove again until next is called
        }
    }//-----------------end of primePositionIterator Class-------------------
    //----- nested primePositionIterable class -----
    private class primePositionIterable implements Iterable<Position<LuckyNumber>> {

        @Override
        public Iterator<Position<LuckyNumber>> iterator() {
            return new primePositionIterator();
        }
    } //----- end of nested primePositionIterable class ------------------
    
    public Iterable<Position<LuckyNumber>> primePositions() {
        return new primePositionIterable();
    }
    
    //The even iterator iterates over the whole list and checks to see which ones are even and keeps track of the even ones
    //-----------------start of evenPositionIterator Class----------------------
    private class evenPositionIterator implements Iterator<Position<LuckyNumber>> {

        private Position<LuckyNumber> cursor = luckyList.first();   // position of the next element to report
        private Position<LuckyNumber> recent = null;                // position of last reported element

        //Tests whether the iterator has a next object.
        @Override
        public boolean hasNext() {
            return (cursor != null);
        }

        //Returns the next position in the iterator.
        @Override
        public Position<LuckyNumber> next() throws NoSuchElementException {
            
            if(recent == null) {
                while(cursor != null && !isEven(cursor.getElement().luckyNumber))
                    cursor = luckyList.after(cursor);
            }
            
            if (cursor == null) {
                throw new NoSuchElementException("nothing left ");
            }
            recent = cursor;
            cursor = luckyList.after(cursor);
            
            while(cursor != null && !isEven(cursor.getElement().luckyNumber))
                    cursor = luckyList.after(cursor);
            
            return recent;
        }

        //Removes the element returned by most recent call to next.
        @Override
        public void remove() throws IllegalStateException {
            if (recent == null) {
                throw new IllegalStateException("nothing to remove");
            }
            luckyList.remove(recent);         // remove from outer list
            recent = null;                    // do not allow remove again until next is called
        }
    }//-----------------end of evenPositionIterator Class-------------------
    //----- nested evenPositionIterable class -----
    private class evenPositionIterable implements Iterable<Position<LuckyNumber>> {

        @Override
        public Iterator<Position<LuckyNumber>> iterator() {
            return new evenPositionIterator();
        }
    } //----- end of nested evenPositionIterable class -----
    
    public Iterable<Position<LuckyNumber>> evenPositions() {
        return new evenPositionIterable();
    }
}
