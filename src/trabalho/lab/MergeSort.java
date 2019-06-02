package trabalho.lab;

class MergeSort {

    Counter counter;
    long startTime, endTime;

    public MergeSort(Counter counter) {
        this.counter = counter;
    }

    public Counter sort(Number[] allData) {
        this.startTime = System.currentTimeMillis();

        runSort(allData, 0, allData.length  - 1);

        endTime = System.currentTimeMillis();
        counter.time = endTime - startTime;
        
        return this.counter;
    }

    public void runSort(Number[] allData, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;
 
            // Sort first and second halves
            runSort(allData, l, m);
            runSort(allData , m + 1, r);
 
            // Merge the sorted halves
            merge(allData, l, m, r);
        }
    }

    void merge(Number[] allData, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        Number L[] = new Number [n1];
        Number R[] = new Number [n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = allData[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = allData[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].value <= R[j].value) {
                allData[k] = L[i];
                i++;
            } else {
                allData[k] = R[j];
                j++;
            }
            this.counter.comparisons++;
            this.counter.swaps++;
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            this.counter.swaps++;
            allData[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            this.counter.swaps++;
            allData[k] = R[j];
            j++;
            k++;
        }
    }
}