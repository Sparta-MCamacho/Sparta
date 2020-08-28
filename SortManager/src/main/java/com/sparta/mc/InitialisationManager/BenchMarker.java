package com.sparta.mc.InitialisationManager;

import com.sparta.mc.Printer.ArrayPrinter;
import com.sparta.mc.Printer.FormatPrinter;
import com.sparta.mc.SortAlgorithm.Sorter;
import com.sparta.mc.SortAlgorithm.SorterFactory;

//Class responsible for running the sorting algorithms and timing them
public class BenchMarker {

    //Takes an algorithm choice from the menu and the desired length and runs a test
    public static void runTestCase(int algorithmChoice, int arrayLength) {

        FormatPrinter.printTestStartMessage(algorithmChoice, MenuController.MENU_OPTIONS[algorithmChoice-1]);

        int[] unSortedArray = RandomArrayBuilder.generateRandomArray(arrayLength);
        int[] sortedArray = RandomArrayBuilder.cloneArray(unSortedArray);
        Sorter arraySorter = SorterFactory.getSorter(MenuController.MENU_OPTIONS[algorithmChoice-1], unSortedArray);

        long algorithmRunTime =timeSortAlgorithm(arraySorter, sortedArray);

        FormatPrinter.beforeSortMessage();
        ArrayPrinter.printIntArray(unSortedArray);
        FormatPrinter.afterSortMessage();
        ArrayPrinter.printIntArray(sortedArray);
        FormatPrinter.printAlgorithmRunTimeMessage(algorithmRunTime);

    }

    //Similar to runTestCase() but does not print the entire array to screen
    //(Useful for large arrays)
    public static void runSilentTestCase(int algorithmChoice, int arrayLength) {

        FormatPrinter.printTestStartMessage(algorithmChoice, MenuController.MENU_OPTIONS[algorithmChoice-1]);

        int[] unSortedArray = RandomArrayBuilder.generateRandomArray(arrayLength);
        int[] sortedArray = RandomArrayBuilder.cloneArray(unSortedArray);
        Sorter arraySorter = SorterFactory.getSorter(MenuController.MENU_OPTIONS[algorithmChoice-1], sortedArray);

        long algorithmRunTime =timeSortAlgorithm(arraySorter, sortedArray);

        FormatPrinter.silentBeforeSortMessage(unSortedArray, unSortedArray.length-20);
        FormatPrinter.silentAfterSortMessage(sortedArray, sortedArray.length-20);
        FormatPrinter.printAlgorithmRunTimeMessage(algorithmRunTime);
    }

    public static void runAllTestCases(int arrayLength) {

        FormatPrinter.printCompareAllTestCaseMessage();

        double[] sortTimes = new double[MenuController.MENU_OPTIONS.length-2];
        String[] sorterNames = new String[MenuController.MENU_OPTIONS.length-2];

        int[] unSortedArray = RandomArrayBuilder.generateRandomArray(arrayLength);
        int[] sortedArray = RandomArrayBuilder.cloneArray(unSortedArray);


        for (int i = 1;i <= MenuController.MENU_OPTIONS.length-2;i++) {
            Sorter arraySorter = SorterFactory.getSorter(MenuController.MENU_OPTIONS[i-1], unSortedArray);
            double runTime = (double) timeSortAlgorithm(arraySorter, sortedArray)/1000000000;
            sortTimes[i-1] = runTime;
            sorterNames[i-1] = MenuController.MENU_OPTIONS[i-1];
            sortedArray = RandomArrayBuilder.cloneArray(unSortedArray);
        }

        orderSortTimes(sortTimes, sorterNames);

        FormatPrinter.printSorterResults(sortTimes, sorterNames);

    }

    //Times how long a sorter takes to sort a given array
    public static long timeSortAlgorithm(Sorter arraySorter, int[] unSortedArray) {
        long startTime = System.nanoTime();
        arraySorter.sortArray(unSortedArray);
        long runTime = System.nanoTime() - startTime;
        return runTime;
    }

    //Orders the sort times from lowest to highest
    public static void orderSortTimes(double[] sortTimes, String[] sorterNames) {

        for (int i = 0;i < sortTimes.length-1;i++) {
            for (int j = 0;j < sortTimes.length-1;j++) {
                if (sortTimes[j] > sortTimes[j+1]) {

                    //If the left is bigger than right, swap them
                    double doubleToSwap = sortTimes[j];
                    sortTimes[j] = sortTimes[j+1];
                    sortTimes[j+1] = doubleToSwap;

                    String stringToSwap = sorterNames[j];
                    sorterNames[j] = sorterNames[j+1];
                    sorterNames[j+1] = stringToSwap;
                }
            }
        }

    }
}
