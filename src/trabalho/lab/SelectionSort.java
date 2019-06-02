package trabalho.lab;

class SelectionSort {
    Counter counter;
    long startTime, endTime;

    public SelectionSort(Counter counter) {
        this.counter = counter;
    }

    public Counter sort(Number[] allData) {
        this.startTime = System.currentTimeMillis();

        runSort(allData);

        endTime = System.currentTimeMillis();
        counter.time = endTime - startTime;

        return this.counter;
    }

    public void runSort (Number[] allData) {
        for(int i = 1; i < allData.length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < allData.length - 1; j++) {
                if(allData[j].value < allData[min].value) {
                    min = j;
                    Number x = allData[min];
                    allData[min] = allData[i];
                    allData[i] = x;
                    counter.swaps++;
                }
                counter.comparisons++;
            }
        }
    }
}