package com.binarysearch;


public class BinarySearchOccurrences {

    public static void main(String[] args) {
        // Sample input
        int[] nums = {1, 2, 2, 2, 3, 4, 4, 5};
        int target = 2;

        // Find first and last occurrence of the target element
        int[] result = findFirstAndLastOccurrence(nums, target);

        if (result[0] == -1) {
            System.out.println("Element " + target + " not found in the array.");
        } else {
            System.out.println("First occurrence of " + target + ": " + result[0]);
            System.out.println("Last occurrence of " + target + ": " + result[1]);
        }
    }

    // Method to find the first and last occurrence of the target element
    public static int[] findFirstAndLastOccurrence(int[] nums, int target) {
        int[] result = {-1, -1}; // Initialize the result array with -1

        // Find the first occurrence
        result[0] = binarySearch(nums, target, true);

        // If the first occurrence is not found, return -1, -1
        if (result[0] == -1) {
            return result;
        }

        // Find the last occurrence
        result[1] = binarySearch(nums, target, false);

        return result;
    }

    // Binary search to find the first or last occurrence of a target
    // If 'findFirst' is true, search for the first occurrence
    // If 'findFirst' is false, search for the last occurrence
    public static int binarySearch(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;

                // If we're looking for the first occurrence, move left
                if (findFirst) {
                    right = mid - 1;
                }
                // If we're looking for the last occurrence, move right
                else {
                    left = mid + 1;
                }
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
