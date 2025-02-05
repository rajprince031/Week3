package com.inputstreamreader;
import java.io.*;

public class WriteInputToFile {
    public static void main(String[] args) {
        // Create an InputStreamReader to read from the console
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        // Wrap InputStreamReader in BufferedReader for efficient reading
        BufferedReader reader = new BufferedReader(inputStreamReader);

        //Create a variable and store the path of the file
        String filename = "/Users/princeraj/Desktop/Capgemini-Training/Week3/Day4/src/main/java/com/inputstreamreader/demo.txt";


        // Create a FileWriter to write to the file (Append mode)
        try (FileWriter fileWriter = new FileWriter(filename, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            String line;

            // Prompt the user for input
            System.out.println("Enter your input (type 'exit' to stop):");

            // Read user input and write to file until "exit" is entered
            while (true) {
                // Read the next line of input
                line = reader.readLine();

                // If the user types "exit", break the loop
                if ("exit".equalsIgnoreCase(line)) {
                    break;
                }

                // Write the input to the file followed by a newline
                writer.write(line);
                writer.newLine();
            }

            // Close the BufferedReader and BufferedWriter
            reader.close();
            writer.close();

            System.out.println("Your input has been written to 'user_input.txt'.");

        } catch (IOException e) {
            // Handle any exceptions that occur during file operations or reading input
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}

