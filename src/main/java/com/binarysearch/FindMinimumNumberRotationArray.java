package com.binarysearch;

public class FindMinimumNumberRotationArray {

    //Method that finds the rotational point of the array using binary search
    public static int findMinimumNumber(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(arr[mid] > arr[mid+1]){
                return mid+1;
            }else if(arr[mid] > arr[high]){
                low = mid;
            }else{
                high = mid;
            }
        }

        //If not find the rotational point it means the rotational point is 0.
        return 0;
    }
    public static void main(String[] args) {

        //Create a array that stores the rotated array
        int[] array = {1,1,1,1,2,3,4,5,6,7,8,9,10,1,1,1,1,1,1,1};

        //it stores the index of rotational point of the array
        int index = findMinimumNumber(array);

        //Print the index of rotational point
        System.out.println(index);
    }
}
