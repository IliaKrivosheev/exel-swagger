package com.comfort.soft.exel.exception;

/**
 * Exception that is thrown in case of an invalid value
 * for finding the N-th maximum number.
 */
public class InvalidNthMaxException extends RuntimeException {

    /**
     * Creates a new exception with the specified message.
     *
     * @param message A message describing the reason for the exception.
     */
    public InvalidNthMaxException(String message) {
        super(message);
    }
}
