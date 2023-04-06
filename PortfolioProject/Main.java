/*
 * Assignment Title: Portfolio Project
 * Name: Danny Caperton
 * School: Colorado State University Global
 * Course: 22WD-CSC400-1
 * Instructor: Dr. Shaher Daoud
 * Due Date: April 9, 2023
 */

package com.dancaps.m8;

import java.util.Scanner;

/**
 * Assignment title: Order List Handler for an Online Retailer
 * Assignment requirements:
 *     Your Portfolio Project for CSC400 consists of the following:
 *     Write a program that handles the order list for an online retailer. Your program should contain a
 *     minimum of three classes:
 *         Order Class
 *         Display Class
 *         Main Class
 *     Create an Order Class that uses a queue to hold the orders in the order they were taken.
 *         The queue should contain the customer last name, order number, and order total cost.
 *     Create a Display Class that will store a copy of the order queue in two arrays.
 *         Each array will contain the order list but one will be sorted by name and the other sorted by order number.
 *         When an order is taken and stored in the Order Class the program will update the
 *         Display Class arrays automatically and sort them in descending order using quick sort and
 *         outputs the contents to the console upon each entry of new data.
 *     Create a Main Class that will handle operator data input and when an order is added or removed,
 *         the program will update the Order Class and Display Class. The user will be presented a menu
 *         to add an order, remove an order and display the order list from the queue.
 */
public class Main {

    public static void main(String[] args) {

        // Attributed needed by the menu
        Order order = new Order(); // Instantiates the order
        String userInput; // Holds the user input

        // Starting output
        System.out.println("\nWelcome to the online ordering system.");

        do {
            // The main menu
            System.out.println("\n::MAIN MENU::");
            System.out.println("Enter [1] to create a new order.");
            System.out.println("Enter [2] to remove an existing order.");
            System.out.println("Enter [3] to print your order based on order number.");
            System.out.println("Enter [4] to print all existing orders.");
            System.out.println("Enter [q] to to quit the program.");
            System.out.print("Enter your selection: ");

            // Collecting the menu selection
            Scanner input = new Scanner(System.in);
            userInput = input.next().toLowerCase();

            // Calling controller which is the order class to execute and manage the program logic
            switch (userInput) {
                case "1" -> order.createOrder();
                case "2" -> order.removeOrder();
                case "3" -> order.printOrder();
                case "4" -> order.printAllOrders();
                case "q" -> System.out.println("\n<== Quiting the program");
                default -> System.out.println("\n<== Invalid selection, please try again.");
            }
        } while (!userInput.equals("q")); // Quits when either lowercase or uppercase q is selected
    }
}