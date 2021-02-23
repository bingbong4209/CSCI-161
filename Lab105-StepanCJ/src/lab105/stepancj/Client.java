package lab105.stepancj;

/**
 *
 * @author Calvin Stepan
 * @version 2.23.2021
 */
public class Client {

    public static void main(String[] args) {
        int a = 5;
        int b = 23;
        double c = 12.34;
        int n = 1000000;

        int lineLength = 20;
        int columns = 2;
        String lineString = "";
        String junctions = "+";
        
        System.out.printf("| %,9d  |", a);
        System.out.printf("| %,9d  |\t\n", a);
        System.out.printf("| %,9d  |", b);
        System.out.printf("| %,9d  |\t\n", b);
        System.out.printf("| %,9.2f  |", c);
        System.out.printf("| %,9.2f  |\t\n", c);
        System.out.printf("| %,9d  |", n);
        System.out.printf("| %,9d  |\t\n", n);

        for (int i = 0; i < lineLength / columns; i++) {
            lineString += "-";
        }
        System.out.printf(lineString + junctions);
    }
}
