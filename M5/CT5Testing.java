/*
 * Assignment Title: Algorithm Analysis / Big-Oh Notation
 * Name: Danny Caperton
 * School: Colorado State University Global
 * Course: 22WD-CSC400-1
 * Instructor: Dr. Shaher Daoud
 * Due Date: March 19, 2023
 */

package com.dancaps.m5;

public class CT5Testing {
    public static void main(String[] args) {
        CT5 ct5 = new CT5();
        System.out.println("<== Testing Factorial Method One");
        System.out.println("\t<== Factorial Method One has a time complexity of O(n)");
        System.out.println("\t<== The input is: 12");
        System.out.println("\t<== The expected output is: 479001600");
        System.out.println("\t<== The actual output is:   " + ct5.factorialMethodOne(12)); // 479001600
        System.out.println();

        System.out.println("<== Testing Factorial Method Two");
        System.out.println("\t<== Factorial Method Two has a time complexity of O(n)");
        System.out.println("\t<== The input is: 12");
        System.out.println("\t<== The expected output is: 479001600");
        System.out.println("\t<== The actual output is:   " + ct5.factorialMethodTwo(12)); // 479001600
        System.out.println();

        int[] nums = {-7,-3,2,3,11};
        System.out.println("<== Testing Reverse Array From a Starting Index");
        System.out.println("\t<== Reversed Array has a time complexity of O(n - m)");
        System.out.println("\t<== The input is: {-7,-3,2,3,11} with a starting index of 4");
        System.out.println("\t<== The expected output is: 11 3 2 -3 -7");
        System.out.print("\t<== The actual output is:   ");
        ct5.reversedArray(nums, 4);
        System.out.println();
        System.out.println();

        System.out.println("<== Testing Reverse Array Edge Cases: null & out of index errors");
        System.out.println("\t<== The expected output is: Invalid Entry");
        System.out.println("\t<== The input is: {-7,-3,2,3,11} with a starting index of -1");
        System.out.print("\t<== The actual output is:   ");
        ct5.reversedArray(nums, -1);
        System.out.println();
        System.out.println("\t<== The input is: {-7,-3,2,3,11} with a starting index of nums.length");
        System.out.print("\t<== The actual output is:   ");
        ct5.reversedArray(nums, nums.length);
        System.out.println();
        System.out.println("\t<== The input is: null");
        System.out.print("\t<== The actual output is:   ");
        ct5.reversedArray(null, nums.length);
        System.out.println();
    }
}
