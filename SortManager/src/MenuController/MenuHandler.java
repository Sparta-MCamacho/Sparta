package MenuController;

import Printer.ArrayPrinter;
import Printer.FormatPrinter;
import SortAlgorithms.*;

import java.util.Scanner;

//Class concerned with running the Menu
public class MenuHandler {

    //Static variable holding menu options
    private static final String[] MENU_OPTIONS = {
            "BinarySorter", "BubbleSorter",
            "InsertionSorter", "MergerSorter",
            "MergeSorterIterative", "QuickSorter",
            "SelectionSorter", "Exit Application"
    };

    //Public method for starting the menu
    public static void startMenu() {
        FormatPrinter.printOpeningMessage();

        Scanner userInput = new Scanner(System.in);

        while (true) {
            printMenuOptions();
            int response = userInput.nextInt();

            if (response == MENU_OPTIONS.length) {
                break;
            }

            FormatPrinter.printArrayLengthMessage();
            int arrayLength = userInput.nextInt();

            runMenuOption(response, arrayLength);

        }
        FormatPrinter.printExitMessage();
    }

    //Helper method for printing the available options
    private static void printMenuOptions() {

        System.out.println("Please type your menu option choice:");
        for (int i = 0;i < MENU_OPTIONS.length;i++) {
            System.out.println((i+1)+": "+MENU_OPTIONS[i]);
        }
        System.out.println("Enter your number choice below:");

    }

    private static int runMenuOption(int algorithmChoice, int arrayLength) {
        int continueRunning = 1;
        int endApplication = -1;

        executeTestCase(algorithmChoice, arrayLength);

        return continueRunning;
    }

    private static void executeTestCase(int algorithmChoice, int arrayLength) {

        int[] unsortedArray = RandomArrayBuilder.generateRandomArray(arrayLength);
        int[] sortedArray = RandomArrayBuilder.cloneArray(unsortedArray);

        switch (algorithmChoice) {
            case 1:
                sortedArray = BinarySorter.sortByBinarySort(sortedArray);
                break;
            case 2:
                sortedArray = BubbleSorter.sortByBubbleSort(sortedArray);
                break;
            case 3:
                sortedArray = InsertionSorter.sortByInsertionSort(sortedArray);
                break;
            case 4:
                sortedArray = MergeSorter.sortByMergeSort(sortedArray);
                break;
            case 5:
                sortedArray = MergeSorterIterative.sortByMergeSortIterative(sortedArray);
                break;
            case 6:
                sortedArray = QuickSorter.sortByQuickSort(sortedArray);
                break;
            case 7:
                sortedArray = SelectionSorter.sortBySelectionSort(sortedArray);
                break;
            default:
                FormatPrinter.printMenuNumberError();
                break;

        }

        FormatPrinter.printTestStartMessage(algorithmChoice, MENU_OPTIONS[algorithmChoice-1]);
        FormatPrinter.beforeSortMessage();
        ArrayPrinter.printIntArray(unsortedArray);
        FormatPrinter.afterSortMessage();
        ArrayPrinter.printIntArray(sortedArray);

    }

    public static void printTestCase() {}

}
