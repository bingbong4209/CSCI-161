package lab109.stepancj;

/**
 * This is the class where my Ascii Table code is kept. I use a static method so
 * you only need to import the class, not create an instance of it.
 *
 * @author Calvin Stepan
 * @version 3.1.2021
 */
public class AsciiTable {

    public static void asciiHeaders() {
        System.out.println("+------+----------+------+");
        System.out.print("|   a  | Total    | Max  |");        
    }

    /**
     *
     * @param array a long[][] array representing runtimes in nanoseconds for
     * various structures
     */
    public static void asciiOutput(long[][] array) {
        int capacity = array[0].length;//tells us how many cells are in the first column of our array
        int rowCapacity = array.length;
        int[] columnWidths = new int[capacity];

        //parse each column to find out how wide each needs to be
        String result;
        for (int row = 0; row < rowCapacity; row++) {
            for (int col = 0; col < capacity; col++) {
                result = String.format("%,d", array[row][col]);
                if (columnWidths[col] < result.length()) {
                    columnWidths[col] = result.length();
                }
            }
        }

        //use column data to construct out ascii table lines
        String lineString = "";
        for (int row = 0; row < columnWidths.length; row++) {
            if (row == 0) {
                lineString = "+";
            }
            for (int i = 0; i < columnWidths[row]; i++) {
                lineString += "-";
            }
            lineString += "----";
            lineString += "+";
        }
        
        //print out headers

        //print out the values for each test within the ascii table
        for (int row = 0; row < rowCapacity; row++) {
            System.out.printf("%n" + lineString + "%n");
            for (int col = 0; col < capacity; col++) {
                if (col == 0) {
                    System.out.printf("|  %," + columnWidths[col] + "d  |", array[row][col]);
                } else {
                    System.out.printf("  %," + columnWidths[col] + "d  |", array[row][col]);
                }
            }
        }
        System.out.printf("%n" + lineString + "%n");
    }
}
