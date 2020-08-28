package com.sparta.mc.SortAlgorithm;

import com.sparta.mc.BinaryTree.BinaryTreeImpl;

public class BinarySorter implements Sorter {

    private BinaryTreeImpl binTree;

    //Constructor which initialises the BinaryTree with the given array
    public BinarySorter(int[] array) {
        if (array == null) {
            return;
        }
        setBinaryTree(array);
    }

    //Default constructor
    public BinarySorter() {

    }

    @Override
    //Sorts the int array using the Binary Tree sort algorithm
    public void sortArray(int[] array) {
        setBinaryTree(array);

        //Calls the sort function in Binary Tree
        int[] returnArray = binTree.getSortedTreeAsc();

        //Copies values from returned array to the array in the parameter
        for (int i = 0;i < array.length;i++) {
            array[i] = returnArray[i];
        }
    }

    //Method for changing the BinaryTree of the sorter
    public void setBinaryTree(int[] array) {
        binTree = new BinaryTreeImpl(array);
    }

}
