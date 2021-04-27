package lab111.stepancj;

/**
 * The Sort Class houses various sorts used in the client, such as the simple bubble sort,
 * the enhanced bubble sort, the merge sort, quick sort, and radix sort
 * @author Calvin Stepan
 * @version 4.27.2021
 */
public class Sort {

    public Employee[] simpleBubbleSort(Employee[] array) {
        Employee[] temp = new Employee[array.length];
        for(int i = 0; i < array.length; i++) 
            temp[i] = array[i];
        for(int j = 0; j < array.length; j++) {
            //add comparator here
        }
        return temp;
    }
    
    public Employee[] enhancedBubbleSort(Employee[] array) {
        return array;
    }
    
    public Employee[] mergeSort(Employee[] array) {
        return array;
    }
    
    public Employee[] quickSort(Employee[] array) {
        return array;
    }
    
    public Employee[] radixSort(Employee[] array) {
        return array;
    }
}
