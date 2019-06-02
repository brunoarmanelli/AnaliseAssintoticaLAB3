package trabalho.lab;

class MaxMin {
    Counter counter;
    long startTime, endTime;

    public MaxMin(Counter counter) {
        this.counter = counter;
    }

    public Counter run(Number[] allData) {
        this.startTime = System.currentTimeMillis();

        runMaxMin(allData);

        endTime = System.currentTimeMillis();
        counter.time = endTime - startTime;

        return this.counter;
    }

    public void runMaxMin (Number[] allData) {
        int maxValue = allData[0].value;
        int minValue = allData[0].value;

        for(int i = 1; i < allData.length; i++) {

            counter.comparisons++;

            if(allData[i].value > maxValue) {
                maxValue = allData[i].value;
            } else {
                minValue = allData[i].value;
            }
        }
    }
}