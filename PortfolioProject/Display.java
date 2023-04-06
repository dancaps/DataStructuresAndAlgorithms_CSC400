/*
 * Assignment Title: Portfolio Project
 * Name: Danny Caperton
 * School: Colorado State University Global
 * Course: 22WD-CSC400-1
 * Instructor: Dr. Shaher Daoud
 * Due Date: April 9, 2023
 */

package com.dancaps.m8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Assignment requirements: Create a Display Class that will store a copy of the order queue in two arrays.
 * Each array will contain the order list but one will be sorted by name and the other sorted by order number.
 * When an order is taken and stored in the Order Class the program will update the
 * Display Class arrays automatically and sort them in descending order using quick sort and outputs
 * the contents to the console upon each entry of new data.
 */
public class Display {

    // The 2 required data types
    private final List<IndividualOrder> lastnameSorted = new ArrayList<>();
    private final List<IndividualOrder> orderNumberSorted = new ArrayList<>();

    /**
     * This method adds a new order to both lists, sorts the lists and prints the contents of each list.
     * @param individualOrder IndividualOrder object
     */
    public void add(IndividualOrder individualOrder) {
        lastnameSorted.add(individualOrder); // Adds the order to this list
        orderNumberSorted.add(individualOrder); // Adds the order to this list
        this.quicksort(); // Sorts both lists
        this.printAll(); // Prints all the objects in the list, per the requirements.
    }

    /**
     * Getter to retrieve the list of orders sorted by lastname.
     * @return List<IndividualOrder>
     */
    public List<IndividualOrder> getLastnameSorted() {
        return lastnameSorted;
    }

    /**
     * Getter to retrieve the list of orders sorted by order number.
     * @return List<IndividualOrder>
     */
    public List<IndividualOrder> getOrderNumberSorted() {
        return orderNumberSorted;
    }

    /**
     * Call quicksort to sort the orders by both lastname and order number. Use the getter to retrieve the lists.
     * Sorts in descending order.
     */
    public void quicksort() {
        quicksort(lastnameSorted, 0, lastnameSorted.size() - 1, "lastname");
        quicksort(orderNumberSorted, 0, lastnameSorted.size() - 1, "order");
    }

    /**
     * Calls the quicksort methods using the proper sort parameter. Throws an IllegalArgumentException if an incorrect
     * parameter is used. Sorts in descending order.
     * @param sortParameter Only valid string inputs are "lastname" or "order"
     */
    public void quicksort(String sortParameter) {

        // Checks for the proper arguments and calls the appropriate method, or throws in error
        if (sortParameter.equals("lastname")) {
            quicksort(lastnameSorted, 0, lastnameSorted.size() - 1, sortParameter);
        } else if (sortParameter.equals("order")) {
            quicksort(orderNumberSorted, 0, lastnameSorted.size() - 1, sortParameter);
        } else {
            throw new IllegalArgumentException("sortParameter must be [lastname] or [order]");
        }
    }

    /**
     * Quicksort method which allows for sorting to be accomplished on two attributes in the IndividualOrder object.
     * @param list The list that contains the IndividualOrder objects to swap.
     * @param lowIndex The starting index number
     * @param highIndex The ending index number
     * @param sortParameter Tells quicksort which method to use in the partitioning phase
     */
    private void quicksort(List<IndividualOrder> list, int lowIndex, int highIndex, String sortParameter) {

        // Base case
        if (lowIndex >= highIndex) {
            return;
        }

        // Picks a random pivot so that quicksort gets better than average time complexity
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        // Swaps the pivot to end of the list
        swap(list, pivotIndex, highIndex);
        // Collects the pivot object from the list
        IndividualOrder pivotObject = list.get(highIndex);

        // Sets the pointers
        int leftIndex = lowIndex;
        int rightIndex = highIndex;

        // Partition based on the sort parameter
        if (sortParameter.equals("lastname")) {
            leftIndex = partitionLastname(list, pivotObject, leftIndex, rightIndex, highIndex);
        } else if (sortParameter.equals("order")) {
            leftIndex = partitionOrderNumber(list, pivotObject, leftIndex, rightIndex, highIndex);
        } else {
            return;
        }

        // Recursive calls
        quicksort(list, lowIndex, leftIndex - 1, sortParameter);
        quicksort(list, leftIndex + 1, highIndex, sortParameter);
    }

    /**
     * This method handles the partition phase of quicksort specifically using the compareLastname(IndividualOrder)
     * method in the IndividualOrder class. This uses the natural order to compare the strings.
     * @param list The list that contains the IndividualOrder objects to swap.
     * @param pivotObject The object that all other objects are being compared to
     * @param leftIndex The left pointer
     * @param rightIndex The right pointer
     * @param highIndex The last index in the comparable list
     * @return int The index of the left pointer
     */
    private int partitionLastname(List<IndividualOrder> list, IndividualOrder pivotObject,
                                  int leftIndex, int rightIndex, int highIndex) {

        // The left index is less than the right index
        while (leftIndex < rightIndex) {
            // The value of lastname in the left index is less than or equal the pivot and
            // the left index is still less than the right index
            while (list.get(leftIndex).compareLastname(pivotObject) >= 0 && leftIndex < rightIndex) {
                leftIndex++;
            }
            // The value of lastname in the right index is greater than or equal the pivot and
            // the left index is still less than the right index
            while (list.get(rightIndex).compareLastname(pivotObject) <= 0 && leftIndex < rightIndex) {
                rightIndex--;
            }
            // Swaps when the pointers have values that break the loop conditions.
            swap(list, leftIndex, rightIndex);
        }

        // If the left index is greater than the highest index swap, otherwise assign the high index to left index
        if(list.get(leftIndex).compareLastname(list.get(highIndex)) < 0) {
            swap(list, leftIndex, highIndex);
        }
        else {
            leftIndex = highIndex;
        }
        return leftIndex; // Returns the new index for the left pointer
    }

    /**
     * This method handles the partition phase of quicksort specifically using the compareOrderNumber(IndividualOrder)
     * method in the IndividualOrder class.
     * @param list The list that contains the IndividualOrder objects to swap.
     * @param pivotObject The object that all other objects are being compared to
     * @param leftIndex The left pointer
     * @param rightIndex The right pointer
     * @param highIndex The last index in the comparable list
     * @return int The index of the left pointer
     */
    private int partitionOrderNumber(List<IndividualOrder> list, IndividualOrder pivotObject,
                                  int leftIndex, int rightIndex, int highIndex) {

        // The left index is less than the right index
        while (leftIndex < rightIndex) {
            // The value of order number in the left index is less than or equal the pivot and
            // the left index is still less than the right index
            while (list.get(leftIndex).compareOrderNumber(pivotObject) >= 0 && leftIndex < rightIndex) {
                leftIndex++;
            }
            // The value of order number in the right index is greater than or equal the pivot and
            // the left index is still less than the right index
            while (list.get(rightIndex).compareOrderNumber(pivotObject) <= 0 && leftIndex < rightIndex) {
                rightIndex--;
            }
            // Swaps when the pointers have values that break the loop conditions.
            swap(list, leftIndex, rightIndex);
        }

        // If the left index is greater than the highest index swap, otherwise assign the high index to left index
        if(list.get(leftIndex).compareOrderNumber(list.get(highIndex)) < 0) {
            swap(list, leftIndex, highIndex);
        }
        else {
            leftIndex = highIndex;
        }
        return leftIndex; // Returns the new index for the left pointer
    }

    /**
     * Prints the sorted objects in both the lastname and order number list.
     */
    public void printAll() {
        System.out.println("\n<== DISPLAY PRINTING");
        System.out.println("<== Printing the orders sorted by lastname:");
        // Printing the lastname list
        for (IndividualOrder individualOrder : this.lastnameSorted) {
            individualOrder.print();
        }

        System.out.println("<== Printing the orders sorted by order number:");
        // Printing the order number list
        for (IndividualOrder individualOrder : this.orderNumberSorted) {
            individualOrder.print();
        }
    }

    /**
     * Removed the first order number found from the both lists
     * @param orderNumber The order number
     */
    public void remove(int orderNumber) {

        // Find a removes the order number from the list
        for (int i = 0; i < orderNumberSorted.size(); i++) {
            if (orderNumberSorted.get(i).getOrderNumber() == orderNumber) {
                orderNumberSorted.remove(i);
                break;
            }
        }

        // Find a removes the order number from the list
        for (int i = 0; i < lastnameSorted.size(); i++) {
            if (lastnameSorted.get(i).getOrderNumber() == orderNumber) {
                lastnameSorted.remove(i);
                break;
            }
        }
    }

    /**
     * Used by the quicksort and partition methods to swap objects in the lists.
     * @param list The list that contains the IndividualOrder objects to swap
     * @param index1 The first index to swap
     * @param index2 The second index to swap
     */
    private void swap(List<IndividualOrder> list, int index1, int index2) {
        IndividualOrder tmp = list.get(index1); // Holding the object in a tmp variable
        list.set(index1, list.get(index2)); // Assigning index2 to index 1
        list.set(index2, tmp); // Assigning tmp to index2
    }
}