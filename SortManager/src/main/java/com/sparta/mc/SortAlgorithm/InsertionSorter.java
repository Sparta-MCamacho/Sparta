package com.sparta.mc.SortAlgorithm;

public class InsertionSorter implements Sorter {

    @Override
    public void sortArray(int[] array) {
        //Setting up main loop to sort each item individually
        for (int i = 0;i < array.length;i++) {

            //Start from beginning of list until current position
            for (int j = 0;j < i;j++) {

                //If a int is smaller than the current, make a swap and update
                if (array[i] < array[j]) {
                    int temp = array[i];

                    //Update all successors with the new value and break to move onto next position
                    for (int k = i-1; k >= j;k--) {
                        array[k+1] = array[k];
                    }
                    array[j] = temp;
                    break;
                }
            }
        }
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}

