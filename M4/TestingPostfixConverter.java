/*
 * Assignment Title: Java Postfix Converter
 * Name: Danny Caperton
 * School: Colorado State University Global
 * Course: 22WD-CSC400-1
 * Instructor: Dr. Shaher Daoud
 * Due Date: March 12, 2023
 */

package com.dancaps.m4;

public class TestingPostfixConverter {
    public static void main(String[] args) {

        PostfixConverter converter = new PostfixConverter(); // Creates the PostfixConvert object

        System.out.println("<== Displaying Precedence Order");
        System.out.println("\t<== Default precedence: " + converter.getPrecedence()); // Prints the default precedence

        try {
            System.out.println("<== Test 1");
            System.out.println("\t<== Testing infix input value:   a/b*(c+(d-e))");
            System.out.println("\t<== Expected postfix output value: ab/cde-+*");
            System.out.println("\t<== Actual postfix output value:   " +
                    converter.getPostfixExpression("a/b*(c+(d-e))"));

            System.out.println("<== Test 2");
            System.out.println("\t<== Testing infix input value:   (a+b)/(c-d)");
            System.out.println("\t<== Expected postfix output value: ab+cd−/");
            System.out.println("\t<== Actual postfix output value:   " +
                    converter.getPostfixExpression("(a+b)/(c-d)"));

            System.out.println("<== Test 3");
            System.out.println("\t<== Testing infix input value:   a/(b-c)*d");
            System.out.println("\t<== Expected postfix output value: abc−/d*");
            System.out.println("\t<== Actual postfix output value:   " +
                    converter.getPostfixExpression("a/(b-c)*d"));

            System.out.println("<== Test 4");
            System.out.println("\t<== Testing infix input value:   a-(b/(c-d)*e+f)^g");
            System.out.println("\t<== Expected postfix output value: abcd−/e*f+g^−");
            System.out.println("\t<== Actual postfix output value:   " +
                    converter.getPostfixExpression("a-(b/(c-d)*e+f)^g"));

            System.out.println("<== Test 5");
            System.out.println("\t<== Testing infix input value:   (a-b*c)/(d*e^f*g+h)");
            System.out.println("\t<== Expected infix output value: abc*−def^*g*h+/");
            System.out.println("\t<== Actual infix output value:   " +
                    converter.getPostfixExpression("(a-b*c)/(d*e^f*g+h)"));

            System.out.println("<== Test 6");
            System.out.println("\t<== Including invalid characters");
            System.out.println("\t<== Testing infix input value:   (a-$b*c)/(d*e^%f*#g+h)@");
            System.out.println("\t<== Expected infix output value: abc*−def^*g*h+/");
            System.out.println("\t<== Actual infix output value:   " +
                    converter.getPostfixExpression("(a-$b*c)/(d*e^%f*#g+h)@"));

            System.out.println("<== Test 7");
            System.out.println("\t<== Testing infix input value:   null");
            System.out.println("\t<== Expected infix output value: throws IllegalArgumentException");
            System.out.println("\t<== Actual infix output value:   " +
                    converter.getPostfixExpression(null));
        } catch (IllegalArgumentException e) {
            System.out.println("\t<== Oops, there was a " +e.getClass() + " error, with the message: " + e.getMessage());
        }
    }
}
