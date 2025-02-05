package com.binarysearch;

public class FindPeekOfTheArray {
    public static void main(String[] args) {

        //Create a array that stores the rotated array
        int[] array = {6,3,2,1};

        //it stores the index of peek element
        int index = findPeek(array);

        //Print the index of rotational point
        System.out.println(index);
    }

    //Method that return the peak of the array using binary search
    private static int findPeek(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while(low < high){
            int mid = low + (high - low)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }else if(arr[mid] < arr[mid - 1]){
                high = mid - 1;
            }else if(arr[mid] < arr[mid+1]){
                low = mid + 1;
            }
        }
        return high;
    }

}
