package lab108.stepancj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Calvin Stepan
 */
public class ShuntingYard {

    public boolean isValid(String expression) {
        /**
         * find a way to determine if it is valid or not
         */
    }
    
    public static int[] parseInputFile(String filePath) throws FileNotFoundException {
        System.out.println("File Path: " + filePath);

        Scanner scan = new Scanner(new File(filePath));
        while (scan.hasNext()) {
            /**
             * need to repeat the loop for each line but have it stop before it goes to a new line
             * evaluate each line one at a time
             */
            String token = scan.next();

            try {
                int inInt = Integer.parseInt(token);
                Bag.add(inInt);
                System.out.println("New int added: " + inInt);
            } catch (NumberFormatException nfe) {
                System.out.println("Number Formatting Error");
            }
        }

        
        return A;
    }
}
