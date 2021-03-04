package lab106.stepancj;

import java.util.NoSuchElementException;

/**
 * Data Structures & Algorithms 6th Edition Goodrich, Tamassia, Goldwasser Code
 * Fragment 7.14 Code was cross referenced with the Alphabet class by
 *
 * @author Joe Latimer
 *
 * Transcribed by
 * @author Calvin Stepan
 * @version 3.3.2021
 */
public class LuckyNumberList {

    private LinkedPositionalList<LuckyNumber> luckyList = null;

    public LuckyNumberList() {
        luckyList = new LinkedPositionalList<>();
    }

    public int size() {
        return luckyList.size();
    }
    
    public LuckyNumber first() {
        if(luckyList.first() == null)
            return null;
        return luckyList.first().getElement();
    }
    
    public void addLuckyNumber(LuckyNumber n) {
        luckyList.addLast(n);
    }
    //***dash in printf makes things left-justified
    /**
     * FIX THIS METHOD PLEASE OR FIGURE OUT IF IT IS NEEDED
     *
     * @param luckyNumber
     * @return
     */
    public boolean isPrimeNumber(int luckyNumber) {
        boolean flag = true;

        
        
        for(int i = 1; i < luckyNumber / 2; i++) {
            if(luckyNumber % i == 0)
                flag = false;
        }
        return flag;
    }

    //FIND OUT WHY THE TOSTRING METHOD DOES NOT WORK
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

    public boolean isEven(int n) {
        return (n == 2 || n == 4 || n == 6 || n == 8);
    }
    public boolean isPrime(int n) {
        return (n == 1 || n == 2 || n == 3 || n == 5 || n == 7 || n == 9);
    }
    
    //----- nested PositionIterator class ----------------------------------------------------------------------------------------------
    private class PositionIterator implements Iterator<Position<LuckyNumber>> {

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
    private class PositionIterable implements Iterable<Position<LuckyNumber>> {

        @Override
        public Iterator<Position<LuckyNumber>> iterator() {
            return new PositionIterator();
        }
    } //----- end of nested PositionIterable class -----

    //Returns an iterable representation of the list's positions.
    public Iterable<Position<LuckyNumber>> positions() {
        return new PositionIterable();  // create a new instace of the inner class
    }
    
    //-----------------start of primePositionIterator Class----------------------------------------------------------------------------
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
    } //----- end of nested primePositionIterable class ------------------------
    
    public Iterable<Position<LuckyNumber>> primePositions() {
        return new primePositionIterable();
    }//---------------------------------------------------------------------------------------------------------------------------------
    
    //-----------------start of evenPositionIterator Class------------------------------------------------------------------------------
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
    }//----------------------------------------------------------------------------------------------------------------------------------
}
