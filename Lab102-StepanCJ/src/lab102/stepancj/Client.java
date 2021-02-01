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
        
        for(int i = 0; i < 99; i++) {
            score.add(rand.nextInt(200) - 100);
        }
        
        score.toString();
        
        score.add(86);
        System.out.println("\n" + score.size());
        
        score.remove();
        
        score.get(75);
        System.out.println(score.get(75));

        
        System.out.println(score.getFrequencyOf(score.get(75)) + "\n");
        
        score.remove(score.get(75));

        System.out.println(score.getFrequencyOf(score.get(75)));

        System.out.println(score.getFrequencyOf(86));
        
        System.out.println(score.contains(86));
 
    }
}
