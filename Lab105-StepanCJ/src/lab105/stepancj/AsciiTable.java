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
        //int commaCount = 0;
        //int negative = 0;
        //long smallestValue = 0;
        //int spaces;
        int capacity = array[0].length;//tells us how many cells are in the first column of our array
        //long largestValue = 0;

        int[] columnWidths = new int[capacity];

        String result;
        for (int row = 0; row < capacity; row++) {
            for (int col = 0; col < capacity; col++) {
                result = String.format("%,d", array[row][col]);
                if (columnWidths[col] < result.length()) {
                    columnWidths[col] = result.length();
                }
                /*
                if(array[j][i] > largestValue)
                    largestValue = array[j][i];
                if(array[j][i] < smallestValue)
                    smallestValue = array[j][i];
                 */
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
        
        for (int row = 0; row < capacity; row++) {
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
        /*
        String largestInt = "" + largestValue;
        String smallestInt = "" + smallestValue;
        String value = largestInt;
        if(largestInt.length() < smallestInt.length())
            value = smallestInt;
        
        if(value.length() > 3 && value.length() < 7)
            commaCount = 1;
        else if(value.length() > 6 && value.length() < 10)
            commaCount = 2;
        else if(value.length() > 9 && value.length() < 13)
            commaCount = 3;
        else if(value.length() > 12 && value.length() < 16)
            commaCount = 4;
        if(smallestValue < 0)
            negative = 1;
         */

        /*spaces = value.length() + commaCount + negative;
        int lineLength = spaces + 4;
        
        String tableFormat = "";
        for(int i = 0; i < lineLength; i++)
            lineString += "-";
        
        for (int i = 0; i < capacity; i++) {
            tableFormat += lineString;
            if(i == capacity - 1)
                tableFormat += "+";
        }     
         */
        
    }

//    public static void addTime(int index1, int index2, long time, long[][] array) {
//        array[index1][index2] = time;
//    }
}
