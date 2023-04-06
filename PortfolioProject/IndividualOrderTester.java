/*
 * Assignment Title: Portfolio Project
 * Name: Danny Caperton
 * School: Colorado State University Global
 * Course: 22WD-CSC400-1
 * Instructor: Dr. Shaher Daoud
 * Due Date: April 9, 2023
 */

package com.dancaps.m8;

/**
 * Tests the methods in the IndividualOrder class.
 */
public class IndividualOrderTester {
    public static void main(String[] args) {

        // Adding the testing orders
        IndividualOrder o1 = new IndividualOrder(1, "Caperton", 12.12);
        IndividualOrder o2 = new IndividualOrder(2, "Smith", 99.99);
        IndividualOrder o3 = new IndividualOrder(3, "Doe", 19.95);
        IndividualOrder o4 = new IndividualOrder(4, "Grome", 9.95);
        IndividualOrder o5 = new IndividualOrder(5, "Doe", 2.99);

        // Testing getters and setters
        System.out.println("\n<== Testing Getters and toString()");
        System.out.println(o1);
        System.out.println(o1.getOrderNumber());
        System.out.println(o1.getLastname());
        System.out.println(o1.getOrderTotal());

        // Testing compareLastname()
        System.out.println("\n<== Testing compareLastname()");
        System.out.println("Test case o1: " + o1);
        System.out.println("Test case o2: " + o2);
        System.out.println("Less Than, Expected: negative :: " + o1.compareLastname(o2));
        System.out.println("\nTest case o2: " + o2);
        System.out.println("Test case o3: " + o3);
        System.out.println("Greater Than, Expected: positive :: " + o2.compareLastname(o3));
        System.out.println("\nTest case o3: " + o3);
        System.out.println("Test case o5: " + o5);
        System.out.println("Equals, Expected: zero :: " + o3.compareLastname(o5));

        // Testing compareOrderNumber()
        System.out.println("\n<== Testing compareOrderNumber()");
        System.out.println("Test case o1: " + o1);
        System.out.println("Test case o4: " + o4);
        System.out.println("Less Than, Expected: negative :: " + o1.compareOrderNumber(o4));
        System.out.println("\nTest case o5: " + o5);
        System.out.println("Test case o2: " + o2);
        System.out.println("Greater Than, Expected: positive :: " + o5.compareOrderNumber(o2));
        System.out.println("\nTest case o3: " + o3);
        System.out.println("Test case o3: " + o3);
        System.out.println("Equals, Expected: zero :: " + o3.compareOrderNumber(o3));

        // Testing print()
        System.out.println("\n<== Testing print()");
        o1.print();
        o2.print();
    }
}