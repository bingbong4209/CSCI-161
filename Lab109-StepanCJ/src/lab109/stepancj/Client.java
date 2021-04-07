package lab109.stepancj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Calvin Stepan
 */
public class Client {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            //File wordsDoc = new File("C:\\Users\\Calvin\\Downloads\\words.txt");
            File wordsDoc = new File("C:\\Users\\User\\Downloads\\words.txt");
            int a = 33;
            Scanner scan = new Scanner(wordsDoc);
            int i = 0;

            while (scan.hasNext()) {
                String keyValue = scan.next();
                System.out.println(HashCode.polynomialHashCode(keyValue, a));
                list.add(i, HashCode.polynomialHashCode(keyValue, a));
                i++;
            }

            for (int j = 0; j < i; j++) {
                int compare = list.get(j);
                int counter = 0;
                for (int k = 0; k < i; k++) {
                    if (compare == list.get(k)) {
                        counter++;
                    }
                    //somehow save counter value
                }
                System.out.println("collision count: " + counter);
            }
        } catch (FileNotFoundException fnfe) {

        }
        //look for at most 6 collisions per value
        /*
        System.out.println(HashCode.polynomialHashCode("Stop", 33));
        list.add(0, HashCode.polynomialHashCode("Stop", 33));
        System.out.println(HashCode.polynomialHashCode("Tops", 33));
        list.add(1, HashCode.polynomialHashCode("Tops", 33));
        System.out.println(HashCode.polynomialHashCode("Pots", 33));
        list.add(2, HashCode.polynomialHashCode("Pots", 33));
         */
    }
}
