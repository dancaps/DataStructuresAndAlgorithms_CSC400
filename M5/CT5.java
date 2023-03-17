/*
 * Assignment Title: Algorithm Analysis / Big-Oh Notation
 * Name: Danny Caperton
 * School: Colorado State University Global
 * Course: 22WD-CSC400-1
 * Instructor: Dr. Shaher Daoud
 * Due Date: March 19, 2023
 */

package com.dancaps.m5;

public class CT5 {

    /**
     * Recursive factorial demonstration one [n * (n - 1) * (n - 2) * (n - 3) * ...]
     * @param n any whole number equal to or greater than 0
     * @return integer
     */
    public int factorialMethodOne(int n) {
        if (n == 0) { // Base case
            return 1;
        }
        return n * factorialMethodOne(n - 1); // Recursive call
    }

    /**
     * Recursive factorial demonstration two [n * (n - 1) * (n - 2) * (n - 3) * ...]
     * @param n any whole number equal to or greater than 0
     * @return integer
     */
    public int factorialMethodTwo(int n) {
        if (n > 0) { // Tests for a valid number
            return n * factorialMethodTwo(n - 1); // Recursive call
        }
        return 1; // Invalid number which is also the base case
    }

    /**
     * Takes an integer array and an index in that array. From that starting index the values in the array
     * are printed in reverse.
     * Example input: {-7,-3,2,3,11}, nums.length -1
     * Example output: 11 3 2 -3 -7
     * @param nums int[]
     * @param startingIndex integer of the array index to print first
     */
    public void reversedArray(int[] nums, int startingIndex) {
        // Testing for invalid entries
        if (nums == null || startingIndex < 0 || startingIndex > nums.length - 1 ) {
            System.out.print("Invalid Entry");
        } else if (startingIndex == 0) { // Base case
            System.out.print(nums[0] + " ");
        } else {
            System.out.print(nums[startingIndex] + " "); // Printing the requested index
            reversedArray(nums, startingIndex - 1); // Recursive call working backwards down the array
        }
    }
}
