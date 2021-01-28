/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        for(int i: score.list) {
            score.list[i] = rand.nextInt((100 - -100 + 1)- 100);
        }
        
        score.toString();
        
        score.add(86);
        
        System.out.println(score.size());
        
        score.remove();
        
        score.get(75);
        
        System.out.println(score.getFrequencyOf(score.get(75)));
        
        score.remove(75);
        
        System.out.println(score.getFrequencyOf(score.get(75)));
        
        //System.out.println(score.getFrequencyOf(score.get(75)));

                
    }
}
