package lab110.stepancj;

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
        int setIterations = 8000;
        int randomIterations = 10000;

        BinarySearchTree.ascendingTree(setIterations);
        
        BinarySearchTree.descendingTree(setIterations);
        
        //for(int i = 0; i < 5; i++)
            BinarySearchTree.randomTree(randomIterations);
    }

}
