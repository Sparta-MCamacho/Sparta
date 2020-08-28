package Printer;

public class ArrayPrinter {

    //Public method for printing a char array
    public static void printCharArray(char[] array) {
        System.out.println(charArrayToString(array));
    }

    //Public method for converting the array object to a string
    public static String charArrayToString(char[] array) {
        String print = "[";
        for (char c : array) {
            print += c + ", ";
        }
        char[] printArray = print.toCharArray();
        printArray = formatEndString(printArray);
        print = new String(printArray);
        return print;
    }

    //Public method for printing a int array
    public static void printIntArray(int[] array) {
        System.out.println(intArrayToString(array));
    }

    //Public method for converting the array object to a string
    public static String intArrayToString(int[] array) {

        //Dealing with null case
        if (array == null) {
            return "[]";
        }

        String print = "[";
        for (int i : array) {
            print += i + ", ";
        }
        char[] printArray = print.toCharArray();
        printArray = formatEndString(printArray);
        print = new String(printArray);
        return print;
    }

    //Public method for printing a string array
    public static void printStringArray(String[] array) {
        System.out.println(stringArrayToString(array));
    }

    //Public method for converting the array object to a string
    public static String stringArrayToString(String[] array) {
        String print = "[";
        for (String s : array) {
            print += s + ", ";
        }
        char[] printArray = print.toCharArray();
        printArray = formatEndString(printArray);
        print = new String(printArray);
        return print;
    }

    //Helper method for stringArrayToString() for dealing with edge cases
    private static char[] formatEndString(char[] stringArray) {
        if (stringArray.length < 2) {
            char[] c = {'[',']'};
            return c;
        } else {
            stringArray[stringArray.length-2] = ']';
            return stringArray;
        }
    }



}
