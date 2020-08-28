package com.sparta.mc.SortAlgorithm;

public class SimpleSorter implements Sorter{
    @Override
    public void sortArray(int[] array) {
        for (int i =0;i < array.length;i++) {
           array[i] = 77;
        }
    }
}
