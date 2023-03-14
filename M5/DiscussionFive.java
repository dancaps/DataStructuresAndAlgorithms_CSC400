package com.dancaps.m5;

public class DiscussionFive {
    public static void main(String[] args) {
        String str1 = "Data Structures and Algorithms";
        String str2 = "We are finally at week five!";

        System.out.println("<== Testing Recursion [str1]");
        System.out.println("\tOriginal String: " + str1);
        System.out.print("\tReversed String: ");
        reverseUsingRecursion(str1);
        System.out.println();

        System.out.println("<== Testing Recursion [str1]");
        System.out.println("\tOriginal String: " + str2);
        System.out.print("\tReversed String: ");
        reverseUsingRecursion(str2);
        System.out.println();

        System.out.println("<== Testing Recursion [null]");
        System.out.println("\tOriginal String: null");
        System.out.print("\tReversed String: ");
        reverseUsingRecursion(null);
        System.out.println();
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
}
