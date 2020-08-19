public class BubbleSort {

    public int[] bubbleSort(int[] inputArray) {

        //Setting up the double loop
        for (int i = 0;i < inputArray.length-1;i++) {
            for (int j = 0;j < inputArray.length-1;j++) {
                if (inputArray[j] > inputArray[j+1]) {

                    //If the left is bigger than right, swap them
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j+1];
                    inputArray[j+1] = temp;
                }
            }
        }

        return inputArray;
    }
}