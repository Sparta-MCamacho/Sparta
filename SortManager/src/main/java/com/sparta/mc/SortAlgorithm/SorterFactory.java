package com.sparta.mc.SortAlgorithm;

public class SorterFactory {

    public static Sorter getSorter(String algorithmChoice, int[]unSortedArray) {
        Sorter arraySorter;

        switch (algorithmChoice) {
            case "BinarySorter":
                arraySorter = new BinarySorter(unSortedArray);
                break;
            case "BubbleSorter":
                arraySorter = new BubbleSorter();
                break;
            case "InsertionSorter":
                arraySorter = new InsertionSorter();
                break;
            case "MergerIterativeSorter":
                 arraySorter = new MergeIterativeSorter();
                break;
            case "MergeSorter":
                arraySorter = new MergeSorter();
                break;
            case "QuickSorter":
                arraySorter = new QuickSorter();
                break;
            case "SelectionSorter":
                arraySorter = new SelectionSorter();
                break;
            case "SimpleSorter":
                arraySorter = new SimpleSorter();
                break;
            default:
                arraySorter = null;
                break;
        }
        return arraySorter;
    }

}
