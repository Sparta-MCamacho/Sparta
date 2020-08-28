package com.sparta.mc.Printer;

public class ArrayPrinter {

    //Public method for printing a int array
    public static void printLargeIntArray(int[] array) {
        System.out.println(largeIntArrayToString(array));
    }

    //Public method for converting the array object to a string
    public static String largeIntArrayToString(int[] array) {

        //Dealing with low count case
        if (array.length < 21) {
            return intArrayToString(array);
        }

        String print = "[";
        for (int i = 0; i < 10;i++) {
            print += array[i] + ", ";
        }
        print += "  ......   ";
        for (int i = array.length-9; i < array.length;i++) {
            print += array[i] + ", ";
        }
        char[] printArray = print.toCharArray();
        printArray = formatEndString(printArray);
        print = new String(printArray);
        return print;
    }

    //Public method for printing a Integer wrapper class array
    public static void printIntegerArray(Integer[] array) {
        System.out.println(integerArrayToString(array));
    }

    //Public method for converting the array object to a string
    public static String integerArrayToString(Integer[] array) {
        String print = "[";
        for (Integer i : array) {
            print += i + ", ";
        }
        char[] printArray = print.toCharArray();
        printArray = formatEndString(printArray);
        print = new String(printArray);
        return print;
    }

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
