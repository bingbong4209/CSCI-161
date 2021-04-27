package lab111.stepancj;

import java.util.Arrays;

/**
 * The Sort Class houses various sorts used in the client, such as the simple
 * bubble sort, the enhanced bubble sort, the merge sort, quick sort, and radix
 * sort
 *
 * @author Calvin Stepan
 * @version 4.27.2021
 */
public class Sort<K> {

    /**
     * @param array the input array
     * @return the sorted array based on increasing id numbers
     */
    public static Employee[] simpleBubbleSort(Employee[] array) {
        Employee[] sortedArray = new Employee[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }

        for (Employee array1 : array) {
            for (int j = 0; j < array.length - 1; j++) {
                if (EmployeeComparator.idCompare(sortedArray[j], sortedArray[j + 1]) == 1) {
                    Employee temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
        return sortedArray;
    }

    public static Employee[] enhancedBubbleSort(Employee[] array) {
        Employee[] sortedArray = new Employee[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }

        for (Employee array1 : array) {
            for (int j = 0; j < array.length - j - 1; j++) {
                if (EmployeeComparator.idCompare(sortedArray[j], sortedArray[j + 1]) == 1) {
                    Employee temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
        return sortedArray;
    }

    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        //if array is trivially sorted
        if(n < 2) 
            return;
        int mid = n / 2;
        //change these 
        K[] S1 = Arrays.copyOfRange(S, 0, mid); //first half copy
        K[] S2 = Arrays.copyOfRange(S, mid, n); //second half copy
        //use recursion to sort
        mergeSort(S1, comp);
        mergeSort(S2, comp);
        //merge results
        merge(S1, S2, S, comp);
    }

    public static Employee[] quickSort(Employee[] array) {
        return array;
    }

    public static Employee[] radixSort(Employee[] array) {
        return array;
    }

    public static void printArray(Employee[] array) {
        for (int j = 0; j < array.length - 1; j++) {
            System.out.println(array[j].getId());
        }
    }
    
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        while(i + j < S.length) {
            if(j == S2.length || (i < S1.length && comp.compare(S1[i], S2[i]) < 0))
                S[i + j] = S1[i++]; //copy ith element of S1 and increment i
            else
                S[i + j] = S2[i++]; //copy jth element of S2 and increment j
        }
    }
}
