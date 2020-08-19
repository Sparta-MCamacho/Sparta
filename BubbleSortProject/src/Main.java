public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer();
        BubbleSort myBubbleObject = new BubbleSort();
        int[] arr = {7,-6,-8,9,5,0,-4,3,1,2};

        System.out.println("Sorted list with BubbleSort: ");
        printer.printIntArray(myBubbleObject.bubbleSort(arr));
        System.out.println("");

    }
}
