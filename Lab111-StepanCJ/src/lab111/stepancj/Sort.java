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
public class Sort<K> {

    /**
     * 
     * @param <K> generic type K
     * @param array input array to be sorted
     * @param comp the comparator used to compared the two objects
     */
    
    public static <K> void simpleBubbleSort(K[] array, Comparator<K> comp) {
        K[] sortedArray = (K[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }

        for (K array1 : array) {
            for (int j = 0; j < array.length - 1; j++) {
                if (comp.compare(sortedArray[j], sortedArray[j + 1]) == 1) {
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
     * @param array input array to be converted to a linkedQueue
     * @return the corresponding linkedQueue for the given array
     */
    public static <K> LinkedQueue<K> arrayToQueue(K[] array) {
        LinkedQueue<K> newQueue = new LinkedQueue<>();
        for(K index: array) {
            newQueue.enqueue(index);
        }
        return newQueue;
    }

    /**
     * 
     * @param <K> generic type K
     * @param array input array to be sorted
     * @param comp the input comparator
     */
    public static <K> void enhancedBubbleSort(K[] array, Comparator<K> comp) {
        K[] sortedArray = (K[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }

        for (K array1 : array) {
            for (int j = 0; j < array.length - j - 1; j++) {
                if (comp.compare(sortedArray[j], sortedArray[j + 1]) == 1) {
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
     * @param S the generic input array
     * @param comp the input comparator
     */
    /*public static <K> K[] mergeSort(K[] S, Comparator<K> comp) {
        int iterator = 0;
        int n = S.length;
        //if array is trivially sorted
        if (n < 2) {
            return S;
        }
        int mid = n / 2;

        K[] S1 = rangeCopy(S, 0, mid); //first half copy
        K[] S2 = rangeCopy(S, mid, n); //second half copy
        //use recursion to sort
        mergeSort(S1, comp);
        mergeSort(S2, comp);
        //merge results
        merge(S1, S2, S, comp);
        return S;
    }
    /*
      public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0)) {
                S[i + j] = S1[i++]; //copy ith element of S1 and increment i
            } else {
                S[i + j] = S2[j++]; //copy jth element of S2 and increment j
            }
        }
    }*/
    public static <K> K[] mergeSort( K[] S, Comparator<K> comp ){
          int n = S.length;
          if ( n < 2 ) return S;
          
          int mid = n / 2;
          
          //K[] S1 = Arrays.copyOfRange( S, 0, mid );
          //K[] S2 = Arrays.copyOfRange( S, mid, n );          

          K[] S1 = rangeCopy( S, 0, mid );
          K[] S2 = rangeCopy( S, mid, n );         
          
          mergeSort( S1, comp );
          mergeSort( S2, comp );
          
          merge( S1, S2, S, comp );                    
          
          return S;
      }
      
      public static <K> void merge( K[] S1, K[] S2, K[] S, Comparator<K> comp )
      {
          int i = 0, j = 0;
          
          while ( i + j < S.length )
          {
              if ( j == S2.length || ( i < S1.length && comp.compare( S1[i], S2[j] ) < 0 ) )
                  S[i+j] = S1[i++];
              else
                  S[i+j] = S2[j++];                          
          }          
      }

    /**
     * 
     * @param <K> generic type K
     * @param array the input array to be partitioned
     * @param from the index to partition the array from
     * @param to the index to end the partition of the array
     * @return the partitioned array
     */
    public static <K> K[] rangeCopy(K[] array, int from, int to) {
        K[] range = (K[]) new Object[to - from];
        for(int i = from; i < to - 1; i++) {
            range[i - from] = array[i];
        }
        return range;
    }
    
    /**
     *
     * @param <K> generic type K
     * @param queue the input queue to be sorted
     * @param comp the comparator to compare the two adjacent elements
     */
    public static <K> void quickSort(Queue<K> queue, Comparator<K> comp) {
        int n = queue.size();
        if (n < 2) {
            return;                           //if the queue is trivially sorted
        }        
        //divide
        K pivot = queue.first();
        Queue<K> L = new LinkedQueue<>();
        Queue<K> E = new LinkedQueue<>();
        Queue<K> G = new LinkedQueue<>();
        while (!queue.isEmpty()) {             //divide original int L, E, and G     
            K element = queue.dequeue();
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
            queue.enqueue(L.dequeue());
        }
        while (!E.isEmpty()) {
            queue.enqueue(E.dequeue());
        }
        while (!G.isEmpty()) {
            queue.enqueue(G.dequeue());
        }
    }

    /**
     * 
     * @param <K> generic type K
     * @param array
     * @param comp 
     */
    public static <K> void radixSort(K[] array, Comparator<K> comp) {

    }

    public static <K> void printArray(K[] array) {
        for (int j = 0; j < array.length - 1; j++) {
            System.out.println(array[j].toString());
        }
    }

  
}
