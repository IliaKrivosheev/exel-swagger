package com.comfort.soft.exel.util;

import com.comfort.soft.exel.exception.InvalidNthMaxException;

/**
 * Utility class for validating input data.
 * Contains static methods for checking the correctness
 * of data used in calculations of the N-th maximum number.
 */
public class ValidationUtil {
    private ValidationUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Checks the input data before performing operations
     * on the array of numbers.
     *
     * <p>Verifies that the value of N is greater than 0 and that the array
     * is not empty. Otherwise, throws
     * {@link InvalidNthMaxException} with an appropriate message.</p>
     *
     * @param arrayLength The length of the array of integers.
     * @param n           The order of the maximum number to find.
     * @throws InvalidNthMaxException If the value of N is less than or equal to 0
     *                                or if the array is empty.
     */
    public static void checkInputData(int arrayLength, int n) {
        if (n <= 0) {
            throw new InvalidNthMaxException("The value of N must be greater than 0.");
        }
        if (arrayLength == 0) {
            throw new InvalidNthMaxException("The array is empty, it is impossible to find the N-th maximal number.");
        }
    }

    /**
     * Checks if the queue is empty.
     *
     * <p>If the queue is empty, throws
     * {@link InvalidNthMaxException} with an appropriate message.</p>
     *
     * @param isEmptyQueue A condition indicating whether the queue is empty.
     * @throws InvalidNthMaxException If the queue is empty.
     */
    public static void checkQueue(boolean isEmptyQueue) {
        if (isEmptyQueue) {
            throw new InvalidNthMaxException("The queue is empty, it is impossible to find the N-th maximal number.");
        }
    }
}
