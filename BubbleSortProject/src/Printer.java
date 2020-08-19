public class Printer {

    public void printString(String str) {
        System.out.println(str);
    }

    public void printIntArray(int[] arr) {
        String str = "[";
        for(int i : arr) {
            str += (i + ", ");
        }
        char[] strArray = str.toCharArray();
        strArray[strArray.length-2] = ']';
        String returnString = new String(strArray);
        System.out.println(returnString);
    }
}