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
            long[][] finalTable = new long[16][3];
            int minA = 30;
            int maxA = 45;
            double loadFactor = .5;

            int numCollisions;//total # of collisions
            int maxCollisions;//max # of collisions for a given key
            /*
            String inputFile = JOptionPane.showInputDialog("Please Enter an absolute filepath");
            Scanner scan = new Scanner(inputFile);
            */
            //Scanner scan = new Scanner(new File("C:\\Users\\User\\Downloads\\words.txt"));
            Scanner scan = new Scanner(new File("C:\\Users\\Calvin\\Downloads\\words.txt"));

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

            //------------Code to compress the hash codes and compare collisions
            //determine the base p-value
            int pValue = HashCode.pValueCompute(wordList.size());
            //test for various p values (in this case, testing for +/- 5 off the p-value
            int initialP = pValue - 5;
            long[][] compressionTable = new long[11][3];
            for (int p = pValue - 5; p <= pValue + 5; p++) {
                System.out.println("computing using the p value " + p);
                ArrayList<Entry<Integer, Integer>> hashCollisions = new ArrayList<>();

                for (String hashKey : wordList) {
                    int hashCode = HashCode.polynomialHashCode(hashKey, p);
                    
                    int aValue = HashCode.find_A_Or_B(p, "a");
                    int bValue = HashCode.find_A_Or_B(p, "b");
                    
                    int compressedCode = HashCode.madCompression(hashCode, wordList.size(), p, aValue, bValue);
                    
                    int k;
                    for (k = 0; k < hashCollisions.size(); k++) {
                        if (hashCollisions.get(k).getKey().equals(compressedCode)) {
                            break;
                        }
                    }

                    if (k == hashCollisions.size()) {
                        Entry<Integer, Integer> newCollision = new Entry<>(compressedCode, 0);
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
                System.out.println("p: " + p + "\tTotal Collisions: " + numCollisions + "\t   Max collisions: " + maxCollisions);
                int row = p - initialP;
                compressionTable[row][0] = p;
                compressionTable[row][1] = numCollisions;
                compressionTable[row][2] = maxCollisions;
            }
            AsciiTable.asciiOutput(compressionTable, "Compression");

        } catch (FileNotFoundException fnfe) {
            System.err.println(fnfe.toString());
        }
    }
}
