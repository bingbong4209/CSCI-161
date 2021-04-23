package lab110.stepancj;

/**
 *
 * @author Calvin Stepan
 * @version 4.23.2021
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int setIterations = 8000;
        int randomIterations = 100000;
        long[][] dataTable = new long[5][2];

        BinarySearchTree.ascendingTree(setIterations);

        BinarySearchTree.descendingTree(setIterations);

        for (int i = 0; i < 5; i++) {
            BinarySearchTree.randomTree(randomIterations);
        }
    }
    /**
     * ----Ascii table values---- 
     * number of items 
     * height of tree 
     * do the random iterations at 100000
     * 
     * //probably gonna be on the test
     * in java, are parameters passed by value or reference
     * does it matter if they are primitives or objects
     * write a java code that illustrates that answer
     * 
     * for lab111, make sure to pass in a copy of the array for sorting methods/algorithms and not pass in the original array
     */

}
