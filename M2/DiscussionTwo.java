package com.dancaps.m2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DiscussionTwo {

    public static void main(String[] args) {

        // This demonstrates creating an empty string array
        String[] arr1 = new String[10];
        System.out.println("Empty String Array: " + Arrays.toString(arr1));
        System.out.println();

        // This demonstrates creating an array with data
        String[] arr2 = {"Hello", "My", "Name", "Is", "Danny"};
        System.out.println("Populated String Array: " + Arrays.toString(arr2));
        System.out.println();

        // This demonstrates creating and using an array list
        List<Integer> numbers = new ArrayList<>(3);
        numbers.add(10);
        numbers.add(50);
        numbers.add(99);
        System.out.println("Initially created ArrayList with 3 entries and a capacity of 3: " + numbers);
        numbers.add(1, 45);
        System.out.println("After adding 45 to index 1. This forces a resize since the initial capacity was 3: " + numbers);
        numbers.clear();
        System.out.println("Cleared ArrayList: " + numbers);
        System.out.println();

        // This demonstrates creating and using an array list
        List<Character> chars = new LinkedList<Character>();
        chars.add('A');
        chars.add('B');
        chars.add('C');
        System.out.println("Initially created LinkedList with 3 entries. No typical needed: " + chars);
        chars.add(1, 'Z');
        System.out.println("After adding Z to index 1: " + chars);
        chars.clear();
        System.out.println("Cleared LinkedLst: " + chars);
    }

        // This demonstrates resizing a string array
//        String[] arr3 = {"This", "Is", "Interesting", "!"};
//        System.out.println("Contents of arr3: " + Arrays.toString(arr3));
//        System.out.println("The size of arr3 is: " + arr3.length);
//        System.out.println("Resizing the arr3 to 10");
//        arr3 = resizeStringArray(arr3, 10);
//        System.out.println(Arrays.toString(arr3));
//        System.out.println("The new size of arr3 is now: " + arr3.length);
//        System.out.println("Contents of arr3: " + Arrays.toString(arr3));
//        // This demonstrates creating and using an array list
//        List<Integer> numbers = new ArrayList<>(3);
//        numbers.add(10);
//        numbers.add(50);
//        numbers.add(99);
//        System.out.println("Initially created ArrayList with 3 entries and a capacity of 3: " + numbers);
//        numbers.add(1, 45);
//        System.out.println("After adding 45 to index 1. This forces a resize since the initial capacity was 3: " + numbers);
//        numbers.clear();
//        System.out.println("Cleared ArrayList: " + numbers);    }

    public static <T> T[] resizeArray(T[] arr, int newSize) {

        // Creates a new array with the new size
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[newSize];

        // Returns the provided array if the new size is not larger
        if (newSize < arr.length) { return arr; }
        else {
            // Copies the contents of arr into the new array
            for (int index = 0; index < arr.length; index++) {
                result[index] = arr[index];
            }
        }
        return result;
    }
}
