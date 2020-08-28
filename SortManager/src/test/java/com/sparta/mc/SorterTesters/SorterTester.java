package com.sparta.mc.SorterTesters;

import com.sparta.mc.SortAlgorithm.Sorter;
import org.junit.jupiter.api.Assertions;

public class SorterTester {

    public Sorter sorter;

    int[] positiveUnsortedArray = {13, 65, 8, 17, 90, 42, 64}; //Unordered positive numbers case
    int[] positiveSortedArray = {8, 13, 17, 42, 64, 65, 90};

    int[] positiveAndNegativeUnsortedArray = {15, -6, 35, -27, 87, 0}; //Unordered positive and negative case
    int[] positiveAndNegativeSortedArray = {-27, -6, 0, 15, 35, 87};

    int[] alreadySortedPositiveArray =  {1, 4, 14, 36, 68, 97, 120};
    int[] cloneAlreadySortedPositiveArray = {1, 4, 14, 36, 68, 97, 120};

    void testSortsPositiveArray() {
        sorter.sortArray(positiveUnsortedArray);
        Assertions.assertArrayEquals(positiveSortedArray, positiveUnsortedArray);
    }

    void testPositiveAndNegativeArray() {
        sorter.sortArray(positiveAndNegativeUnsortedArray);
        Assertions.assertArrayEquals(positiveAndNegativeSortedArray, positiveAndNegativeSortedArray);
    }

    void testAlreadySortedArray() {
        sorter.sortArray(cloneAlreadySortedPositiveArray);
        Assertions.assertArrayEquals(alreadySortedPositiveArray, cloneAlreadySortedPositiveArray);
    }

    void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    Sorter getSorter() {
        return sorter;
    }
}
