package Interfaces;

/**
 * The Sort Class houses various sorts used in the client, such as the simple
 * bubble sort, the enhanced bubble sort, the merge sort, quick sort, and radix
 * sort
 *
 * @author Calvin Stepan
 * @version 4.30.2021
 * @param <K> generic type K
 */
public class Sort<K> {

    public static void simpleBubbleSort(int[] array, Comparator comp, long timeout) {
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }
        long timeoutSystem = timeout * 60 * 1000;
        long start = System.currentTimeMillis();
        long end;
        for (int array1 : array) {
            for (int j = 0; j < array.length - 1; j++) {
                if (comp.compare(sortedArray[j], sortedArray[j + 1]) == 1) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
                end = System.currentTimeMillis();
                if (end - start > timeoutSystem) {
                    throw new IllegalStateException("Sort timed out");
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
        for (K index : array) {
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
        for (int i = 0; i < array.length; i++) {
            boolean sorted = true;
            for (int j = 0; j < array.length - j - 1; j++) {
                if (comp.compare(array[j], array[j + 1]) > 0) {
                    K temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    /**
     *
     * @param <K> generic type K
     * @param S input array
     * @param comp the comparator to be used
     */
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n < 2) {
            return;
        }

        int mid = n / 2;

        K[] S1 = rangeCopy(S, 0, mid);
        K[] S2 = rangeCopy(S, mid, n);

        mergeSort(S1, comp);
        mergeSort(S2, comp);

        merge(S1, S2, S, comp);

    }

    /**
     *
     * @param <K> generic type K
     * @param S1 the first array to merge
     * @param S2 the second array to merge
     * @param S the final array with both merges
     * @param comp the comparator to be used
     */
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;

        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0)) {
                S[i + j] = S1[i++];
            } else {
                S[i + j] = S2[j++];
            }
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
        for (int i = from; i < to; i++) {
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
     * @param array the input array to be sorted
     * @param comp1 the first and most important comparator to sort the array on
     * @param comp2 the second most important comparator to sort the array on
     * @param comp3 the third most important comparator to sort the array on
     */
    public static <K> void radixSort(K[] array, Comparator<K> comp1, Comparator<K> comp2, Comparator<K> comp3) {
        mergeSort(array, comp1);
        mergeSort(array, comp2);
        mergeSort(array, comp3);
    }

}
