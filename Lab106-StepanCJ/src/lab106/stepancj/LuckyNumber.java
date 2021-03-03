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
    Random rand = new Random(10);

    /**
     * 
     * @param name the name of the person with the lucky number
     */
    public LuckyNumber(String name) {
        this.name = name;
        luckyNumber = rand.nextInt(10);
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
}
