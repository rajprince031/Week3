package com.stringbuilder;

import java.util.HashSet;
// Remove duplicates characters from a string
public class RemoveDuplicates {
    public static void main(String[] args) {

        // Create a variable of type String
        String str = "environment";

        // Create a variable of type StringBuilder and initialize it with an empty string
        StringBuilder stringBuilder = new StringBuilder("");

        // Create a variable of type HashSet and initialize it with an empty HashSet
        HashSet<Character> uniqueCharacters = new HashSet<>();

        // Iterate through the string
        for(int i=0; i<str.length(); i++){

            // Get the character at index i
            char ch = str.charAt(i);

            // Check if the character is already present in the HashSet
            if(uniqueCharacters.contains(ch)){
                continue;
            }
            // If the character is not present in the HashSet, add it to the HashSet and append it to the StringBuilder
            uniqueCharacters.add(ch);
            stringBuilder.append(ch);
        }

        // Convert the StringBuilder to a String
        String uniqueChars = stringBuilder.toString();

        // Print the original string and the string after removing duplicates
        System.out.println("String before removing duplicates characters : "+str);

        System.out.println("String after removing duplicates characters : "+uniqueChars);
    }
}
