package lab111.stepancj;

/**
 * The Client class is where we test our various sorts from the sort class
 * Each sort is then run against an array of 50,000 employees and run times of each sort are compared
 * The resulting run times are then formatted into an ASCII table
 * @author Calvin Stepan
 * @version 4.27.2021
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
        long[][] sortRunTimes = new long[1][4]; 
        
        //sort on name using the merge sort
        Comparator<Employee> mergeCompare = new NameComparator();
        start = System.currentTimeMillis();
        Sort.mergeSort(employeeArray, mergeCompare);
        end = System.currentTimeMillis();
        runTime = end - start;
        System.out.println("Merge Sort Run Time: " + runTime);
        
        //sort on dept using the quick sort
        Comparator<Employee> quickCompare = new DeptComparator();
        LinkedQueue<Employee> employeeQueue = Sort.arrayToQueue(employeeArray);
        start = System.currentTimeMillis();
        Sort.quickSort(employeeQueue, quickCompare);
        end = System.currentTimeMillis();
        runTime = end - start;
        System.out.println("Quick Sort Run Time: " + runTime);
        
        //sort on id using the bubble sort (both types)
        //simple bubble sort
        Comparator<Employee> bubbleCompare = new IDComparator();
        start = System.currentTimeMillis();
        Sort.simpleBubbleSort(bubbleArray, bubbleCompare);
        end = System.currentTimeMillis();
        runTime = end - start;
        sortRunTimes[0][3] = runTime;
        System.out.println("Simple Bubble SortRun Time: " + runTime);
        
        //enhanced bubble sort
        Comparator<Employee> betterBubbleCompare = new IDComparator();
        start = System.currentTimeMillis();
        Sort.simpleBubbleSort(bubbleArray, betterBubbleCompare);
        end = System.currentTimeMillis();
        runTime = end - start;
        System.out.println("Enhanced Bubble Sort Run Time: " + runTime);
        
        /**
         * sort using the radix sort
         * All employees are sorted by department
         * Within a department grouping all the employees are sorted by hire date
         * Within a department and hire date grouping all the employees are sorted by their name
         */
        
        //Print out the time it takes to run each sort in an ASCII table
    }
        //you can run the n log n sorts at 50k, but the n^2 sorts at 10k
    //picking the radix sort means you need a stable sort with n log n time
}
