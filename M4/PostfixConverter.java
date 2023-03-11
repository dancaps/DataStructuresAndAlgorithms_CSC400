/*
 * Assignment Title: Java Postfix Converter
 * Name: Danny Caperton
 * School: Colorado State University Global
 * Course: 22WD-CSC400-1
 * Instructor: Dr. Shaher Daoud
 * Due Date: March 12, 2023
 */

package com.dancaps.m4;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;
import java.util.Stack;

/**
 * Converts algebraic expressions into postfix expressions.
 */
public class PostfixConverter {
    // Stores the character to integer mapping of the order of operations precedence
    HashMap<Character, Integer> precedence = new HashMap<>(6);

    /**
     * Constructor which adds the operators and their default precedence order
     */
    public PostfixConverter() {
        this.precedence.put('(', 0);
        this.precedence.put('+', 1);
        this.precedence.put('-', 1);
        this.precedence.put('*', 2);
        this.precedence.put('/', 2);
        this.precedence.put('^', 3);
    }

    /**
     * Gets the default precedence for the order of operations of the PostfixConverter class.
     * The higher the number value, the greater the precedence of the key value.
     * @return HashMap Character k, Integer v
     */
    public HashMap<Character, Integer> getPrecedence() {
        return precedence;
    }

    /**
     * Takes a string value of the infix algebraic expression and converts it to a postfix expression.
     * Throws an IllegalArgumentException if null is the input.
     * Example input: "a/b*(c+(d-e))"
     * Example output: "ab/cde-+*"
     * @param infixExpression String
     * @return String
     * @throws IllegalArgumentException if null is the input.
     */
    public String getPostfixExpression(String infixExpression) throws IllegalArgumentException {
        if (infixExpression == null) {
            throw new IllegalArgumentException("null is not a valid input.");
        }
        Stack<Character> operandStack = new Stack<>(); // Creates a stack for the operands
        StringBuilder postfixExpression = new StringBuilder(); // Creates a string to hold the postfix expression
        CharacterIterator infix = new StringCharacterIterator(infixExpression); // Creates an iterator of the infix expression

        while (infix.current() != CharacterIterator.DONE) { // Checks if the string is done
            /* Ternary operator that assigns 'a' as the value if the current char is a letter, otherwise infix.current()
             * is assigned to currentChar */
            Character currentChar = Character.isLetter(infix.current()) ? 'a' : infix.current();

            switch (currentChar) {
                case 'a' -> // Allows all uppercase and lowercase letters to meet a single case
                        postfixExpression.append(infix.current()); // Must assign the infix.current() or it would assign 'a'
                case '^', '(' -> // Both cases always push to the top of the stack
                        operandStack.push(currentChar);
                case '+', '-', '*', '/' -> { // Applies to all four operands
                    // Uses the precedence HashMap to determine the precedence of the characters
                    while (!operandStack.isEmpty() &&
                          (precedence.get(currentChar) <= precedence.get(operandStack.peek()))) {
                        // Pops the tops of the stack and appends it to the postfix string
                        postfixExpression.append(operandStack.pop());
                    }
                    operandStack.push(currentChar); // Adds the currentChar to the top of the stack
                }
                case ')' -> { // Closing parentheses
                    char top = operandStack.pop(); // Popping allows us to easily discard the open parentheses
                    while (top != '(') { // While the top of the stack is not an opening parentheses
                        postfixExpression.append(top); // Add the top operand to the postfix expression
                        top = operandStack.pop(); // This is safe because we are still waiting on the open parentheses
                    }
                }
                default -> { // Does nothing in the event there is an undefined character
                }
            }
            infix.next(); // Gets the next character in the infix string to test against the loop
        }
        while (!operandStack.isEmpty()) { // If the stack is not empty
            postfixExpression.append(operandStack.pop()); // Pop the top of the stack and append it to the postfix expression
        }
        return postfixExpression.toString(); // Return the string value of the postfix expression
    }
}
