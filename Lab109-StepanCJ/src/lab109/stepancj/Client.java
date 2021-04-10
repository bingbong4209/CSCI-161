package lab109.stepancj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Calvin Stepan
 */
public class Client {

    public static void main(String[] args) {
        try {
            ArrayList<Iterable<Integer>> list = new ArrayList<>();
            long[][] finalTable = new long[16][3];
            int minA = 30;
            int maxA = 45;
            double loadFactor = .5;

            int numCollisions = 0;//total # of collisions
            int maxCollisions = 0;//max # of collisions for a given key

            //String inputFile = JOptionPane.showInputDialog("Please Enter an absolute filepath");
            //Scanner scan = new Scanner(inputFile);
            Scanner scan = new Scanner(new File("C:\\Users\\Calvin\\Downloads\\words.txt"));
            //Scanner scan = new Scanner(new File("C:\\Users\\User\\Downloads\\words.txt"));

            ArrayList<String> wordList = new ArrayList<>();

            //scan in the words to an arrayList
            while (scan.hasNext()) {
                wordList.add(scan.next());
            }
            
            System.out.println("Word list size: " + wordList.size());
            
            //Code to create the hash codes and compare collisions
            //test for various a values
            for (int a = minA; a < maxA + 1; a++) {
                System.out.println("computing using the a value " + a);
                ArrayList<Entry<Integer, Integer>> hashCollisions = new ArrayList<>();

                for (String hashKey : wordList) {
                    int hashCode = HashCode.polynomialHashCode(hashKey, a);
                    
                    int k;
                    for (k = 0; k < hashCollisions.size(); k++) {
                        if (hashCollisions.get(k).getKey().equals(hashCode)) {
                            break;
                        }
                    }

                    if (k == hashCollisions.size()) {
                        Entry<Integer, Integer> newCollision = new Entry<>(hashCode, 0);
                        hashCollisions.add(k, newCollision);
                    } else {
                        Entry<Integer, Integer> entry1 = hashCollisions.get(k);
                        int counter = entry1.getValue();
                        counter++;
                        entry1.setValue(counter);
                        hashCollisions.set(k, entry1);
                    }
                }
                numCollisions = 0;
                maxCollisions = -1;

                for (int h = 0; h < hashCollisions.size(); h++) {
                    Entry<Integer, Integer> entry = hashCollisions.get(h);
                    int value = entry.getValue();
                    numCollisions += value;
                    if (maxCollisions < value) {
                        maxCollisions = value;
                    }
                }
                    System.out.println("a: " + a + "\tTotal Collisions: " + numCollisions + "\t   Max collisions: " + maxCollisions);
                    int row = a - 30;
                    finalTable[row][0] = a;
                    finalTable[row][1] = numCollisions;
                    finalTable[row][2] = maxCollisions;
            }
            AsciiTable.asciiOutput(finalTable, "HashCode");
            
            /*
            //Code to compress the hash codes and compare collisions
            //test for various a values
            for (int a = minA; a < maxA + 1; a++) {
                System.out.println("computing using the a value " + a);
                ArrayList<Entry<Integer, Integer>> hashCollisions = new ArrayList<>();

                for (String hashKey : wordList) {
                    int hashCode = HashCode.polynomialHashCode(hashKey, a);

                    int k;
                    for (k = 0; k < hashCollisions.size(); k++) {
                        if (hashCollisions.get(k).getKey().equals(hashCode)) {
                            break;
                        }
                    }

                    if (k == hashCollisions.size()) {
                        Entry<Integer, Integer> newCollision = new Entry<>(hashCode, 0);
                        hashCollisions.add(k, newCollision);
                    } else {
                        Entry<Integer, Integer> entry1 = hashCollisions.get(k);
                        int counter = entry1.getValue();
                        counter++;
                        entry1.setValue(counter);
                        hashCollisions.set(k, entry1);
                    }
                }
                numCollisions = 0;
                maxCollisions = -1;

                for (int h = 0; h < hashCollisions.size(); h++) {
                    Entry<Integer, Integer> entry = hashCollisions.get(h);
                    int value = entry.getValue();
                    numCollisions += value;
                    if (maxCollisions < value) {
                        maxCollisions = value;
                    }
                }
                    System.out.println("a: " + a + "\tTotal Collisions: " + numCollisions + "\t   Max collisions: " + maxCollisions);
                    int row = a - 30;
                    finalTable[row][0] = a;
                    finalTable[row][1] = numCollisions;
                    finalTable[row][2] = maxCollisions;
            }
            AsciiTable.asciiOutput(finalTable, "Compression");
            */
        } catch (FileNotFoundException fnfe) {
            System.err.println(fnfe.toString());
        }

        //look for at most 6 collisions per value
        /**
         * column 1: a-value column 2: numCollisions column 3: maxCollisions
         */
        /**
         * abstract map unsorted table map word count
         */
        //uses the entry class to do the assignment
    }
}
