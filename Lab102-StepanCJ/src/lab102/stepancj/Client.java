package lab102.stepancj;

import java.util.Random;

/**
 *
 * @author Calvin Stepan
 */
public class Client {
    public static void main(String[] args) {
        Scores score = new Scores(100);
        Random rand = new Random();
        
        //fill the array with random numbers between -100 and 100
        for(int i = 0; i < 99; i++) {
            score.add(rand.nextInt(200) - 100);
        }
        
        System.out.print(score.toString());
        
        score.add(86);
        
        System.out.println("Array Size: " + score.size());
        
        score.remove();
        
        score.get(75);
        
        System.out.println("Number at index 75: " + score.get(75));
        
        System.out.println("Frequency of number at index 75: " + score.getFrequencyOf(score.get(75)));
        
        score.remove(score.get(75));

        System.out.println("New frequency of number at index 75: " + score.getFrequencyOf(score.get(75)));

        System.out.println("Frequency of 86: " + score.getFrequencyOf(86));
        
        System.out.println("Does the array contain 86? " + score.contains(86));
 
    }
}
