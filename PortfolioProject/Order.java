/*
 * Assignment Title: Portfolio Project
 * Name: Danny Caperton
 * School: Colorado State University Global
 * Course: 22WD-CSC400-1
 * Instructor: Dr. Shaher Daoud
 * Due Date: April 9, 2023
 */

package com.dancaps.m8;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Create a Order Class that uses a queue to hold the orders in the order they were taken.
 * The queue should contain the customer last name, order number, and order total cost.
 */
public class Order {

    // Attributes used in the Order
    private final LinkedList<IndividualOrder> orders = new LinkedList<>(); // Holds the orders as they are received
    private final Display display = new Display(); // Instantiates a Display object
    private int orderNumber = 1; // Starts the count of order numbers

    /**
     * Creates a new order. Prompts for user input for the order details. Adds the order to the display object.
     * Prints the order to the screen.
     */
    public void createOrder() {

        // Creates a scanner for user input
        Scanner input = new Scanner(System.in);

        // Gets the lastname for the order from the user
        System.out.print("\nEnter the lastname on the order: ");
        String lastname = input.nextLine();

        // Gets the order total from the users
        System.out.print("Enter the order total: ");
        double orderTotal = input.nextDouble();

        // Creates an IndividualOrder object
        IndividualOrder newOrder = new IndividualOrder(this.orderNumber++, lastname, orderTotal);
        orders.addLast(newOrder); // Adds the object to the end of the local orders list
        display.add(newOrder); // Adds the order object to the display object

        // Outputs the order back to the user.
        System.out.println("\n<== ORDER PRINTING");
        System.out.println("<== The following order was entered:");
        newOrder.print();
    }

    /**
     * Prints all the order in the order they were received from the order class. In addition, the display class
     * prints both sorted orders.
     */
    public void printAllOrders() {

        System.out.println("\n<== ORDERS PRINTING");
        System.out.println("<== Printing all orders");

        // Printing all the orders in the order they were received
        for (IndividualOrder individualOrder : orders) {
            System.out.println("Order Number: " + individualOrder.getOrderNumber() +
                    ", Lastname: " + individualOrder.getLastname() +
                    ", Order Total: $" + individualOrder.getOrderTotal());
        }
        display.printAll(); // Prints the sorted lists in display
    }

    /**
     * Searches the order list and prints the order details if it is found.
     */
    public void printOrder() {

        boolean isFound = false;

        //Prompt the user for the order number
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the order number: ");
        orderNumber = input.nextInt();

        // Searches for the order based on the order number. Stops after the first instance is found. Prints the order
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNumber() == orderNumber) {
                orders.get(i).print(); // Prints the order
                isFound = true; // The order was found
                break; // Stops searching the list
            }
        }

        // Telling the user the order was not found
        if (!isFound) {
            System.out.println("\n<== ORDER PRINTING");
            System.out.println("<== That order was not found. Please try again.");
        }
    }

    /**
     * Prompts the users for the order number. If the order is found it is removed from the local orders and a request
     * is sent to remove the order from the display object. Only the first instance of the order number is removed.
     */
    public void removeOrder() {

        //Prompt the user for the order number
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the order number: ");
        orderNumber = input.nextInt();

        // Searches for the order based on the order number. Stops after the first instance is found
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNumber() == orderNumber) {
                orders.remove(i); // Removes the order from the local orders list
                display.remove(orderNumber); // Sends the order number to the display to remove it
                break; // Stops searching the list
            }
        }

        // Output to the user
        System.out.println("\n<== ORDER PRINTING");
        System.out.println("<== Order number " + orderNumber + " has been removed." );
    }
}