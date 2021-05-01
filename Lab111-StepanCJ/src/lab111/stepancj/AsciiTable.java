package lab111.stepancj;

/**
 * This is the class where my Ascii Table code is kept. I use a static method so
 * you only need to import the class, not create an instance of it.
 *
 * @author Calvin Stepan
 * @version 4.30.2021
 */
public class AsciiTable {

    /**
     *
     * @param array a long[][] array representing run times in nanoseconds for
     * various structures
     * @param tableHeader the String representing the table header
     */
    public static void asciiOutput(long[][] array, String tableHeader) {
        int columnCount = array[0].length;//tells us how many cells are in the first column of our array
        int rowCapacity = array.length;
        int[] columnWidths = new int[columnCount];

        //parse each column to find out how wide each needs to be
        String result;
        for (int row = 0; row < rowCapacity; row++) {
            for (int col = 0; col < columnCount; col++) {
                result = String.format("%,d", array[row][col]);
                if (columnWidths[col] < result.length()) {
                    columnWidths[col] = result.length();
                }
            }
        }

        //use column data to construct ascii table lines
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

        //loop to make the top line of the table
        String topLine = "";
        for (int j = 0; j < lineString.length(); j++) {
            if (j == 0 || j == lineString.length() - 1) {
                topLine += "+";
            } else {
                topLine += "-";
            }
        }

        //--------Writing Table Headers and Column Headers--------
        //variables to attempt to center the table header
        int tableWidthLeft = ((lineString.length() - columnCount - 1) / 2) + 8;
        int tableWidthRight = ((lineString.length() - columnCount - 1) / 2) - 5;

        //print out Table Header
        System.out.printf("%n" + topLine + "%n");
        System.out.printf("| %" + tableWidthLeft + "s" + "%" + tableWidthRight + "s |", tableHeader, "");
        System.out.printf("%n" + lineString + "%n");

        //loop to print out the columnHeaders
        for (int c = 0; c < columnCount; c++) {
            //uses user input to create the headers
            /*int count = c + 1;
            String columnHeader = JOptionPane.showInputDialog("Please Enter a Header For Column " + count);
            if(columnHeader.length() > 8) {
                throw new IllegalArgumentException("header was too long");
            }
            
            if (c == 0) {
                System.out.printf("| %-" + columnWidths[c] + "s |", columnHeader);
            } else if (c == columnCount - 1) {
                System.out.printf(" %-" + columnWidths[c] + "s |", columnHeader);
            } else {
                System.out.printf(" %-" + columnWidths[c] + "s |", columnHeader);
            }
             */
            //predefined column headers
            int width = columnWidths[c] + 4;
            switch (c) {
                case 0:
                    System.out.printf("|%-" + width + "s|", "merge");
                    break;
                case 1:
                    System.out.printf("%-" + width + "s|", "quick");
                    break;
                case 2:
                    System.out.printf("%-" + width + "s|", "bubble");
                    break;
                case 3:
                    System.out.printf("%-" + width + "s|", "bub+");
                    break;
                case 4:
                    System.out.printf("%-" + width + "s|", "radix");
                    break;
            }
        }

        //print out the values for each test within the ascii table
        for (int row = 0; row < rowCapacity; row++) {
            System.out.printf("%n" + lineString + "%n");
            for (int col = 0; col < columnCount; col++) {
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
