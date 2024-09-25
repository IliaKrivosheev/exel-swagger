package com.comfort.soft.exel.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

import static com.comfort.soft.exel.util.ValidationUtil.checkInputData;

/**
 * Service for finding the N-th maximum number from an array of integers
 * using a custom implementation of the algorithm.
 */
@Service
public class MaxNumberService2 {

    /**
     * Finds the N-th maximum number from an array of integers.
     *
     * <p>Uses an array to store the N largest numbers.
     * While iterating through the numbers in the input array,
     * if the current number is greater than the smallest number in
     * the array of maximum numbers, it is inserted
     * in the correct position to maintain order.</p>
     *
     * @param numbers The array of integers from which to find the N-th maximum number.
     * @param n       The order of the maximum number to find (must be greater than 0).
     * @return The N-th maximum number in the array.
     * @throws IllegalArgumentException If the array is empty or n is less than or equal to 0.
     */
    public int findNthMax(int[] numbers, int n) {
        checkInputData(numbers.length, n);

        int[] maxNumbers = new int[Math.min(numbers.length, n)];
        Arrays.fill(maxNumbers, Integer.MIN_VALUE);

        for (int number : numbers) {
            if (number > maxNumbers[0]) {
                insertInOrder(maxNumbers, number);
            }
        }

        return maxNumbers[0];
    }

    /**
     * Inserts a number into the array of maximum numbers in descending order.
     *
     * <p>Updates the array by shifting elements to ensure the new number
     * is in the correct position, maintaining order.</p>
     *
     * @param maxNumbers The array into which the new number will be inserted.
     * @param number     The number to insert.
     */
    private void insertInOrder(int[] maxNumbers, int number) {
        int i;
        for (i = 1; i < maxNumbers.length && maxNumbers[i] < number; i++) {
            maxNumbers[i - 1] = maxNumbers[i];
        }
        maxNumbers[i - 1] = number;
    }

}
