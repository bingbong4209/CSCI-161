package lab106.stepancj;

/**
 * The client class contains the tests of the LuckyNumber and LuckyNumberList classes
 * @author Calvin Stepan
 * @version 3.3.2021
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LuckyNumberList list = new LuckyNumberList();
        
        list.addLuckyNumber(new LuckyNumber("James"));
        list.addLuckyNumber(new LuckyNumber("Jababy"));
        list.addLuckyNumber(new LuckyNumber("Jeremiah"));
        list.addLuckyNumber(new LuckyNumber("Jerome"));
        list.addLuckyNumber(new LuckyNumber("Gerard"));
        list.addLuckyNumber(new LuckyNumber("Gerald"));
        list.addLuckyNumber(new LuckyNumber("Harold"));
        list.addLuckyNumber(new LuckyNumber("Steve"));
        list.addLuckyNumber(new LuckyNumber("Jimmy"));
        list.addLuckyNumber(new LuckyNumber("Jillian"));
        
        //code for the defualt iterator
        System.out.println("using the default iterator" + list.toString());
        
        //code for the prime iterator
        Iterator<Position<LuckyNumber>> primeIterator = list.primePositions().iterator();
        while ( primeIterator.hasNext() )
            System.out.print( primeIterator.next().getElement().toString() + " " );
        System.out.print( "\n\n" );
        
        //code for the even iterator
         Iterator<Position<LuckyNumber>> evenIterator = list.evenPositions().iterator();
         while ( evenIterator.hasNext() )
            System.out.print( evenIterator.next().getElement().toString() + " " );
        System.out.print( "\n\n" );
    }
    
}
