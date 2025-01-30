package com.stacksandqueues.circulartourproblem;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int checkingStartingPoint(int[] petrol,int[] distance){
        Queue<Integer> queue = new LinkedList<>();
        int lengthOfArr = petrol.length;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < lengthOfArr; i++) {
            sum += petrol[i] - distance[i]; // Update fuel balance
            queue.offer(i); // Add current pump index to the queue

            // If balance is negative, reset the queue and move start
            while (sum < 0 && !queue.isEmpty()) {
                int removed = queue.poll(); // Remove the front element
                sum -= (petrol[removed] - distance[removed]); // Adjust balance
                start = removed + 1; // Move the start index forward
            }
        }
        return (sum>=0) ? start:-1;


    }

    public static void main(String[] args) {
        int [] petrol = {3,7,5,2,6,16,5,5,38,4,4,9,7,4,3,5,7};
        int [] price = {6,5,9,3,14,9,13,3,1,14,11,8,10,7,4,4,9};
        System.out.println("Starting petrol pump: "+checkingStartingPoint(petrol,price));
    }
}