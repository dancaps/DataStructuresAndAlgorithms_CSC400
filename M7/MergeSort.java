package com.dancaps.m7;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] input = {29, -99, 52, 36, 400, 95, 0, 81, 12, 7, 75, -50, 1, 0, -1};
        System.out.println(Arrays.toString(input));
        recursiveMergeSort(input, 0, input.length);
        System.out.println(Arrays.toString(input));
    }

    /**
     * Recursively sorts the int[] in place and is stable.
     * @param input; int[]
     * @param left; starting index number
     * @param right; length of the array. This is the number of elements.
     */
    private static void recursiveMergeSort(int[] input, int left, int right) {

        // Base case which returns on a 1 element array
        if (right - left < 2) {
            return;
        }

        // Adding left and right then dividing by 2 always separates the array partition correctly
        int mid = (left + right) / 2;
        recursiveMergeSort(input, left, mid);
        recursiveMergeSort(input, mid, right);

        mergeMe(input, left, mid, right); // Calls the mergeMe method
    }

    /**
     * Merges the two logical sections of the array. {left, mid - 1} and {mid, right - 1}
     * @param input; int[]
     * @param left; first index in the left array
     * @param mid; first index in the right array
     * @param right; last index plus one
     */
    private static void mergeMe(int[] input, int left, int mid, int right) {

        // If the last element on the left array is less than the first element on
        // the right array, the array is already sorted
        if (input[mid - 1] < input[mid]) {
            return;
        }
        int i = left; // First index in the left array
        int j = mid; // First index in the second array
        int workingInputIndex = 0; // The starting index for the temp array
        int[] tempArray = new int[right - left]; // The temp array created with the correct size

        // Drop out of the while loop if we are at the end of either array
        // Remember right is one greater than the last index
        while (i < mid && j < right) {
            // If the value at i is less than the value at j, add the value of i to the working
            // index of the temp array, otherwise add the value of j. Also while you are at it
            // go ahead an increment the variables
            tempArray[workingInputIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        // If there are elements remaining in the left array, they are copied inplace to their
        // proper location. If there are elements remaining in the right array, they can stay
        // where they are so nothing needs to happen
        System.arraycopy(input, i, input, left + workingInputIndex, mid - i);
        // Copies the values in the temp array to the proper location of the input array
        System.arraycopy(tempArray, 0, input, left, workingInputIndex);
    }
}
