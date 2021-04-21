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
         BinarySearchTree tree = new BinarySearchTree();
         
         for(int i = 0; i < 10000; i++) {
             tree.insert(i + 1);
             if(i % 1000 == 0 && i != 0)
                System.out.println(i + " ");
         }
         System.out.println("\n" + tree.height(tree.root()));
         
    }
    
}
