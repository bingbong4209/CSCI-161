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
        long start;
        long end;
        long runTime;
        //initial employee array setup
        int size = 5000;
        Employee[] employeeArray = new Employee[size];
        for (int i = 0; i < employeeArray.length; i++) {
            employeeArray[i] = new Employee();
        }
        long[][] sortRunTimes = new long[1][4]; 
        //Sort.printArray(employeeArray);
        //System.out.println("\n\n");
        
        //sort on name using the merge sort
        
        //sort on dept using the quick sort
        
        //sort on id using the bubble sort (both types)
        //simple bubble sort
        start = System.currentTimeMillis();
        Sort.simpleBubbleSort(employeeArray);
        //Sort.printArray(simpleBubbleArray);
        end = System.currentTimeMillis();
        runTime = end - start;
        sortRunTimes[0][3] = runTime;
        System.out.println("Run Time: " + runTime + "\n\n");
        
        //enhanced bubble sort
        start = System.currentTimeMillis();
        Sort.simpleBubbleSort(employeeArray);
        //Sort.printArray(enhancedBubbleArray);
        end = System.currentTimeMillis();
        runTime = end - start;
        System.out.println("Run Time: " + runTime);
        /**
         * sort using the radix sort
         * All employees are sorted by department
         * Within a department grouping all the employees are sorted by hire date
         * Within a department and hire date grouping all the employees are sorted by their name
         */
        
        //Print out the time it takes to run each sort in an ASCII table
    }

}
