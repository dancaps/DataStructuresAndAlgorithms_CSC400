/*
 * Assignment Title: Program 1 (On-Line Food Delivery Service)
 * Name: Danny Caperton
 * School: Colorado State University Global
 * Course: 22WD-CSC400-1
 * Instructor: Dr. Shaher Daoud
 * Due Date: February 26, 2023
 */

package com.dancaps.m2;

/** My bag interface that follows the specification of the CSC400
 *  Critical Thinking Assignment in Module 2
 */
public interface BagInterface {

    /** Adds an item to the end of an array. Resizes the array if necessary.
     *  @parameter Item object
     *  @return boolean (true)
     */
    public boolean add(Item item);

    /** Checks if the array is full
     *  @return boolean (true or false)
     */
    public boolean isFull();

    /** Gets the back-end array and returns it to the user.
     *  @return Item[] array
     */
    public Item[] toArray();
}
