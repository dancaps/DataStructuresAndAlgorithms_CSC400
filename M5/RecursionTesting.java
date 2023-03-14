package com.dancaps.m5;

import java.util.Arrays;

public class RecursionTesting {
    public static void main(String[] args) {
        String word = "Danny";

        skipOneLine(5);
        System.out.println();
        reverseUsingRecursion(word);
        reverseUsingRecursion(null);
    }

    /**
     * Using recursion to reverse the order of a string.
     * @param str String
     */
    private static void reverseUsingRecursion(String str) {
        if (str != null && str.length() > 0) { // Tests that the value isn't null and the length is greater than 0
            System.out.print(str.charAt(str.length() - 1)); // Prints the last char
            reverseUsingRecursion(str.substring(0, str.length() - 1)); // Recursively calls the string minus the last char
        }
    }


    /**
     * This is a practice exercise meant to print blank lines. I added text to see what happens which basically
     * demonstrates counting down and counting up using recursion. It all depends on where the println statement is in
     * regard to the recursive statement.
     * @param line int
     */
    private static void skipOneLine(int line) {
        if (line > 0) { // The base case
            // Printing as it moves forward which looks like counting down
            System.out.println("Printing as recursion moves forward, before the base case is met: " + line);
            skipOneLine(line - 1); // Recursive call which includes the parameter change
            // Printing after recursion ends which looks like counting up
            System.out.println("Printing after recursion is done, meaning the base case was met:  " + line);
        }
    }
}
