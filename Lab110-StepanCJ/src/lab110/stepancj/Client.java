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
        
        //ascending tree
        BinarySearchTree ascendingTree = new BinarySearchTree();

        for (int i = 1; i <= 10000; i++) {
            ascendingTree.insert(i);
        }
        System.out.println("\n" + ascendingTree.height(ascendingTree.root()));
/*
        //descending tree
        BinarySearchTree descendingTree = new BinarySearchTree();

        for (int i = 10000; i > 0; i--) {
            descendingTree.insert(i);
            if (i % 1000 == 0 && i != 0) {
                System.out.println(i + " ");
            }
        }
        System.out.println("\n" + descendingTree.height(descendingTree.root()));

/*
        //random order tree 1
        BinarySearchTree randomTree1 = new BinarySearchTree();

        for (int i = 100; i > 0; i--) {
            int number = rand.nextInt(i);
            System.out.println(number);

            //if the number has already been passed to the array, we iterate until we get a good value
            if (duplicates.get(number) != 0) {
                for (Integer duplicate : duplicates) {
                    
                }
            }

            randomTree1.insert(number);
        }
        System.out.println("\n" + randomTree1.height(randomTree1.root()));
*/
    }

}
