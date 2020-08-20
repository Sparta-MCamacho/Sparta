public class Printer {

    //Method which prints a charArray on a single line in form [a, b, c, d, p]
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

    //Method which converts a stringArray to a String in form ["hello", "hi", "hey"]
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

    //Prints the converted String from stringArrayToString()
    public static void printStringArray(String[] array) {
        System.out.println(Printer.stringArrayToString(array));
    }

    public static void printLineBreaker() {
        System.out.println("-------------------------");
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


