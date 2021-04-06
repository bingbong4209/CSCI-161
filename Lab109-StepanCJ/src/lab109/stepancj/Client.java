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
        try {
            File wordsDoc = new File("C:\\Users\\Calvin\\Downloads\\words.txt");
            int a = 33;
            Scanner scan = new Scanner(wordsDoc);
            
            while(scan.hasNext()) {
                String keyValue = scan.next();
                System.out.println(HashCode.polynomialHashCode(keyValue, a));
            }
        } catch (FileNotFoundException fnfe) {

        }
    }
}
