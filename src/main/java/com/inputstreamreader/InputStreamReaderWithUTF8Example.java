package com.inputstreamreader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderWithUTF8Example {
    public static void main(String[] args) {

        //Create a variable and store the path of the file
        String filename = "/Users/princeraj/Desktop/Capgemini-Training/Week3/Day4/src/main/java/com/inputstreamreader/demo.txt";

        //Using try-with-resource to ensure resources are automatically closed
        try(FileInputStream fileInputStream = new FileInputStream(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8")){

            int character;
            // Read each character using UTF-8 encoding
            while ((character = inputStreamReader.read()) != -1) {
                System.out.print((char) character);  // Print each character
            }

        }catch(IOException e){
            // Print exception message if there is an error
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}


