package com.company;

public class RandomPermutation {


    String[] makeRandomStringArray(String[] arr) {
        // Make temporary list.
        String[] tempList = new String[arr.length];
        // Get the array length  - 1
        int arrayLength = arr.length - 1;
        // iterate backwards.
        for (int i = 0; i <= arrayLength; arrayLength--) {
            // make a random number from array length to 1.
            int randNumber = (int) (Math.random() * (arrayLength - 1) + 1);
            // Get the length of the array plus
            tempList[arrayLength] = arr[randNumber];
            // random index to arr to the last item in array that is not a duplicate.
            arr[randNumber] = arr[arrayLength];

        }
        // returns the value.
        return tempList;
    }
}