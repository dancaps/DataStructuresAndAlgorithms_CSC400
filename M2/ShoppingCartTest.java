/*
 * Assignment Title: Program 1 (On-Line Food Delivery Service)
 * Name: Danny Caperton
 * School: Colorado State University Global
 * Course: 22WD-CSC400-1
 * Instructor: Dr. Shaher Daoud
 * Due Date: February 26, 2023
 */

package com.dancaps.m2;

public class ShoppingCartTest {
    public static void main(String[] args) {

        // Creating a shopping cart
        ShoppingCart sc = new ShoppingCart();

        // Filling the cart so that it is full
        System.out.println("<== Filling the cart with 5 items. This is the default capacity of the cart.");
        sc.add(new Item("Milk", 7.50));
        sc.add(new Item("Eggs", 2.50));
        sc.add(new Item("Milk", 4.50));
        sc.add(new Item("Bread", 5.50));
        sc.add(new Item("Meat", 5.00));

        // Showing the cart is full
        System.out.println("<== Displaying the full cart.");
        System.out.println(sc);
        System.out.println("<== Showing the number of products field matches the length of the array.");
        System.out.println("<== The numberOfProducts field: " + sc.getNumberOfProducts());
        System.out.println("<== The length of the array:    " + sc.toArray().length);

        // Adding a new item to demonstrate the dynamic resizing of the cart
        System.out.println("<== Adding another item so that the array will be dynamically resized.");
        sc.add(new Item("Chicken", 4.50));
        System.out.println("<== The new item has been added: " + sc.getNumberOfProducts());
        System.out.println("<== The length of the array is now doubled in size: " + sc.toArray().length);

        // Displaying the fields of the cart, including all the items
        System.out.println("<== Showing all the items in the cart again.");
        System.out.println(sc);

        // Showing the total field properly displays the total cost of all the items.
        System.out.println("<== Showing the total price of the items in the cart: $" + sc.getTotal());
    }
}
