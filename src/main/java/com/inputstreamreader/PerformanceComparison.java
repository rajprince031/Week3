package com.inputstreamreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PerformanceComparison {

    public static void main(String[] args) {
        // Part 1: StringBuilder vs StringBuffer
        String str = "hello";  // String to concatenate
        int iterations = 1000000;

        // Measure time for StringBuilder
        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(str);
        }
        long endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;
        System.out.println("Time taken using StringBuilder: " + stringBuilderTime + " nanoseconds");

        // Measure time for StringBuffer
        startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(str);
        }
        endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;
        System.out.println("Time taken using StringBuffer: " + stringBufferTime + " nanoseconds");

        // Part 2: FileReader and InputStreamReader to read a large file and count words

        // Create a variable and store the path of the file (Ensure this file exists on your system)
        String filename = "/Users/princeraj/Desktop/Capgemini-Training/Week3/Day4/src/main/java/com/inputstreamreader/demo.txt";

        // Measure time for reading and counting words
        try {
            startTime = System.nanoTime();
            int wordCount = countWordsInFile(filename);
            endTime = System.nanoTime();
            long fileReadTime = endTime - startTime;
            System.out.println("Time taken to read the file and count words: " + fileReadTime + " nanoseconds");
            System.out.println("Total words in the file: " + wordCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to count words in a file using FileReader and InputStreamReader
    private static int countWordsInFile(String filename) throws IOException {
        int wordCount = 0;

        // Using try-with-resources to automatically close resources after use
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;

            // Read the file line by line and count the words
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line into words using whitespace characters as delimiters
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        }

        return wordCount;
    }
}
