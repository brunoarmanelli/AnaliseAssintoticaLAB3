package trabalho.lab;

class BinarySearch {
    Counter counter;
    long startTime, endTime;

    public BinarySearch(Counter counter) {
        this.counter = counter;
    }

    public Counter run(Number[] allData) {
        this.startTime = System.currentTimeMillis();

        int searchKey = 0;

        runBinarySearchIteratively(allData, searchKey, 0, allData.length);

        endTime = System.currentTimeMillis();
        counter.time = endTime - startTime;

        return this.counter;
    }

    public int runBinarySearchIteratively(Number[] allData, int key, int low, int high) {
        int index = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (allData[mid].value < key) {
                counter.comparisons++;
                low = mid + 1;
            } else if (allData[mid].value > key) {
                counter.comparisons++;
                high = mid - 1;
            } else if (allData[mid].value == key) {
                counter.comparisons++;
                index = mid;
                break;
            }
        }
        return index;
    }
}