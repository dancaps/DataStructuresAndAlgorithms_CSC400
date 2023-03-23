package com.dancaps.m6;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

public class TestingSorting {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch(); // Part of the apache commons libraries
        Sorting sorting = new Sorting();
        int arraySize1 = 10; // Small array size
        int arraySize2 = 100_000; // Medium array size
        int arraySize3 = 1_000_000; // Large array size

        int[] numbers1 = sorting.makeIntArray(arraySize1, arraySize1); // Making the first array
        System.out.println("<== Testing a small array to show it works.");
        System.out.println("\t<== Testing the array is sorted before: " + sorting.isSortedAscending(numbers1));
        System.out.println("\t<== Before: " + Arrays.toString(numbers1));
        stopWatch.start();
        sorting.insertionSort(numbers1); // Sorting the first array
        stopWatch.stop();
        System.out.println("\t<== After:  " + Arrays.toString(numbers1));
        System.out.println("\t<== Testing the array is sorted after: " + sorting.isSortedAscending(numbers1));
        System.out.println("\t<== Execution Time in Nanoseconds: " + stopWatch.getNanoTime());

       int[] numbers2 = sorting.makeIntArray(arraySize2, arraySize2); // Making the second array
       System.out.println("<== Testing an array with 100,000 elements");
       stopWatch.reset();
       stopWatch.start();
       sorting.insertionSort(numbers2); // Sorting the second array
       stopWatch.stop();
       System.out.println("\t<== Execution Time in Seconds: " + (double) stopWatch.getNanoTime() / 1_000_000_000);

       int[] numbers3 = sorting.makeIntArray(arraySize3, arraySize3); // Making the third array
       System.out.println("<== Testing an array with 1,000,000 elements");
       stopWatch.reset();
       stopWatch.start();
       sorting.insertionSort(numbers3); // Sorting the third array
       stopWatch.stop();
       System.out.println("\t<== Execution Time in Seconds: " + (double) stopWatch.getNanoTime() / 1_000_000_000);

    }
}
