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

    public void addLuckyNumber(LuckyNumber n) {
        luckyList.addLast(n);
    }
    
    /**
     * FIX THIS METHOD PLEASE OR FIGURE OUT IF IT IS NEEDED
     * @param luckyNumber
     * @return 
     */
    public boolean isLuckyNumber(int luckyNumber) {
        /**
         * loop through the list of lucky numbers
         * compare them to the given number
         * if yes, return true
         * else false
         */
        return true;
    }

    //FIND OUT WHY THE TOSTRING METHOD DOES NOT WORK
    @Override
    public String toString() {
        String returnString = "";

        Iterator<LuckyNumber> luckyIterator = luckyList.iterator();

        while (luckyIterator.hasNext()) {
            returnString += luckyIterator.next() + " ";
        }
        
        return getClass().getName() + ":" + returnString;
    }

    //----- nested PositionIterator class -----
    private class PositionIterator implements Iterator<Position<LuckyNumber>> {

        private Position<LuckyNumber> cursor = luckyList.first();   // position of the next element to report
        private Position<LuckyNumber> recent = null;               // position of last reported element

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

        /**
         * Removes the element returned by most recent call to next.
         */
        @Override
        public void remove() throws IllegalStateException {
            if (recent == null) {
                throw new IllegalStateException("nothing to remove");
            }
            luckyList.remove(recent);         // remove from outer list
            recent = null;              // do not allow remove again until next is called
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
    /**
     * CHANGE THIS ACCORDING TO THE DIRECTIONS--------------------------------------------------------------------
     */
    private class PrimePositionIterator implements Iterator<Position<LuckyNumber>>{
        private Position<LuckyNumber> cursor = luckyList.first();   // position of the next element to report
        private Position<LuckyNumber> recent = null;               // position of last reported element
        /** Tests whether the iterator has a next object. */
        @Override
        public boolean hasNext( ) { return ( cursor != null ); }
        /** Returns the next position in the iterator. */
        @Override
        public Position<LuckyNumber> next( ) throws NoSuchElementException {
            // On the first call to next (i.e. when recent == null) you need to      //<<< new code
            // advance recent until it is pointing to a vowel element.                //<<< new code
            if ( recent == null )                                                    //<<< new code 
            {                                                                        //<<< new code
                while ( cursor != null && !isLuckyNumber( cursor.getElement().luckyNumber) )    //<<< new code
                    cursor = luckyList.after( cursor );                               //<<< new code
            }                                                                        //<<< new code
                
            if ( cursor == null ) throw new NoSuchElementException( "nothing left " );
            recent = cursor;
            cursor = luckyList.after( cursor );
            
            // advance cursor to the next vowel
            
            while ( cursor != null && !isLuckyNumber( cursor.getElement().luckyNumber) )
                cursor = luckyList.after( cursor );
            
            return recent;
        }
        /** Removes the element returned by most recent call to next. */
        @Override
        public void remove( ) throws IllegalStateException {
            if ( recent == null ) throw new IllegalStateException( "nothing to remove" );
            luckyList.remove( recent );         // remove from outer list
            recent = null;              // do not allow remove again until next is called
        }
    } //----- end of nested PositionIterator class -----
    
    /**
     * CHANGE THIS ACCORDING TO THE DIRECTIONS----------------------------------------------------------------------
     */
    private class EvenPositionIterator implements Iterator<Position<LuckyNumber>>{
        private Position<LuckyNumber> cursor = luckyList.first();   // position of the next element to report
        private Position<LuckyNumber> recent = null;               // position of last reported element
        /** Tests whether the iterator has a next object. */
        @Override
        public boolean hasNext( ) { return ( cursor != null ); }
        /** Returns the next position in the iterator. */
        @Override
        public Position<LuckyNumber> next( ) throws NoSuchElementException {
            // On the first call to next (i.e. when recent == null) you need to      //<<< new code
            // advance recent until it is pointing to a vowel element.                //<<< new code
            if ( recent == null )                                                    //<<< new code 
            {                                                                        //<<< new code
                while ( cursor != null && !isLuckyNumber( cursor.getElement().luckyNumber) )    //<<< new code
                    cursor = luckyList.after( cursor );                               //<<< new code
            }                                                                        //<<< new code
                
            if ( cursor == null ) throw new NoSuchElementException( "nothing left " );
            recent = cursor;
            cursor = luckyList.after( cursor );
            
            // advance cursor to the next vowel
            
            while ( cursor != null && !isLuckyNumber( cursor.getElement().luckyNumber) )
                cursor = luckyList.after( cursor );
            
            return recent;
        }
        /** Removes the element returned by most recent call to next. */
        @Override
        public void remove( ) throws IllegalStateException {
            if ( recent == null ) throw new IllegalStateException( "nothing to remove" );
            luckyList.remove( recent );         // remove from outer list
            recent = null;              // do not allow remove again until next is called
        }
    } //----- end of nested PositionIterator class -----
    //-------------------------------------------------------------------------------------------------------------
    
    //----- nested PositionIterable class -----
    private class PrimePositionIterable implements Iterable<Position<LuckyNumber>>{
        @Override
        public Iterator<Position<LuckyNumber>> iterator( ) { return new PrimePositionIterator( ); }        
    } //----- end of nested PositionIterable class -----
    
    //----- nested PositionIterable class -----
    private class EvenPositionIterable implements Iterable<Position<LuckyNumber>>{
        @Override
        public Iterator<Position<LuckyNumber>> iterator( ) { return new EvenPositionIterator( ); }        
    } //----- end of nested PositionIterable class -----
    
    /** Returns an iterable representation of the list's positions.
     * @return  */
    public Iterable<Position<LuckyNumber>> primePositions( ) {
        return new PrimePositionIterable( );  // create a new instace of the inner class
    }
    
    public Iterable<Position<LuckyNumber>> evenPositions( ) {
        return new EvenPositionIterable( );  // create a new instace of the inner class
    }
}
