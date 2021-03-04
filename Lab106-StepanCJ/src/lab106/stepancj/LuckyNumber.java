package lab106.stepancj;

import java.util.Random;

/**
 * The LuckyNumber class assigns a lucky number to the given name
 * @author Calvin Stepan
 * @version 3.3.2021
 */
public class LuckyNumber {

    String name;
    int luckyNumber;
    String evenOrOdd;
    String primeOrNot;
    Random rand = new Random();

    /**
     * 
     * @param name the name of the person with the lucky number
     */
    public LuckyNumber(String name) {
        this.name = name;
        luckyNumber = rand.nextInt(10);
        if(isPrime(luckyNumber))
            primeOrNot = "Prime";
        else
            primeOrNot = "Not Prime";
        if(isEven(luckyNumber))
            evenOrOdd = "Even";
        else 
            evenOrOdd = "Odd";
    }

    public String getName() {
        return name;
    }

    public int getLuckyNumber() {
        return luckyNumber;
    }
    
    public String toString() {
        return getClass().getName() + ":" + name + ":" + luckyNumber;
    }
    
    public String getEvenOrOdd() {
        return evenOrOdd;
    }
    
    public String getPrimeOrNot() {
        return primeOrNot;
    }
    
    public boolean isEven(int n) {
        return (n == 2 || n == 4 || n == 6 || n == 8);
    }
    public boolean isPrime(int n) {
        return (n == 1 || n == 2 || n == 3 || n == 5 || n == 7 || n == 9);
    }
}
