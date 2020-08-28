package com.sparta.mc.Printer;

//Class for printing strings concerned with the format of the output
public class FormatPrinter {

    //Simple method for separating test cases
    public static void printLineBreaker() {
        System.out.println("-------------------------");
    }

    //Simple method for printing application opening message
    public static void printOpeningMessage() {
        System.out.println("Welcome to Sort Manager by Michael Camacho!");
    }

    //Simple method for printing the application exit message
    public static void printExitMessage() {
        System.out.println("Shutting down SortManager...");
    }

    //Simple method for adding a line of spacing
    public static void printSpacing() {
        System.out.println("");
    }

    //Prints the error message for an invalid array length
    public static void printArrayLengthErrorMessage() {
        System.out.println("Array length must be greater than zero.");
        printErrorRestartMessage();
    }

    public static void printMenuOptions(String[] MENU_OPTIONS) {
        System.out.println("Please choose your menu option:");
        for (int i = 0;i < MENU_OPTIONS.length;i++) {
            System.out.println((i+1)+": "+MENU_OPTIONS[i]);
        }
        System.out.println("Enter your number choice below:");
    }

    //Prints the message before running the test
    public static void printTestStartMessage(int testChoice, String algorithmName) {
        System.out.println("Please wait, running test for " + algorithmName + "...  (Do not type anything to the command line)");
    }

    //Prints the message for showing the array before it is sorted
    public static void beforeSortMessage() {
        System.out.println("Array before sorting: ");
    }

    //Prints the message for showing the array after it is sorted
    public static void afterSortMessage() {
        System.out.println("Array after sorting: ");
    }

    public static void silentBeforeSortMessage(int[] array, int itemsMissed) {
        System.out.println("Showing reduced array BEFORE sorting:");
        System.out.println(ArrayPrinter.largeIntArrayToString(array) + " ("+itemsMissed+" items omitted)");
    }

    public static void silentAfterSortMessage(int[] array, int itemsMissed) {
        System.out.println("Showing reduced array AFTER sorting:");
        System.out.println(ArrayPrinter.largeIntArrayToString(array) + " ("+itemsMissed+" items omitted)");
    }

    //Prints the message which prompts the user to enter the array length
    public static void printArrayLengthPromptMessage() {
        System.out.println("What should the array length be?");
    }

    //Message printed when the menu is restarted from an error
    public static void printErrorRestartMessage() {
        System.out.println("Restarting menu...");
    }

    //Prints the error message for an invalid number choice
    public static void printMenuNumberError() {
        System.out.println("Number chosen not in menu, please try again.");
        printErrorRestartMessage();
    }

    public static void printSorterResults(double[] sortTimes, String[] sorterNames) {
        System.out.println("Sorter results in order:");
        System.out.println("================================");
        for (int i = 0;i < sortTimes.length;i++) {
            System.out.printf ("%-25s %s \n", sorterNames[i], (sortTimes[i] + " seconds"));
        }
        System.out.println("================================");


    }

    //Printing the Compare All message before running any tests
    public static void printCompareAllTestCaseMessage() {
        System.out.println("Please wait, running all sorters on same array...");
    }

    //Message which informs the user that a large array has been detected
    public static void printLargeArrayMessage() {
        System.out.println("Large array DETECTED, array printing reduced");
    }

    //Prints message for showing how long the algorithm took to run
    public static void printAlgorithmRunTimeMessage(long runTime) {
        System.out.println("Algorithm terminated in "
                +runTime/1000+ " micro seconds ("+runTime+" nanoseconds or "
                +(double)runTime/1000000000+" seconds)");
    }
}
