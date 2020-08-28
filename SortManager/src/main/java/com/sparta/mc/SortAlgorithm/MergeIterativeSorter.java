package com.sparta.mc.SortAlgorithm;

import com.sparta.mc.Printer.ArrayPrinter;

public class MergeIterativeSorter implements Sorter {

    @Override
    //Sorts a int array using an iterative implementation of the Merge Sort algorithm
    public void sortArray(int[] array) {

        //Use a 2-d array to store all the sub-arrays to be produced
        int[][] arrayValues = new int[array.length][1];

        //Populate 2d array values
        for (int i = 0;i < array.length;i++) {

            //Make each array value a singleton array, holding only that value
            int[] tempArray = {array[i]};
            arrayValues[i] = tempArray;
        }

        //Holder variable for updating the new arrays, after merging
        int[][] lastArrayValues = arrayValues;

        //Loop which
        for (int i = 0;i < getCyclesNeeded(array.length);i++) {

            //Sets up variable for merging all the sub-lists
            int newLength = getCycleLength(lastArrayValues.length);
            int[][] tempArrayValues = new int[newLength][1];

            //Populate the newly created 2-d array by merging values from the previous one
            for (int j = 0;j < newLength;j++) {

                //Edge case where we have one list left over (2-d array length is odd)
                if ((2*j) + 1 >= lastArrayValues.length ) {
                    tempArrayValues[tempArrayValues.length-1] = lastArrayValues[2*j];
                    break;
                }

                //Merge two sub-lists and add it to the 2d-array
                tempArrayValues[j] = mergeArray(lastArrayValues[2*j],lastArrayValues[(2*j)+1]);

            }
            //Overwrite old 2d-array with the new one
            lastArrayValues = tempArrayValues;
        }

        //Copy values from the newly sorted list into the array given by the parameter
        for (int i = 0;i < array.length;i++) {
            //Sorted array is stored in first row of 2d-array
            array[i] = lastArrayValues[0][i];
        }
    }

    //Helper method for calculating the total cycles needed in the for-loop
    private static int getCyclesNeeded(int length) {
        for (int i = 0;i <= length;i++) {

            //If the condition is satisfied, return the current index
            if ((Math.pow(2, i)) > length) {
                return i;
            }
        }

        return 0;
    }

    //Helper method for getting the length of the cycle
    private static int getCycleLength(int arrayLength) {
        if (arrayLength%2 == 1) {
            return (arrayLength/2) + 1;
        }
        return (arrayLength/2);
    }

    //Helper method for merging two already sorted lists
    private static int[] mergeArray(int[] array1, int[] array2) {
        //Initialising the array to return
        int returnArrayLength = array1.length + array2.length;
        int[] returnArray = new int[returnArrayLength];

        //Counters for each of the arrays
        int counter1 = 0;
        int counter2 = 0;

        while (counter1+counter2 < returnArrayLength) {
            //Check if array1 if full, then just bring values from array2
            if (counter1 == array1.length) {
                returnArray[counter1+counter2] = array2[counter2];
                counter2++;

                //Check if array2 if full, then just bring values from array1
            } else if (counter2 == array2.length) {
                returnArray[counter2+counter1] = array1[counter1];
                counter1++;

                //Check if the value from array1 is smaller
            } else if (array1[counter1] <= array2[counter2] && (counter1 < array1.length)) {
                returnArray[counter1 + counter2] = array1[counter1];
                counter1++;

                //Check if the value from array2 is smaller
            } else if (array2[counter2] < array1[counter1] && (counter2 < array2.length)){
                returnArray[counter1 + counter2] = array2[counter2];
                counter2++;
            }
        }

        return returnArray;
    }

}
