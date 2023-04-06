/*
 * Assignment Title: Portfolio Project
 * Name: Danny Caperton
 * School: Colorado State University Global
 * Course: 22WD-CSC400-1
 * Instructor: Dr. Shaher Daoud
 * Due Date: April 9, 2023
 */

package com.dancaps.m8;

import java.util.List;

/**
 * Tests the methods in the Display class.
 */
public class DisplayTester {
    public static void main(String[] args) {
        Display display = new Display();
        List<IndividualOrder> nameSortedList = display.getLastnameSorted();
        List<IndividualOrder> orderNumberSortedList = display.getOrderNumberSorted();

        display.add(new IndividualOrder(3, "Caperton", 12.12));
        display.add(new IndividualOrder(1, "Smith", 99.99));
        display.add(new IndividualOrder(9, "Doe", 19.95));
        display.add(new IndividualOrder(5, "Grome", 9.95));
        display.add(new IndividualOrder(8, "Jobs", 2.99));
        display.add(new IndividualOrder(1, "Smith", 100.00));
        display.add(new IndividualOrder(2, "Caperton", 1.12));
        display.add(new IndividualOrder(6, "Zelda", 51.21));
        display.add(new IndividualOrder(4, "Alder", 88.10));

        // Testing the 2 lists
        System.out.println("\n<== Testing there are 2 lists with the same objects");
        System.out.println(nameSortedList);
        System.out.println(orderNumberSortedList);

        // Testing the lastname sorting
        System.out.println("\n<== Testing quicksort(lastname)");
        System.out.print("UNSORTED lastnames: ");
        for (IndividualOrder individualOrder : nameSortedList) {
            System.out.print(individualOrder.getLastname() + ", ");
        }
        display.quicksort("lastname");
        System.out.print("\nSORTED lastnames:   ");
        for (IndividualOrder individualOrder : nameSortedList) {
            System.out.print(individualOrder.getLastname() + ", ");
        }
        System.out.println();

        // Testing the order sorting
        System.out.println("\n<== Testing quicksort(order)");
        System.out.print("UNSORTED order numbers: ");
        for (IndividualOrder individualOrder : orderNumberSortedList) {
            System.out.print(individualOrder.getOrderNumber() + ", ");
        }
        display.quicksort("order");
        System.out.print("\nSORTED order numbers:  ");
        for (IndividualOrder individualOrder : orderNumberSortedList) {
            System.out.print(individualOrder.getOrderNumber() + ", ");
        }
        System.out.println();

        // Testing incorrect parameter in the 1 argument quicksort(String sortParameter) method
        System.out.println("\n<== Testing quicksort(invalid)");
        try {
            display.quicksort("invalid");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        //Testing printAll()
        System.out.println("\n<== Testing printAll()");
        display.printAll();

        // Testing the remove(orderNumber) method
        System.out.println("\n<== Testing remove(orderNumber");
        display.remove(2);
        display.printAll();
    }
}
