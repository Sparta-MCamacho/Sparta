package Printer;

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

    public static void printTestStartMessage(int testChoice, String algorithmName) {
        System.out.println("Running test for " + algorithmName + "...");
    }

    public static void beforeSortMessage() {
        System.out.println("Array before sorting: ");
    }

    public static void afterSortMessage() {
        System.out.println("Array after sorting: ");
    }

    public static void printArrayLengthMessage() {
        System.out.println("What should the array length be?");
    }

    public static void printMenuNumberError() {
        System.out.println("Number chosen not in menu, please try again.");
    }
}
