package com.sparta.mc.InitialisationManager;

import java.util.Random;

//Build int arrays containing random values from -1000 to 1000
public class RandomArrayBuilder {

    public static int[] generateRandomArray(int arrayLength) {

        int[] randomArray = new int[arrayLength];

        for (int i = 0;i < arrayLength;i++) {
            randomArray[i] = generateRandomInt();
        }

        return randomArray;
    }

    //Public method for generateRandomArray() for generating a random int between -1000 and 1000
    public static int generateRandomInt() {
        Random r = new Random();

        int randomIntValue = r.nextInt(1000);
        int randomIntSign = r.nextInt(2);

        if (randomIntSign%2==1) {
            return (randomIntValue - 2*randomIntValue);
        } else {
            return randomIntValue;
        }
    }

    public static int[] cloneArray(int[] array) {
        int[] returnArray = new int[array.length];

        for (int i = 0;i < array.length;i++) {
            returnArray[i] = array[i];
        }

        return returnArray;
    }

}