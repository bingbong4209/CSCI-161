package lab111.stepancj;

/**
 * The Client class is where we test our various sorts from the sort class
 * Each sort is then run against an array of 50,000 employees and run times of each sort are compared
 * The resulting run times are then formatted into an ASCII table
 * @author Calvin Stepan
 * @version 4.30.2021
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start, end, runTime;
        
        //initial employee array setup
        int size = 50000;
        Employee[] employeeArray = new Employee[size];
        Employee[] bubbleArray = new Employee[5000];
        for (int i = 0; i < employeeArray.length; i++) {
            employeeArray[i] = new Employee();
        }
        for(int j = 0; j < bubbleArray.length; j++) {
            bubbleArray[j] = new Employee();
        }
        
        //output array with run times
        long[][] sortRunTimes = new long[1][5]; 
        
        //sort on name using the merge sort
            //start by copying the array to not change anything about it
            Employee[]temp = new Employee[size];
            for(int k = 0; k < temp.length; k++)
                temp[k] = employeeArray[k];

            Comparator<Employee> mergeCompare = new NameComparator();
            start = System.currentTimeMillis();
            Sort.mergeSort(temp, mergeCompare);//problem line
            end = System.currentTimeMillis();
            runTime = end - start;
            sortRunTimes[0][0] = runTime;
        
        //sort on dept using the quick sort
            for(int k = 0; k < temp.length; k++)
               temp[k] = employeeArray[k];
           Comparator<Employee> quickCompare = new DeptComparator();
           LinkedQueue<Employee> employeeQueue = Sort.arrayToQueue(employeeArray);
           start = System.currentTimeMillis();
           Sort.quickSort(employeeQueue, quickCompare);
           end = System.currentTimeMillis();
           runTime = end - start;
           sortRunTimes[0][1] = runTime;
        
        //sort on id using the bubble sort (both types)
        Employee[] tempBubble = new Employee[bubbleArray.length];
            //simple bubble sort
             for(int k = 0; k < tempBubble.length; k++)
                tempBubble[k] = bubbleArray[k];
            Comparator<Employee> bubbleCompare = new IDComparator();
            start = System.currentTimeMillis();
            Sort.simpleBubbleSort(tempBubble, bubbleCompare);
            end = System.currentTimeMillis();
            runTime = end - start;
            sortRunTimes[0][2] = runTime;

            //enhanced bubble sort
             for(int k = 0; k < tempBubble.length; k++)
                tempBubble[k] = bubbleArray[k];
            Comparator<Employee> betterBubbleCompare = new IDComparator();
            start = System.currentTimeMillis();
            Sort.enhancedBubbleSort(tempBubble, betterBubbleCompare);
            end = System.currentTimeMillis();
            runTime = end - start;
            sortRunTimes[0][3] = runTime;
        
        //sort on multiple things using the radix sort
            //start by making a copy of the original array
             for(int k = 0; k < temp.length; k++)
                temp[k] = employeeArray[k];
             //define the three comparators to sort the array on
            Comparator<Employee> radix1Compare = new DeptComparator();
            Comparator<Employee> radix2Compare = new HiredComparator();
            Comparator<Employee> radix3Compare = new NameComparator();
            start = System.currentTimeMillis();
            Sort.radixSort(temp, radix1Compare, radix2Compare, radix3Compare);
            end = System.currentTimeMillis();
            runTime = end - start;
            sortRunTimes[0][4] = runTime;
        
        //Print out the time it takes to run each sort in an ASCII table
        AsciiTable.asciiOutput(sortRunTimes, "Run Times (ms)");
    }
}
