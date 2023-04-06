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
 * Assignment requirements: The queue should contain the customer last name, order number, and order total cost. I
 * decided to create a class to store that information for each order.
 */
public class IndividualOrder {

    // The required fields
    private final String lastname;
    private final double orderTotal;
    private final int orderNumber;

    /**
     * Constructor to initialize the attributes.
     * @param orderNumber Integer
     * @param lastname String
     * @param orderTotal Double
     */
    public IndividualOrder(int orderNumber, String lastname, double orderTotal) {
        this.orderNumber = orderNumber;
        this.lastname = lastname;
        this.orderTotal = orderTotal;
    }

    /**
     * Uses string compareTo to compare the lastname.
     * @param individualOrder IndividualOrder
     * @return Less than = negative; Greater than = positive, Equals = 0
     */
    public int compareLastname(IndividualOrder individualOrder) {
        return this.lastname.compareTo(individualOrder.getLastname());
    }

    /**
     * Uses the order integer to compare the order numbers.
     * @param individualOrder IndividualOrder
     * @return Less than = negative; Greater than = positive, Equals = 0
     */
    public int compareOrderNumber(IndividualOrder individualOrder) {
        return this.orderNumber - individualOrder.getOrderNumber();
    }

    /**
     * Gets and returns the lastname attribute.
     * @return String lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Gets and returns the order total attribute.
     * @return Double orderTotal
     */
    public double getOrderTotal() {
        return orderTotal;
    }

    /**
     * Gets and returns the order number attribute.
     * @return Integer orderNumber
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Prints the attributes of the order.
     */
    public void print() {
        System.out.println("Order Number: " + getOrderNumber() +
                ", Lastname: " + getLastname() +
                ", Order Total: $" + getOrderTotal());
    }

    /**
     * Overrides the toString() method.
     * @return String
     */
    @Override
    public String toString() {
        return "IndividualOrder{" +
                "orderNumber='" + orderNumber + '\'' +
                ", lastname=" + lastname +
                ", orderTotal=" + orderTotal +
                '}';
    }
}