package lab110.stepancj;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Calvin Stepan
 * @param <E> generic type E
 * @version 4.20.2021
 */
public class BinarySearchTree<E> extends AbstractBinaryTree<E> {
//Represent a node of binary tree  

    private static class Node<E> implements Position<E> {

        private int data;
        private Node left;
        private Node right;
        private Node parent;
        private E element;

        private Node(int data) {
            //Assign data to the new node, set left and right children to null  
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public Node getParent() {
            return parent;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        @Override
        public E getElement() {
            return element;
        }
    }

    //Represent the root of binary tree  
    private Node root;
    private final int size = 0;

    @Override
    public Position<E> root() {
        return root;
    }

    public BinarySearchTree() {
        root = null;
    }

    @Override
    public int size() {
        return size;
    }

    //insert() will add new node to the binary search tree  
    public void insert(int data) {
        //Create a new node  
        Node newNode = new Node(data);

        //Check whether tree is empty  
        if (root == null) {
            root = newNode;
        } else {
            //current node point to root of the tree  
            Node current = root, parent;

            while (true) {
                //parent keep track of the parent node of current node.  
                parent = current;

                //If data is less than current's data, node will be inserted to the left of tree  
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } //If data is greater than current's data, node will be inserted to the right of tree  
                else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    //Returns the Position of p's parent (or null if p is root)
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    //Returns the Position of p's left child (or null if no child exists)
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    //Returns the Position of p's right child (or null if no child exists)
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    //Validates the position and returns it as a node
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Not valid position type");
        }
        Node<E> node = (Node<E>) p;          //safe cast
        if (node.getParent() == node) {
            throw new IllegalArgumentException("p is no longer in the tree");
        }
        return node;
    }

    /**
     *
     * @param N the number of elements to include
     */
    public static void ascendingTree(int N) {
        BinarySearchTree ascendingTree = new BinarySearchTree();
        for (int i = 0; i < N; i++) {
            ascendingTree.insert(i);
        }
        System.out.println(ascendingTree.height(ascendingTree.root()));
    }

    /**
     *
     * @param N the number of elements to include
     */
    public static void descendingTree(int N) {
        BinarySearchTree descendingTree = new BinarySearchTree();
        for (int i = N; i > 0; i--) {
            descendingTree.insert(i);
        }
        System.out.println(descendingTree.height(descendingTree.root()));
    }

    /**
     *
     * @param N the number of elements to include
     */
    public static void randomTree(int N) {
        ArrayList<Integer> duplicates = new ArrayList<>();
        Random rand = new Random();
        BinarySearchTree randomTree1 = new BinarySearchTree();

        for (int i = 0; i < N; i++) {
            int number = rand.nextInt(N);

            //if the number has already been passed to the array, we iterate until we get a good value
            while (duplicates.contains(number)) {
                number = rand.nextInt(i);
            }
            randomTree1.insert(number);
            duplicates.add(number);
        }
        System.out.println(randomTree1.height(randomTree1.root()));
    }
}
