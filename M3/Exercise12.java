package com.dancaps.m3;

public class Exercise12 {
    public static void main(String[] args) {
        int n = 10000;
        int iterationsLoop1 = 0;
        int iterationsLoop2 = 0;
        int iterationsLoop3 = 0;

        for (int pass = 1; pass <=n; pass++) {
            iterationsLoop1++;
            for (int index = 0; index < n; index++) {
                iterationsLoop2++;
                for (int count = 1; count < 10; count++) {
                    iterationsLoop3++;
                }
            }
        }
        System.out.println("Showing my work:");
        System.out.println("IterationsLoop1: " + iterationsLoop1);
        System.out.println("We see that the first loop is O(n)");
        System.out.println("IterationsLoop2: " + iterationsLoop2);
        System.out.println("We see that the second loop is O(n^2)");
        System.out.println("IterationsLoop3: " + iterationsLoop3);
        System.out.println("We see that the third loop is O(1) because it is just a constant multiple of the second loop");
        System.out.println("Since the worst case is decided by the second loop this is an O(n^2) algorithm");
    }
}

