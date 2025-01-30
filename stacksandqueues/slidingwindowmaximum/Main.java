package com.stacksandqueues.slidingwindowmaximum;
import java.util.ArrayDeque;
public class Main {
    public static void main(String[] args) {

        //Create a array to store the number
        int[] arr = {12, 54, 15, 1, 64, 13};

        //Create a deque
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        //Create a variable to store the window size
        int windowSize = 3;

        //Create  a array to store the maximum element of the window
        int[] maximumArray = new int[arr.length - windowSize + 1];

        int max = arr[0];

        //Take a loop to calculate the maximum number of the window size k
        for(int i=0; i<arr.length; i++){
            if(i < windowSize){
                deque.add(arr[i]);
                max = Math.max(max,arr[i]);
                maximumArray[0] = max;
            }else{
                int removingNumber = deque.removeFirst();
                int addingElement = arr[i];
                deque.add(arr[i]);
                if(addingElement >= max){
                    max = Math.max(addingElement,max);
                }else if(removingNumber == max){
                    max = addingElement;
                    for(int j : deque){
                        max = Math.max(j,max);
                    }
                }
                maximumArray[i-windowSize+1] = max;
            }
        }

        //Display maximumArray
        for(int i : maximumArray){
            System.out.print(i+" ");
        }
    }
}
