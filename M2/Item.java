/*
 * Assignment Title: Program 1 (On-Line Food Delivery Service)
 * Name: Danny Caperton
 * School: Colorado State University Global
 * Course: 22WD-CSC400-1
 * Instructor: Dr. Shaher Daoud
 * Due Date: February 26, 2023
 */

package com.dancaps.m2;

/** The Item class represents an item for sale. It contains a name and price.
 */
public class Item {
    private String name; // The name of the item
    private double price; // The price of the item

    public Item(String name, double price) {
        // Constructor to initialize the item
        this.name = name;
        this.price = price;
    }

    /** Gets the price of the item.
     *  @return double
     */
    public double getPrice() {
        return price;
    }

    /** Allows the price of the item to be changed only if it is greater than 0.
     *  @parameter double
     */
    public void setPrice(double price) {
        // Tests that the new price is not a negative number
        if (price >= 0) {
            this.price = price;
        }
    }

    /** Returns a formatted string of the Item fields
     *  @return String
     */
    @Override
    public String toString() {
        return  "\n\t\t" + "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
