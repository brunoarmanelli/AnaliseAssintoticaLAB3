package trabalho.lab;

import java.util.Random;

public class RandomList {

    public static Number[] create(int size) {
        Random rand = new Random();
        Number[] numberList = new Number[size];

        for (int i = 0; i < size; i++) {
            numberList[i] = new Number(rand.nextInt(size * 2));
        }

        return numberList;
    }
}
