package com.comfort.soft.exel.service;

import org.springframework.stereotype.Service;

import java.util.PriorityQueue;

import static com.comfort.soft.exel.util.ValidationUtil.checkInputData;
import static com.comfort.soft.exel.util.ValidationUtil.checkQueue;

/**
 * Service for finding the N-th maximum number from an array of integers.
 * <p>Uses a min-heap (PriorityQueue) to store the N largest numbers. If the size of the heap exceeds N,
 * the smallest element is removed.</p>
 */
@Service
public class MaxNumberService {

    /**
     * Finds the N-th maximum number from an array of integers.
     *
     * @param numbers The array of integers from which to find the N-th maximum number.
     * @param n       The order of the maximum number to find (must be greater than 0).
     * @return The N-th maximum number in the array.
     * @throws IllegalArgumentException If the array is empty, n is less than or equal to 0, or no numbers are found
     *                                  as a result of execution.
     */
    public int findNthMax(int[] numbers, int n) {
        checkInputData(numbers.length, n);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n);

        for (int number : numbers) {
            minHeap.add(number);
            if (minHeap.size() > n) {
                minHeap.poll();
            }
        }

        checkQueue(minHeap.isEmpty());

        return minHeap.peek();
    }
}
