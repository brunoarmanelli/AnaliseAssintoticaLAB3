package trabalho.lab;

public class Task {

    // Table of colours
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void printOnScreen(Counter taskCounter, String method, int size) {
        String osName = System.getProperty("os.name");

        if(osName.contains("windows")) {
            System.out.println(method + " - " + size);
            System.out.println(
                "[" + taskCounter.time + " ms]\t"
                + "[" + taskCounter.swaps + " swaps]\t"
                + "[" + taskCounter.comparisons + " comparisons]\t" 
                );
        } else {
            System.out.println(method + " - " + size);
            System.out.println(
                ANSI_CYAN + "[" + taskCounter.time + " ms]" + ANSI_RESET
                + ANSI_CYAN + " [" + taskCounter.swaps + " swaps]" + ANSI_RESET 
                + ANSI_CYAN + " [" + taskCounter.comparisons + " comparisons]\t" + ANSI_RESET 
                );
        }
    }

    public static void merge(Number[] list, int size) {
        Number[] newList = list.clone();

        Counter taskCounter = new Counter();
        MergeSort sorting = new MergeSort(taskCounter);
        taskCounter = sorting.sort(newList);
        printOnScreen(taskCounter, "Merge Sort", size);
    }


    public static void selection(Number[] list, int size) {
        Number[] newList = list.clone();

        Counter taskCounter = new Counter();
        SelectionSort sorting = new SelectionSort(taskCounter);
        taskCounter = sorting.sort(newList);
        printOnScreen(taskCounter, "Selection Sort", size);
    }

    public static void maxmin(Number[] list, int size) {
        Number[] newList = list.clone();

        Counter taskCounter = new Counter();
        MaxMin finder = new MaxMin(taskCounter);
        taskCounter = finder.run(newList);
        printOnScreen(taskCounter, "Max Min", size);
    }

    public static void binary(Number[] list, int size) {
        Number[] newList = list.clone();

        Counter taskCounter = new Counter();
        BinarySearch search = new BinarySearch(taskCounter);
        taskCounter = search.run(newList);
        printOnScreen(taskCounter, "Binary Search", size);
    }


    public static void main (String[] args) {
        int[] listSizes = {1024, 131072, 262144, 524288, 1048576};


        for(int size : listSizes) {
            Number[] list = RandomList.create(size);

            merge(list, size);
            selection(list, size);
            maxmin(list, size);
            binary(list, size);
        }

    }
}