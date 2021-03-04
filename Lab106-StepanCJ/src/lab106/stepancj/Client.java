package lab106.stepancj;

/**
 * The client class contains the tests of the LuckyNumber and LuckyNumberList
 * classes
 *
 * @author Calvin Stepan
 * @version 3.3.2021
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LuckyNumberList list = new LuckyNumberList();

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

        //Code for the Default Iterator(uses the toString() method)
        Iterator<Position<LuckyNumber>> defaultIterator = list.positions().iterator();
        System.out.println("Lucky Number List Contents Using The Default Iterator");
        while (defaultIterator.hasNext()) {
            printEntry(defaultIterator.next().getElement());
        }

        //Code for the Prime Iterator
        Iterator<Position<LuckyNumber>> primeIterator = list.primePositions().iterator();
        System.out.println("\nLucky Number List Contents Using The Prime Iterator");
        while (primeIterator.hasNext()) {
            printEntry(primeIterator.next().getElement());
        }

        //Code for the Prime Iterator
        Iterator<Position<LuckyNumber>> evenIterator = list.evenPositions().iterator();
        System.out.println("\nLucky Number List Contents Using The Even Iterator");
        while (evenIterator.hasNext()) {
            printEntry(evenIterator.next().getElement());
        }

    }

    public static void printEntry(LuckyNumber n) {
        System.out.printf("%-8s", n.getName());
        System.out.printf("%5s  ", n.getLuckyNumber());
        System.out.printf("%-5s \t", n.getEvenOrOdd());
        System.out.printf("%-10s \n", n.getPrimeOrNot());
    }
}
