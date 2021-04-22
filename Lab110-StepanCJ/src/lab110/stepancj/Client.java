package lab110.stepancj;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Calvin Stepan
 * @version 4.20.2021
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Integer> duplicates = new ArrayList<>();
        ArrayList<Integer> compareList = new ArrayList<>();
        int randomIterations = 100;

        //----------------------------------------------------------ascending tree
        BinarySearchTree ascendingTree = new BinarySearchTree();
        for (int i = 0; i < 8000; i++) {
            ascendingTree.insert(i);
        }
        System.out.println(ascendingTree.height(ascendingTree.root()));

        //------------------------------------------------------------descending tree
        BinarySearchTree descendingTree = new BinarySearchTree();
        for (int i = 8000; i > 0; i--) {
            descendingTree.insert(i);
        }
        System.out.println(descendingTree.height(descendingTree.root()));

        //---------------------------------------repeat the random tests 5 total times
        //random order tree 1
        BinarySearchTree randomTree1 = new BinarySearchTree();

        for (int i = 0; i < randomIterations; i++) {
            compareList.add(i);
        }
        //eventually change back to 1 million
        for (int i = randomIterations; i > 0; i--) {
            int number = rand.nextInt(i);
            System.out.println("index value is " + i);
            //if the number has already been passed to the array, we iterate until we get a good value
            for (int j = 0; j < duplicates.size(); j++) {
                if (duplicates.get(j) == number && duplicates.size() != 0) {
                    System.out.println("GOT A DUPLICATE at " + number);
                    number = rand.nextInt(i);
                }
            }
            for (int k = 0; k < duplicates.size(); k++) {
                for (int L = 0; L < compareList.size(); L++) {
                    if (compareList.get(L) == duplicates.get(k)) {
                        break;
                    }
                }
            }
            randomTree1.insert(number);
            duplicates.add(number);
            System.out.println("Next number in the tree is " + number);
        }
        //System.out.println(randomTree1.height(randomTree1.root()));

    }

}
