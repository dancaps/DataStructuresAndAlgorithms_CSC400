package com.dancaps.m6;

import java.util.Random;

public class Sorting {

    /**
     * Uses insertion sort to sort an int array
     * @param arr int[]
     */
    public void insertionSort(int[] arr) {
        // Loops through the unsorted elements starting at the second element
        for (int unsortedIndex = 1; unsortedIndex < arr.length; unsortedIndex++) {
            int value = arr[unsortedIndex]; // Storing the current unsorted value
            int valueIndex = unsortedIndex; // Records the current unsorted value index

            // Searches the sorted elements in reverse until it reaches the beginning of the array or smaller number
            while (valueIndex > 0 && value < arr[valueIndex - 1]) { // If it's within the lower bound and value is smaller
                arr[valueIndex] = arr[valueIndex - 1]; // Moves the left element to the right so that there will be room
                valueIndex--; // Decrements the unsorted value index so that it moves the next test to the left
            }
            // When it's at the beginning of the array or found a smaller value
            arr[valueIndex] = value; // The value is updated in the proper element
        }
    }

    /**
     * Creates an int[] with a specific size and upper bound of random numbers.
     * Example: int[] arr = makeIntArray(10, 5); returns: {0, 3, 4, 2, 1, 1, 0, 3, 4, 0}
     * @param size int; The number of elements in the array.
     * @param upperBound int; The upper bound on the random number that can be created as a value.
     * @return int[]; An array of randomly generated integers of a specific size.
     */
    public int[] makeIntArray(int size, int upperBound) {
        int[] numbers = new int[size]; // Creates the array
        Random random = new Random(); // Instantiates the Random object
        for (int num = 0; num < numbers.length; num++) { // Loops the array and adds random ints to each element
            numbers[num] = random.nextInt(0, upperBound); // Adds the int
        }
        return numbers; // Returns the array
    }

    /**
     * Tests the integer array is sorted in ascending order.
     * @param arr int[]
     * @return boolean
     */
    public boolean isSortedAscending(int[] arr) {
        int left = 0; // Left pointer
        int right = arr.length - 1; // Right pointer

        // Tests the left pointer is less than right; resulting in only half the array being compared
        while (left < right) {
            if (arr[left] > arr[right]) { // False if the value of left is greater than the value of right
                return false;
            } else { // Moving the left and right pointers
                left++;
                right--;
            }
        }
        return true; // Everything is sorted
    }
}
