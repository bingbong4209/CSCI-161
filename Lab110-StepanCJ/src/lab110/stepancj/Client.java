package lab110.stepancj;

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
        int[] duplicates = new int[10000];
        /*
        //ascending tree
        BinarySearchTree ascendingTree = new BinarySearchTree();

        for (int i = 0; i < 10000; i++) {
            ascendingTree.insert(i + 1);
            if (i % 1000 == 0 && i != 0) {
                System.out.println(i + " ");
            }
        }
        System.out.println("\n" + ascendingTree.height(ascendingTree.root()));

        //descending tree
        BinarySearchTree descendingTree = new BinarySearchTree();

        for (int i = 10000; i > 0; i--) {
            descendingTree.insert(i);
            if (i % 1000 == 0 && i != 0) {
                System.out.println(i + " ");
            }
        }
        System.out.println("\n" + descendingTree.height(descendingTree.root()));

        //random order tree 1*/
        BinarySearchTree randomTree1 = new BinarySearchTree();

        for (int i = 10000; i > 0; i--) {
            int number = rand.nextInt(i);
            //if the number has already been passed to the array, we iterate until we get a good value
            while(duplicates[number] == number) {
                number = rand.nextInt(i);
                System.out.println("Collision at " + i);
            }
            duplicates[number] = number;
            
            randomTree1.insert(number);
            if (i % 1000 == 0 && i != 0) {
                System.out.println(i + " ");
            }
        }
        System.out.println("\n" + randomTree1.height(randomTree1.root()));
    }

}
