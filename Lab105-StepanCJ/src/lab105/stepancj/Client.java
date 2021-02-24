package lab105.stepancj;

/**
 *
 * @author Calvin Stepan
 * @version 2.23.2021
 */
public class Client {

    public static void main(String[] args) {
        int n = 1000000;
        int capacity = 5;
        int[][] array = new int[capacity][capacity];

        array[0][0] = 100;
        array[1][0] = 1000;
        array[2][0] = 10000;
        array[3][0] = 100000;
        array[4][0] = 1000000;

        array[0][1] = 200;
        array[1][1] = 2000;
        array[2][1] = 20000;
        array[3][1] = 200000;
        array[4][1] = 2000000;
        
        array[0][2] = 300;
        array[1][2] = 3000;
        array[2][2] = 30000;
        array[3][2] = 300000;
        array[4][2] = 3000000;
        
        array[0][3] = 400;
        array[1][3] = 4000;
        array[2][3] = 40000;
        array[3][3] = 400000;
        array[4][3] = 4000000;
        
        array[0][4] = 500;
        array[1][4] = 5000;
        array[2][4] = 50000;
        array[3][4] = 500000;
        array[4][4] = 5000000;

        int spaces = 9;
        int lineLength = spaces + 4;
        String lineString = "+";
        String tableFormat = "";
        for(int i = 0; i < lineLength; i++)
            lineString += "-";
        
        for (int i = 0; i < capacity; i++) {
            tableFormat += lineString;
            if(i == capacity - 1)
                tableFormat += "+";
        }
        
        for (int j = 0; j < capacity; j++) {
            System.out.printf("\n" + tableFormat + "\n");
            for (int i = 0; i < capacity; i++) {
                if(i == 0) 
                System.out.printf("|  %,9d  |", array[j][i]);
                else
                System.out.printf("  %,9d  |", array[j][i]);
            }
        }
        System.out.printf("\n" + tableFormat + "\n");
    }
}
