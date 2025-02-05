package com.challengeproblem;


import java.util.Arrays;

public class searchMissingPostiveNumber {

    public static void main(String[] args) {
        // Sample input
        int[] nums = {3, 4, -1, 1};
        int target = 4;

        // Linear Search for the first missing positive integer
        int firstMissing = findFirstMissingPositive(nums);
        System.out.println("First missing positive integer: " + firstMissing);

        // Binary Search for the index of a target number
        int targetIndex = binarySearch(nums, target);
        System.out.println("Index of target " + target + ": " + targetIndex);
    }

    // Linear Search for the first missing positive integer
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Mark numbers (negative marking)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                continue; // Ignore non-positive and out of range numbers
            }
            int index = Math.abs(nums[i]) - 1; // Find the index to mark
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // Mark as visited
            }
        }

        // Step 2: Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1; // The first unmarked index represents the first missing positive
            }
        }

        // If all numbers from 1 to n are present, return n + 1
        return n + 1;
    }

    // Binary Search for the index of the target number
    public static int binarySearch(int[] nums, int target) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Perform binary search
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is at mid
            if (nums[mid] == target) {
                return mid;
            }
            // If target is smaller, ignore the right half
            if (nums[mid] > target) {
                right = mid - 1;
            }
            // If target is larger, ignore the left half
            else {
                left = mid + 1;
            }
        }

        // If the target is not found
        return -1;
    }
}
