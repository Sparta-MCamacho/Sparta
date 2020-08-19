public class Printer {

    public static void printCharArray(char[] array) {

        String print = "[";
        for (char c : array) {
            print += c + ", ";
        }
        char[] printArray = print.toCharArray();
        printArray[printArray.length-2] = ']';
        print = new String(printArray);
        System.out.println(print);
    }

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

    public static void printStringArray(String[] array) {
        System.out.println(Printer.stringArrayToString(array));
    }

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


