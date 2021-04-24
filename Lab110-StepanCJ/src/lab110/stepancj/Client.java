package lab110.stepancj;

import java.util.ArrayList;
import java.util.Random;

/**
 * This is the Client class for Lab 110. In the client, I create 3 different types of search trees:
 * 1) ascending order search tree
 * 2) descending order search tree
 * 3) random order search tree
 * I then repeat the random order search tree 4 more times and then put the sizes and heights of each into an ascii table
 *
 * @author Calvin Stepan
 * @version 4.23.2021
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variables to hold numebr of iterations for each type of tree insert
        int setIterations = 8000;//8000 was when I stopped getting an overflow error
        int randomIterations = 100000;//100000 runs much faster than 1000000 for my code so I used it instead
        long[][] dataTable = new long[7][2];
        ArrayList<Integer> duplicates = new ArrayList<>();
        Random rand = new Random();

        //column 0 is the number of items in the tree, column 1 is the height of the tree
        //Ascending Order Tree
        BinarySearchTree ascendingTree = new BinarySearchTree();
        for (int i = 0; i < setIterations; i++) {
            ascendingTree.insert(i);
        }
        dataTable[0][0] = ascendingTree.size();
        dataTable[0][1] = ascendingTree.height(ascendingTree.root());

        //Descending Order Tree
        BinarySearchTree descendingTree = new BinarySearchTree();
        for (int i = setIterations; i > 0; i--) {
            descendingTree.insert(i);
        }
        dataTable[1][0] = descendingTree.size();
        dataTable[1][1] = descendingTree.height(descendingTree.root());

        //Random Order Trees
        for (int row = 2; row < 7; row++) {
            BinarySearchTree randomTree = new BinarySearchTree();
            for (int i = 0; i < randomIterations; i++) {
                int number = rand.nextInt();

                //if the number has already been passed to the array, we iterate until we get a good value
                while (duplicates.contains(number)) {
                    number = rand.nextInt();
                }
                randomTree.insert(number);
                duplicates.add(number);
            }
            dataTable[row][0] = randomTree.size();
            dataTable[row][1] = randomTree.height(randomTree.root());
        }
        //output all the data into an ascii table
        AsciiTable.asciiOutput(dataTable, "BST Data");
    }
    /**
     *
     * //probably gonna be on the test in java, are parameters passed by value
     * or reference does it matter if they are primitives or objects write a
     * java code that illustrates that answer
     *
     * for lab111, make sure to pass in a copy of the array for sorting
     * methods/algorithms and not pass in the original array
     */

}
