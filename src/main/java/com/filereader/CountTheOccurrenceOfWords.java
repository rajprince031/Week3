package com.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountTheOccurrenceOfWords {

    //Method to count the matching word in the line
    public static int countWords(String line, String searchWord){
        int wordCount = 0;
        String[] words = line.split(" ");
        for(int i=0; i<words.length; i++){
            if(words[i].equals(searchWord)){
                wordCount++;
            }
        }
        return wordCount;
    }
    public static void main(String[] args) {
        //Create a variable and store the path of the file
        String filename = "/Users/princeraj/Desktop/Capgemini-Training/Week3/Day4/src/main/java/com/filereader/demo.txt";

        int wordCount = 0;

        //Create a String variable to store the word that we have search o the file
        String searchWord = "I";

        //Using try-with-resource to ensure resources are automatically closed
        try(FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){

            //String variable to store the fist line
            String line = bufferedReader.readLine();

            //if line value is null then loop terminates else it prints the value of line
            while(line != null){
                wordCount = wordCount + countWords(line, searchWord);
                line = bufferedReader.readLine();
            }

            //Print the total count of matching word
            System.out.println("Total occurrence of word "+searchWord+" is : "+wordCount);

        }catch(IOException e){
            // Print exception message if there is an error
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
