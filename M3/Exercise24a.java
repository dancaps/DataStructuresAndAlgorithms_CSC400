package com.dancaps.m3;

import java.util.Arrays;
import java.util.Random;

public class Exercise24a {
    public static void main(String[] args) {
        Random randomInt = new Random();
        int count = 11; // Any number between 1 and count could be in the array
        int numberToExclude = randomInt.nextInt(1, count + 1); // Randomly picks a number to exclude
        int[] intArray = createArray(count, numberToExclude); // Dynamically creates a shuffled array with a missing number
        System.out.println("Tests using random");
        System.out.println("==> This is the created array:   " + Arrays.toString(intArray));
        System.out.println("==> This is the number excluded: " + numberToExclude);
        System.out.println("==> This is the missing number:  " + findTheMissingInteger(intArray));
        System.out.println();

        int[] worstCaseArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Forcing worst case scenario
        System.out.println("Tests using worst case");
        System.out.println("==> This is the created array:   " + Arrays.toString(worstCaseArray));
        System.out.println("==> This is the number excluded: " + 10);
        System.out.println("==> This is the missing number:  " + findTheMissingInteger(worstCaseArray));
    }

    /**
     * Creates an array of integers from 1 to count, that excludes a second provided integer and is shuffled.
     * @param count int
     * @param numberToExclude int
     * @return int[]
     */
    public static int[] createArray(int count, int numberToExclude) {
        int[] result = new int[count - 1]; // Creates an empty array of the correct size
        int numberToAdd = 1; // The number to be added to the index
        Random random = new Random(); // Creating a Random object to use for shuffling

        // Algorithm to fill the array skipping a provided number. Just for fun this is O(n).
        for (int index = 0; index < result.length; index++) {
            if (numberToAdd == numberToExclude) { // Checks to see if the numberToAdd is the numberToSkip
                numberToAdd++; // Increments the number to add effectively skipping the number to exclude
            }
            result[index] = numberToAdd; // Adds the number to the current index
            numberToAdd++; // Increments the number to add
        }

        // Algorithm to shuffle the results array. Just for fun this is O(n).
        for (int index = 0; index < result.length; index++) {
            int swapIndex = random.nextInt(result.length); // Gets a random index to swap
            int tmp = result[index]; // Temporary storage to hold the value of the current index
            result[index] = result[swapIndex]; // Adds the swap index value to the current index
            result[swapIndex] = tmp; // Add the current index value to the swap index
        }

        return result;
    }

    /**
     * Takes an integer array as input, that has consecutive numbers from 1 to the size of the array + 1
     * except there is 1 missing number. If finds the missing number and results the integer value.
     * @param numbers int[]
     * @return integer
     */
    public static int findTheMissingInteger(int[] numbers) {
        int iter = 0; // Records the number of iterations
        int result = -1;
        // First loop that defines the number which needs to be checked starting at zero and ending at the array length
        for (int count = 1; count <= numbers.length + 1; count++) {
            boolean isCount = false; // Used to test if count was found in the array
            // Second loop that pulls the value from the index
            for (int index = 0; index < numbers.length; index++) {
                iter++; // Counts the iterations
                if (numbers[index] == count) { // Checks the index value with the count number
                    isCount = true; // If the number is found sets variable as true
                    //break; // Using the break would make this less than O(n^2)
                }
            }
            // Tests if count was found in the list
            if (!isCount) { // If it wasn't found
                result = count; // Return count
                break; // This break does improve performance but not in the worst case
            }
        }
        System.out.println("==> The number of iterations:    " + iter); // Prints the number of iterations
        return result; // Returns -1 if there was no missing consecutive number
    }
}
