package com.compareperformace;

public class SortingLargeDataEfficiency {
    public static void main(String[] args) {
        // Create a variable for array size and generate a random array
        int size = 1000;
        int[] array = generateArray(size);

        // Measure execution time for Bubble Sort
        double result1 = bubbleSort(array);

        // Measure execution time for Quick Sort
        double result2 = quickSort(array);

        // Measure execution time for Merge Sort
        double result3 = mergeSort(array);

        // Display results for the current size
        displayResult(result1, result2, result3, size);

        // Test sorting algorithms on a 10000 data size
        size = 10000;
        array = generateArray(size);
        result1 = bubbleSort(array);
        result2 = quickSort(array);
        result3 = mergeSort(array);
        displayResult(result1, result2, result3, size);

        // Test sorting algorithms on a 1000000 data size
        size = 1000000;
        array = generateArray(size);
        result1 = bubbleSort(array);
        result2 = quickSort(array);
        result3 = mergeSort(array);
        displayResult(result1, result2, result3, size);
    }

    // Generates an array of random integers between 1 and 100
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

    // Performs Quick Sort and returns execution time in milliseconds
    public static double quickSort(int[] array) {
        int low = 0, high = array.length - 1;
        double startTime = System.nanoTime();
        quickSortAlgo(array, low, high);
        double endTime = System.nanoTime();
        return (endTime - startTime) / 1e6;
    }

    // Recursive Quick Sort implementation
    public static void quickSortAlgo(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSortAlgo(array, low, pivot - 1);
            quickSortAlgo(array, pivot + 1, high);
        }
    }

    // Partitions the array using the last element as the pivot
    public static int partition(int[] array, int low, int high) {
        int pivotValue = array[high];
        int idx = low - 1;

        // Rearrange elements based on pivot comparison
        for (int i = low; i < high; i++) {
            if (pivotValue >= array[i]) {
                idx++;
                int temp = array[i];
                array[i] = array[idx];
                array[idx] = temp;
            }
        }

        // Swap pivot element to its correct position
        idx++;
        int temp = array[high];
        array[high] = array[idx];
        array[idx] = temp;

        return idx;
    }

    // Performs Merge Sort and returns execution time in milliseconds
    public static double mergeSort(int[] array) {
        int low = 0, high = array.length - 1;
        double startTime = System.nanoTime();
        mergeSortAlgo(array, low, high);
        double endTime = System.nanoTime();
        return (endTime - startTime) / 1e6;
    }

    // Recursive Merge Sort implementation
    public static void mergeSortAlgo(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        // Divide the array into two halves
        int mid = low + (high - low) / 2;
        mergeSortAlgo(array, low, mid);
        mergeSortAlgo(array, mid + 1, high);

        // Merge the sorted halves
        merge(array, low, high, mid);
    }

    // Merges two sorted subarrays
    public static void merge(int[] array, int low, int high, int mid) {
        int[] mergedArray = new int[high - low + 1];
        int index = 0, start1 = low, start2 = mid + 1;

        // Merge elements from both halves in sorted order
        while (start1 <= mid && start2 <= high) {
            if (array[start1] < array[start2]) {
                mergedArray[index++] = array[start1++];
            } else {
                mergedArray[index++] = array[start2++];
            }
        }

        // Copy remaining elements from left half
        while (start1 <= mid) {
            mergedArray[index++] = array[start1++];
        }

        // Copy remaining elements from right half
        while (start2 <= high) {
            mergedArray[index++] = array[start2++];
        }

        // Copy merged elements back to the original array
        System.arraycopy(mergedArray, 0, array, low + 0, mergedArray.length);
    }

    // Performs Bubble Sort and returns execution time in milliseconds
    public static double bubbleSort(int[] array) {
        boolean swapped;
        double startTime = System.nanoTime();

        // Perform multiple passes until no swaps are needed
        for (int i = 0; i < array.length; i++) {
            swapped = false;
            for (int j = 1; j < array.length - i - 1; j++) {
                if (array[j] > array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    swapped = true;
                }
            }

            // Stop sorting if array is already sorted
            if (!swapped) {
                break;
            }
        }

        double endTime = System.nanoTime();
        return (endTime - startTime) / 1e6;
    }
}
