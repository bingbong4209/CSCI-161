package lab111.stepancj;

/**
 * The Sort Class houses various sorts used in the client, such as the simple
 * bubble sort, the enhanced bubble sort, the merge sort, quick sort, and radix
 * sort
 *
 * @author Calvin Stepan
 * @version 4.29.2021
 * @param <K> generic type K
 */
public class Sort<K> implements Comparator<K> {

    //fix this later
    @Override
    public int compare(Object k1, Object k2) {
        if(k1.equals(k2))
            return 1;
        else if(k1.equals(k2))
            return 0;
        else 
            return -1;
    }

    /**
     * 
     * @param <K> generic type K
     * @param array input array to be sorted
     */
    public static <K> void simpleBubbleSort(K[] array) {
        K[] sortedArray = (K[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }

        for (K array1 : array) {
            for (int j = 0; j < array.length - 1; j++) {
                if (compare(sortedArray[j], sortedArray[j + 1]) == 1) {
                    K temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 
     * @param <K> generic type K
     * @param array input array to be sorted
     */
    public static <K> void enhancedBubbleSort(K[] array) {
        K[] sortedArray = (K[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }

        for (K array1 : array) {
            for (int j = 0; j < array.length - j - 1; j++) {
                if (compare(sortedArray[j], sortedArray[j + 1]) == 1) {
                    K temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
    }

    /*
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        //if array is trivially sorted
        if (n < 2) {
            return;
        }
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
     */

    /**
     *
     * @param <K> generic type K
     * @param S the input queue to be sorted
     * @param comp the comparator to compare the two adjacent elements
     */
    public static <K> void quickSort(Queue<K> S, Comparator<K> comp) {
        int n = S.size();
        if (n < 2) {
            return;                             //if the queue is trivially sorted
        }        
        //divide
        K pivot = S.first();
        Queue<K> L = new LinkedQueue<>();
        Queue<K> E = new LinkedQueue<>();
        Queue<K> G = new LinkedQueue<>();
        while (!S.isEmpty()) {                  //divide original int L, E, and G     
            K element = S.dequeue();
            int c = comp.compare(element, pivot);
            if (c < 0) {
                L.enqueue(element);
            } else if (c == 0) {
                E.enqueue(element);
            } else {
                G.enqueue(element);
            }
        }
        //conquer
        quickSort(L, comp);
        quickSort(G, comp);
        //concatenate resutls
        while (!L.isEmpty()) {
            S.enqueue(L.dequeue());
        }
        while (!E.isEmpty()) {
            S.enqueue(E.dequeue());
        }
        while (!G.isEmpty()) {
            S.enqueue(G.dequeue());
        }
    }

    public static Employee[] radixSort(Employee[] array) {
        return array;
    }

    public static <K> void printArray(K[] array) {
        for (int j = 0; j < array.length - 1; j++) {
            System.out.println(array[j].to);
        }
    }

    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[i]) < 0)) {
                S[i + j] = S1[i++]; //copy ith element of S1 and increment i
            } else {
                S[i + j] = S2[i++]; //copy jth element of S2 and increment j
            }
        }
    }
}
