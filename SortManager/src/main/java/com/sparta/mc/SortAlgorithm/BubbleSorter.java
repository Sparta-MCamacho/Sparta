package com.sparta.mc.SortAlgorithm;

public class BubbleSorter implements Sorter {

    @Override
    //Sorts the array using the Bubble Sort algorithm
    public void sortArray(int[] inputArray) {

        //Setting up the double loop
        for (int i = 0;i < inputArray.length-1;i++) {
            for (int j = 0;j < inputArray.length-1;j++) {
                if (inputArray[j] > inputArray[j+1]) {

                    //If the left is bigger than right, swap them
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j+1];
                    inputArray[j+1] = temp;
                }
            }
        }
    }

    //Sorts any array which can be compared
    public static void sortGenericArray(Comparable[] array) {

        for (int i = 0;i < array.length-1;i++) {
            for (int j = 0;j < array.length-1;j++) {
                if (array[j].compareTo(array[j+1]) > 0) {

                    //If the left is bigger than right, swap them
                    Comparable temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

    }


}
