package com.stringbuffer;

// StringBuffer and StringBuilder are mutable classes and are used when we have to perform multiple operations on the string.
public class StringConcatPerformance {
    public static void main(String[] args) {

        // Concatenating strings using StringBuffer and StringBuilder
        int numString = 1000000;
        String str = "hello";

        long startTime;
        long endTime;

        StringBuffer stringBuffer = new StringBuffer("");

        // get the start time of the code execution in nanoseconds
        startTime = System.nanoTime();

        for(int i=0; i<numString; i++){
            stringBuffer.append(str);
        }

        // get the end time of the code execution in nanoseconds
        endTime = System.nanoTime();

        // calculate the duration of the code execution
        long stringBufferDuration = (endTime - startTime);

        StringBuilder stringBuilder = new StringBuilder("");

        // get the start time of the code execution in nano seconds
        startTime = System.nanoTime();

        for(int i=0; i<numString; i++){
            stringBuilder.append(str);
        }
        // get the end time of the code execution in nano seconds
        endTime = System.nanoTime();

        // calculate the duration of the code execution
        long stringBuilderDuration = (endTime - startTime);

        //Display the time taken by StringBuffer and StringBuilder
        System.out.println("Total time taken by StringBuffer : "+ stringBufferDuration);

        System.out.println("Total time taken by StringBuilder : "+stringBuilderDuration);
    }

}
