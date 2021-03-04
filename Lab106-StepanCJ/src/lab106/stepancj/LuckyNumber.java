package lab106.stepancj;

import java.util.Random;

/**
 * The LuckyNumber class assigns a lucky number to the given name
 * The lucky number is between 0 and 9 inclusive
 * There are also tests included to determine if it is a prime, even, or odd number and variables to store those values
 * 
 * @author Calvin Stepan
 * @version 3.4.2021
 */
public class LuckyNumber {

    String name;
    int luckyNumber;
    String evenOrOdd;
    String primeOrNot;
    Random rand = new Random();

    /**
     * The Overload Constructor for the LuckyNumber class
     * @param name the String name of the person with the lucky number
     * Given a String name, the constructor assigns the LuckyNumber object a random number 0-9 inclusive
     * It then determines if it is prime or not, and odd or even
     */
    public LuckyNumber(String name) {
        this.name = name;               
        luckyNumber = rand.nextInt(10); //generates a random integer from 0-9 inclusive to be the Lucky Number
        if(isPrime(luckyNumber))        //check if the number is prime and assign it the appropriate String value
            primeOrNot = "Prime";
        else
            primeOrNot = "Not Prime";
        if(isEven(luckyNumber))         //check if the number is even or odd and assign it the appropriate String value
            evenOrOdd = "Even";
        else 
            evenOrOdd = "Odd";
    }

    /**
     * 
     * @return String name of the LuckyNumber object
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return int LuckyNumber of the LuckyNumber object
     */
    public int getLuckyNumber() {
        return luckyNumber;
    }
    
    /**
     * 
     * @return the class name, along with the String name and int LuckyNumber of the object
     */
    public String toString() {
        return getClass().getName() + ":" + name + ":" + luckyNumber;
    }
    
    /**
     * 
     * @return String evenOrOdd that tells us whether the lucky number of the object is even or odd
     */
    public String getEvenOrOdd() {
        return evenOrOdd;
    }
    
    /**
     * 
     * @return String primeOrNot that tells us whether the lucky number of the object is prime or not prime
     */
    public String getPrimeOrNot() {
        return primeOrNot;
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
}
