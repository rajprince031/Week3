package com.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Create a class that reads a file Line by Line
public class ReadFileLineByLine {
    public static void main(String[] args) {

        //Create a variable and store the path of the file
        String filename = "/Users/princeraj/Desktop/Capgemini-Training/Week3/Day4/src/main/java/com/filereader/demo.txt";

        //Using try-with-resource to ensure resources are automatically closed
        try(FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){

            //String variable to store the fist line
            String line = bufferedReader.readLine();

            //if line value is null then loop terminates else it print the value of line
            while(line != null){
                // Read each line from the file and print it
                System.out.println(line);
                line = bufferedReader.readLine();
            }

        }catch(IOException e){
            // Print exception message if there is an error
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

    }
}
