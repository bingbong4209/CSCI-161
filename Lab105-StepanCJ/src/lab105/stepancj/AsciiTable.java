/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab105.stepancj;

/**
 *
 * @author Calvin Stepan
 */
public class AsciiTable {

    public static void asciiOutput(long[][] array) {
        int capacity = array[0].length;//tells us how many cells are in the first column of our array
        int rowCapacity = array.length;
        int[] columnWidths = new int[capacity];

        String result;
        for (int row = 0; row < rowCapacity; row++) {
            for (int col = 0; col < capacity; col++) {
                result = String.format("%,d", array[row][col]);
                if (columnWidths[col] < result.length()) {
                    columnWidths[col] = result.length();
                }
            }
        }
        
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
