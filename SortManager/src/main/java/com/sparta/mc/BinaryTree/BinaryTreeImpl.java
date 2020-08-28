package com.sparta.mc.BinaryTree;

import com.sparta.mc.ExceptionHandler.ChildNotFoundException;

public class BinaryTreeImpl implements BinaryTree {

    private Node rootNode;
    private int numberOfElements;
    private int counter;

    //Constructor which builds the BinaryTree from an array
    public BinaryTreeImpl(int[] array) {
        numberOfElements = 0;
        addElements(array);
        counter = 0;
    }

    @Override
    //Getter for getting root element
    public int getRootElement() {
        return rootNode.getIntValue();
    }

    //Getter for getting root node
    public Node getRootNode() {
        return rootNode;
    }

    @Override
    public int getNumberOfElements() {
        return numberOfElements;
    }

    @Override
    public void addElement(int element) {
        if (rootNode == null) {
            rootNode = new Node(element);
        } else {
            addNodeToBinaryTree(rootNode, new Node(element));
        }
        numberOfElements++;
    }

    //Helper method for addElement which traverses the BinaryTree
    private void addNodeToBinaryTree(Node node, Node newNode) {
        if (newNode.getIntValue() <= node.getIntValue() && node.getLeftNode() == null) {
            node.leftChild = newNode;
        } else if (newNode.getIntValue() > node.getIntValue() && node.getRightNode() == null) {
            node.rightChild = newNode;
        } else if (newNode.getIntValue() <= node.getIntValue()) {
            addNodeToBinaryTree(node.leftChild, newNode);
        } else if (newNode.getIntValue() > node.getIntValue()) {
            addNodeToBinaryTree(node.rightChild, newNode);
        }
    }

    @Override
    public void addElements(int[] elements) {
        for (int i : elements) {
            addElement(i);
        }
    }

    @Override
    public boolean findElement(int value) {
        return false;
    }

    //Helper method for findElement() which traverses the BinaryTree
    private boolean traverseAndFindElement(Node currentNode, int searchingValue) {
        if (currentNode.getIntValue() == searchingValue) {
            return true;
        }
        return false;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        return 0;
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        return 0;
    }

    @Override
    public int[] getSortedTreeAsc() {
        int[] returnArray = new int[numberOfElements];
        counter = 0;
        treeToAscSortedArray(rootNode, returnArray);

        return returnArray;
    }

    //Traverses
    private void treeToAscSortedArray(Node node, int[] array) {

        if (node.leftChild == null && node.rightChild == null) {
            array[counter] = node.intValue;
            counter++;

        } else if (node.rightChild != null && node.leftChild != null) {
            treeToAscSortedArray(node.leftChild, array);
            array[counter] = node.intValue;
            counter++;
            treeToAscSortedArray(node.rightChild, array);

        } else if (node.leftChild == null && node.rightChild != null) {
            array[counter] = node.intValue;
            counter++;
            treeToAscSortedArray(node.rightChild, array);

        } else if (node.leftChild != null && node.rightChild == null) {

            treeToAscSortedArray(node.leftChild, array);
            array[counter] = node.intValue;
            counter++;
        }
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] returnArray = new int[numberOfElements];
        counter = 0;
        treeToDescSortedArray(rootNode, returnArray);

        return returnArray;
    }

    private void treeToDescSortedArray(Node node, int[] array) {

        if (node.leftChild == null && node.rightChild == null) {
            array[counter] = node.intValue;
            counter++;

        } else if (node.rightChild != null && node.leftChild != null) {
            treeToDescSortedArray(node.rightChild, array);
            array[counter] = node.intValue;
            counter++;
            treeToDescSortedArray(node.leftChild, array);

        } else if (node.leftChild == null && node.rightChild != null) {
            treeToDescSortedArray(node.rightChild, array);
            array[counter] = node.intValue;
            counter++;

        } else if (node.leftChild != null && node.rightChild == null) {

            array[counter] = node.intValue;
            counter++;
            treeToDescSortedArray(node.leftChild, array);
        }
    }


    public class Node {
        private int intValue;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.intValue = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        public Node(int value, Node leftChild) {
            this.intValue = value;
            this.leftChild = leftChild;
            this.rightChild = null;
        }

        public Node(int value, Node leftChild, Node rightChild) {
            this.intValue = value;
            this.leftChild = leftChild;
            this.leftChild = rightChild;
        }

        @Override
        public String toString() {
            return ("" + intValue);
        }

        public int getIntValue() {
            return intValue;
        }

        public Node getLeftNode() {
            return leftChild;
        }

        public Node getRightNode() {
            return rightChild;
        }

    }
}
