package lab106.stepancj;

/**
 * The client class contains the tests of the LuckyNumber and LuckyNumberList classes
 * We add 10 LuckyNumber objects to our list and iterate over them with all 3 iterators(Default, Even, Prime)
 *
 * @author Calvin Stepan
 * @version 3.4.2021
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create our list
        LuckyNumberList list = new LuckyNumberList();

        //add our objects
        list.addLuckyNumber(new LuckyNumber("Lorde"));
        list.addLuckyNumber(new LuckyNumber("James"));
        list.addLuckyNumber(new LuckyNumber("Mary"));
        list.addLuckyNumber(new LuckyNumber("Grandpa"));
        list.addLuckyNumber(new LuckyNumber("Scat Man"));
        list.addLuckyNumber(new LuckyNumber("Batman"));
        list.addLuckyNumber(new LuckyNumber("Robin"));
        list.addLuckyNumber(new LuckyNumber("Steve"));
        list.addLuckyNumber(new LuckyNumber("Bing"));
        list.addLuckyNumber(new LuckyNumber("Cosby"));

        //Code for the Default Iterator(uses the Default Iterator)
        Iterator<Position<LuckyNumber>> defaultIterator = list.defaultpositions().iterator();
        System.out.println("Lucky Number List Contents Using The Default Iterator");
        while (defaultIterator.hasNext()) {
            printEntry(defaultIterator.next().getElement());
        }

        //Code for the Prime Iterator(uses the Prime Iterator)
        Iterator<Position<LuckyNumber>> primeIterator = list.primePositions().iterator();
        System.out.println("\nLucky Number List Contents Using The Prime Iterator");
        while (primeIterator.hasNext()) {
            printEntry(primeIterator.next().getElement());
        }

        //Code for the Even Iterator(uses the Even Iterator)
        Iterator<Position<LuckyNumber>> evenIterator = list.evenPositions().iterator();
        System.out.println("\nLucky Number List Contents Using The Even Iterator");
        while (evenIterator.hasNext()) {
            printEntry(evenIterator.next().getElement());
        }

    }

    /**
     * 
     * @param n LuckyNumber object to be passed in
     * using n, we print out:
     * The name
     * The luckyNumber
     * Whether it's even or odd
     * Whether it's prime or not prime
     */
    public static void printEntry(LuckyNumber n) {
        System.out.printf("%-8s", n.getName());
        System.out.printf("%5s  ", n.getLuckyNumber());
        System.out.printf("%-5s \t", n.getEvenOrOdd());
        System.out.printf("%-10s \n", n.getPrimeOrNot());
    }
}
