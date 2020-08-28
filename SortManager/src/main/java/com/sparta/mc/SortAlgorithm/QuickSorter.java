package com.sparta.mc.SortAlgorithm;

public class QuickSorter implements Sorter {

    @Override
    //Sorts array using the Quick Sort algorithm
    public void sortArray(int[] array) {

        beginRecursion(array, 0, array.length-1);
    }

    public void beginRecursion(int[] array, int lowerIndex, int higherIndex) {

        //Termination case
        if (!(lowerIndex < higherIndex)) {
            return;
        }

        //Calculating indices
        int pivotIndex = higherIndex;
        int lastI = (lowerIndex-1);

        //Iterating through list and making swaps when items are bigger/smaller than pivot
        for (int i = lowerIndex;i < higherIndex;i++) {
            if (array[i] < array[pivotIndex]) {
                lastI++;
                swap(array, lastI, i);
            }
        }

        //Setting up conditions for next recursive call
        swap(array, lastI+1, higherIndex);
        beginRecursion(array, lowerIndex, lastI);
        beginRecursion(array, lastI+2, higherIndex);
    }

    //Helper method to swap two elements in an array
    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
