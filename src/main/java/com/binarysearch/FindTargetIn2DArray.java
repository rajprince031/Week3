package com.binarysearch;

public class FindTargetIn2DArray {
    public static void main(String[] args) {

        //Create a array that stores the 2D array
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};

        // Create a target variable that stores the target value.
        int target = 9;
        //it stores the result after searching
        boolean result = findTarget(array, target);
        //Print the result
        if(result){
            System.out.println("Number is present in the array");
        }else{
            System.out.println("Number is not present in the array");

        }
    }

    //Create a method that check the target value present in the 2D array
    private static boolean findTarget(int[][] array, int target) {

        //Create a row variable that stores the number of rows in the array
        int row = array.length;

        //Create a column variable that stores the number of column in the array
        int column = array[0].length;
        int low = 0;
        int high = row * column - 1;

        //Taking three variable that store the mid-index, row of mid-index, column of mid-index
        int mid, i, j;
        while(low <= high){
            mid = low + (high - low)/2;

            //From the mid-index we find the current row and column of mid-index using formula
            // Row = currentIndex / Total no. of column.
            // Column = currentIndex % Total no. of column.
            i = mid / column;
            j = mid % column;

            //Check if the target value present at mid-index, if yes return true.
            //Otherwise, we decrease the searching size of the array
            if(array[i][j] == target){
                return true;
            }else if(array[i][j] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        // if the target value is not found the array return false
        return false;
    }
}
