package com.dancaps.m3;

public class Exercise10 {
    public static void main(String[] args) {
        int sum = 0;
        int n = 10000;
        int iterations = 0;

        for (int counter = 1; counter < n; counter = 2 * counter) {
            sum += n;
            iterations++;
        }

        System.out.println("Sum: " + sum);
        System.out.println("n: " + n);
        System.out.println("Iterations: " + iterations);

        System.out.println("Showing my work:");
        System.out.println("We can see the answer is O(log n) by calculating the number of iterations.");
        System.out.println("Log " + n + " to the base 2 = " + ((int)(Math.log(n) / Math.log(2)) + 1));
    }
}

