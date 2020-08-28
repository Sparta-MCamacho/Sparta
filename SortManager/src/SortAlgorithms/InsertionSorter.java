package SortAlgorithms;

public class InsertionSorter {

    public static int[] sortByInsertionSort(int[] array) {

        //Setting up main loop to sort each item individually
        for (int i = 1;i < array.length;i++) {

            //Start from beginning of list until current position
            for (int j = 0;j < i;j++) {

                //If a int is smaller than the current, make a swap and update
                if (array[i] < array[j]) {
                    int temp = array[i];

                    //Update all successors with the new value and break ot move onto next position
                    for (int k = j; k < i;k++) {
                        array[k] = array[k+1];
                    }
                    array[j] = array[i];
                    break;
                }
            }
        }
        return array;
    }

}
