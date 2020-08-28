package com.sparta.mc.SortAlgorithm;

public class MergeSorter implements Sorter {

    @Override
    //Sorts a int array based on the recursive implementation of the Merge Sort algorithm
    public void sortArray(int[] array) {

        int[] returnArray = beginRecursion(array);

        //Copy the values from the returned array into the passed in array
        for  (int i = 0;i < array.length;i++) {
            array[i] = returnArray[i];
        }
    }

    //Helper method which starts the recursive call with the parameters needed
    private int[] beginRecursion(int[] array) {

        //Termination case
        if (array.length == 1) {
            return array;
        } else {
            //Sort left and sort right side
            int[] left = beginRecursion(splitArrayLeft(array));
            int[] right = beginRecursion(splitArrayRight(array));

            //Merge the sorted left and right sides
            return mergeArray(left, right);
        }

    }

    //Helper method which returns the left half of an array after splitting in the midpoint
    private static int[] splitArrayLeft(int[] array) {

        //Termination case
        if (array.length == 1) {
            return array;
        }

        //Initialising set-up variables
        int returnLength = array.length/2;
        int[] returnArray = new int[returnLength];

        //Fills in the array after that index, before the midpoint
        for (int i = 0;i < returnLength;i++) {
            returnArray[i] = array[i];
        }

        return returnArray;
    }

    //Helper method which returns the right half of an array after splitting in the midpoint
    private static int[] splitArrayRight(int[] array) {

        //Termination case
        if (array.length == 1) {
            return array;
        }

        //Initialising set-up variables
        int returnLength = getReturnLength(array);
        int[] returnArray = new int[returnLength];

        //Fills in the array after that index, before the midpoint
        for (int i = 0;i < returnLength;i++) {
            returnArray[i] = array[i+(array.length-returnLength)];
        }

        return returnArray;
    }

    //Helper method which gets the midpoint in an array
    private static int getReturnLength(int[] array) {
        if (array.length%2 == 1) {
            return (array.length/2 + 1);
        }
        return array.length/2;
    }

    //Helper method which combines to sorted lists into one sorted list
    private static int[] mergeArray(int[] array1, int[] array2) {
        //Initialising the array to return
        int returnArrayLength = array1.length + array2.length;
        int[] returnArray = new int[returnArrayLength];

        //Counters for each of the arrays
        int counter1 = 0;
        int counter2 = 0;

        while (counter1 + counter2 < returnArrayLength) {
            //Check if array1 if full, then just bring values from array2
            if (counter1 == array1.length) {
                returnArray[counter1 + counter2] = array2[counter2];
                counter2++;

                //Check if array2 if full, then just bring values from array1
            } else if (counter2 == array2.length) {
                returnArray[counter2 + counter1] = array1[counter1];
                counter1++;

                //Check if the value from array1 is smaller
            } else if (array1[counter1] <= array2[counter2] && (counter1 < array1.length)) {
                returnArray[counter1 + counter2] = array1[counter1];
                counter1++;

                //Check if the value from array2 is smaller
            } else if (array2[counter2] < array1[counter1] && (counter2 < array2.length)) {
                returnArray[counter1 + counter2] = array2[counter2];
                counter2++;
            }
        }

        return returnArray;
    }

}
