package com.sparta.mc.SortAlgorithm;

public class SelectionSorter implements Sorter {

    @Override
    //Sorts int array based on the Selection Sort algorithm
    public void sortArray(int[] array) {

        for (int i = 0;i < array.length;i++) {

            //Finds smallest number then swaps with current index
            int minimumValueIndex = findMinimumValueIndex(array, i);
            swap(array, i, minimumValueIndex);
        }

    }

    //Helper method which swaps two elements in an array
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    //Helper method which finds index of smallest value in array
    private static int findMinimumValueIndex(int[] array, int currentIndex) {

        int smallestInt = array[currentIndex];
        int index = currentIndex;

        for (int i = currentIndex;i < array.length;i++) {
            if (array[i] < smallestInt) {
                smallestInt = array[i];
                index = i;
            }
        }
        return index;
    }

}
