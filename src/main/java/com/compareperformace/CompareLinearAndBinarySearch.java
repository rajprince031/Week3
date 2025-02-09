package com.compareperformace;

import java.util.Arrays;

public class CompareLinearAndBinarySearch {
    public static void main(String[] args) {
        // Testing with an array of size 1000
        int size = 1000;
        int[] array = generateArray(size);

        // Measure time taken by Linear Search for the number 55
        double result1 = linearSearch(array, 55, size);

        // Measure time taken by Binary Search for the number 55
        double result2 = binarySearch(array, 55, size);

        // Display the results
        displayResult(result1, result2, size);

        // Testing with array of size 10,000
        size = 10000;
        array = generateArray(size);
        result1 = linearSearch(array, 99, size);
        result2 = binarySearch(array, 99, size);
        displayResult(result1, result2, size);

        // Testing with array of size 1,000,000
        size = 1000000;
        array = generateArray(size);
        result1 = linearSearch(array, 56, size);
        result2 = binarySearch(array, 56, size);
        displayResult(result1, result2, size);
    }

    // Prints out the time taken by Linear and Binary search
    public static void displayResult(double result1, double result2, int size) {
        System.out.println("For Data Size "+ size +" Time Taken by Linear Search: " + result1 + " ms");
        System.out.println("For Data Size "+ size +" Time Taken by Binary Search: " + result2 + " ms");
        System.out.println("=====================================================");
    }

    // Generates an array filled with random numbers between 1 and 100
    public static int[] generateArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 100) + 1;
        }
        return array;
    }

    // Displays the time taken by each sorting algorithm
    public static void displayResult(double result1, double result2, double result3, int size) {
        System.out.println("Time Taken by Bubble Sort: " + result1 + " ms for size " + size);
        System.out.println("Time Taken by Quick Sort: " + result2 + " ms for size " + size);
        System.out.println("Time Taken by Merge Sort: " + result3 + " ms for size " + size);
        System.out.println("=====================================================");
    }

    // Performs Linear Search and measures the execution time
    public static double linearSearch(int[] array, int target, int size) {
        double startTime = System.nanoTime();

        // Go through the array one element at a time
        for (int i = 0; i < size; i++) {
            if (array[i] == target) {
                // Found the target, return current time
                return System.nanoTime();
            }
        }

        double endTime = System.nanoTime();
        return (endTime - startTime) / 1e6;
    }

    // Performs Binary Search and measures the execution time
    public static double binarySearch(int[] array, int target, int size) {
        // Sorting the array first (Binary Search requires a sorted array)
        Arrays.sort(array);

        int low = 0, high = size - 1;
        double startTime = System.nanoTime();
        double endTime;

        // Keep narrowing down the search range
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If the middle element is the target, return the time
            if (array[mid] == target) {
                endTime = System.nanoTime();
                return (endTime - startTime) / 1e6;
            }
            // If target is smaller, search in the left half
            else if (array[mid] > target) {
                high = mid - 1;
            }
            // If target is larger, search in the right half
            else {
                low = mid + 1;
            }
        }

        // If the number wasn't found, return the total search time
        endTime = System.nanoTime();
        return (endTime - startTime) / 1e6;
    }
}
