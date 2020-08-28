package com.sparta.mc.SorterTesters;

import com.sparta.mc.SortAlgorithm.BinarySorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySortTester {

    int[] positiveUnsortedArray = {13, 65, 8, 17, 90, 42, 64}; //Un-ordered positive numbers case
    int[] positiveSortedArray =   {8, 13, 17, 42, 64, 65, 90};

    int[] positiveAndNegativeUnsortedArray = {15, -6, 35, -27, 87, 0}; //Un-ordered positive and negative case
    int[] positiveAndNegativeSortedArray =   {-27, -6, 0, 15, 35, 87};

    int[] alreadySortedPositiveArray =      {1, 4, 14, 36, 68, 97, 120}; //Already sorted array case
    int[] cloneAlreadySortedPositiveArray = {1, 4, 14, 36, 68, 97, 120};

    //Large positive case
    int[] largePositiveUnsortedArray = {43, 77, 9, 38, 65, 90, 24, 14, 26, 48, 41, 34, 3, 46, 18, 28, 57, 60, 84, 50, 99};
    int[] largePositiveSortedArray =   {3, 9, 14, 18, 24, 26, 28, 34, 38, 41, 43, 46, 48, 50, 57, 60, 65, 77, 84, 90, 99};

    //Large positive and negative case
    int[] largePositiveAndNegativeUnsortedArray = {43, -77, 9, 38, -65, 90, -24, -14, 26, -48, -41, 34, -3, 46, -18, 28, 0, 57, 60, -84, 50, -99};
    int[] largePositiveAndNegativeSortedArray =   {-99, -84, -77, -65, -48, -41, -24, -18, -14, -3, 0, 9, 26, 28, 34, 38, 43, 46, 50, 57, 60, 90};

    //Duplicate and positive values case
    int[] positiveDuplicateArray =      {77, 77, 77, 77, 77, 77, 77, 77, 77, 77, 77};
    int[] clonePositiveDuplicateArray = {77, 77, 77, 77, 77, 77, 77, 77, 77, 77, 77};

    //Duplicate and negative values case
    int[] negativeDuplicateArray =      {-88, -88, -88, -88, -88, -88, -88, -88, -88, -88, -88};
    int[] cloneNegativeDuplicateArray = {-88, -88, -88, -88, -88, -88, -88, -88, -88, -88, -88};

    @Test
    void testSortsPositiveArray() {
        BinarySorter sorter = new BinarySorter(positiveUnsortedArray);
        sorter.sortArray(positiveUnsortedArray);
        Assertions.assertArrayEquals(positiveSortedArray, positiveUnsortedArray);
    }

    @Test
    void testPositiveAndNegativeArray() {
        BinarySorter sorter = new BinarySorter(positiveAndNegativeUnsortedArray);
        sorter.sortArray(positiveAndNegativeUnsortedArray);
        Assertions.assertArrayEquals(positiveAndNegativeSortedArray, positiveAndNegativeUnsortedArray);
    }

    @Test
    void testAlreadySortedArray() {
        BinarySorter sorter = new BinarySorter(cloneAlreadySortedPositiveArray);
        sorter.sortArray(cloneAlreadySortedPositiveArray);
        Assertions.assertArrayEquals(alreadySortedPositiveArray, cloneAlreadySortedPositiveArray);
    }

    @Test
    void testLargePositiveArray() {
        BinarySorter sorter = new BinarySorter(largePositiveUnsortedArray);
        sorter.sortArray(largePositiveUnsortedArray);
        Assertions.assertArrayEquals(largePositiveSortedArray, largePositiveUnsortedArray);
    }

    @Test
    void testLargePositiveAndNegativeArray() {
        BinarySorter sorter = new BinarySorter(largePositiveAndNegativeUnsortedArray);
        sorter.sortArray(largePositiveAndNegativeUnsortedArray);
        Assertions.assertArrayEquals(largePositiveAndNegativeSortedArray, largePositiveAndNegativeUnsortedArray);
    }

    @Test
    void testPositiveDuplicateArray() {
        BinarySorter sorter = new BinarySorter(clonePositiveDuplicateArray);
        sorter.sortArray(clonePositiveDuplicateArray);
        Assertions.assertArrayEquals(positiveDuplicateArray, clonePositiveDuplicateArray);
    }

    @Test
    void testNegativeDuplicateArray() {
        BinarySorter sorter = new BinarySorter(cloneNegativeDuplicateArray);
        sorter.sortArray(cloneNegativeDuplicateArray);
        Assertions.assertArrayEquals(negativeDuplicateArray, cloneNegativeDuplicateArray);
    }

}
