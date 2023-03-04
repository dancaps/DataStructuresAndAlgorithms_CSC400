/*
 * Assignment Title: Program 1 (On-Line Food Delivery Service)
 * Name: Danny Caperton
 * School: Colorado State University Global
 * Course: 22WD-CSC400-1
 * Instructor: Dr. Shaher Daoud
 * Due Date: February 26, 2023
 */

package com.dancaps.m2;

import java.util.Arrays;

/** Shopping cart implements the custom BagInterface for Items.
 *  The features include a dynamically resized array containing the Item objects,
 *  the ability to add new Items to the cart, and a running total of the total price
 *  of the items in the cart.
 */
public class ShoppingCart implements BagInterface {

    final int DEFAULT_CAPACITY = 5; // Default array capacity
    Item[] cart; // The cart contains the items
    int numberOfProducts; // The number of items in the cart
    double total; // The running total cost of the items in the cart

    public ShoppingCart() {
        // Constructor that initializes all the fields
        this.cart = new Item[DEFAULT_CAPACITY];
        this.numberOfProducts = 0;
        this.total = 0.0;
    }

    /** Adds an item to the end of an array. Resizes the array if necessary.
     *  @parameter Item object
     *  @return boolean (true)
     */
    @Override
    public boolean add(Item item) {
        // If the cart is full a new cart is created that is 2x the current size
        if (isFull()){
            Item[] tmp = new Item[numberOfProducts * 2];
            System.arraycopy(cart, 0, tmp, 0, this.cart.length);
            this.cart = tmp;
        }
        // The item is added to the cart
        this.cart[numberOfProducts] = item;
        // The number of products is increased
        this.numberOfProducts++;
        // The price is updated with the new item
        total += item.getPrice();
        // Always returns true
        return true;
    }

    /** Checks if the array is full
     *  @return boolean (true or false)
     */
    @Override
    public boolean isFull() {
        // Tests if the cart is full
        return this.cart.length == this.numberOfProducts;
    }

    /** Gets the back-end array and returns it to the user.
     *  @return Item[]
     */
    @Override
    public Item[] toArray() {
        // Returns the cart as an array
        return cart;
    }

    /** Gets the in the cart
     *  @return int
     */
    public int getNumberOfProducts() {
        // Returns the number of items in the cart
        return numberOfProducts;
    }

    /** Gets the price total for the cart.
     *  @return double
     */
    public double getTotal() {
        // Returns the total price of the cart
        return total;
    }

    /** Returns the cart into an easy-to-read format.
     *  @return String
     */
    @Override
    public String toString() {
        // Formats the return string into an easy to read format
        return "ShoppingCart{" +
                "\n\tDEFAULT_CAPACITY=" + DEFAULT_CAPACITY +
                ", \n\tcart=" + Arrays.toString(cart) +
                ", \n\tnumberOfProducts=" + numberOfProducts +
                ", \n\ttotal=$" + total +
                '}';
    }
}
