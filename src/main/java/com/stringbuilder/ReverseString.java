package com.stringbuilder;

//class to reverse a string
public class ReverseString {
    public static void main(String[] args) {
        
        //Creating a String type variable to store the string
        String str = "Prince";

        //Converting the string to StringBuilder
        StringBuilder stringBuilder = new StringBuilder(str);
        
        //Printing the string
        System.out.println("Before Reversing the String : "+str);
        
        //Reversing the string using reverse() method
        stringBuilder.reverse();

        //Converting StringBuilder back to String
        str = stringBuilder.toString();


        //Printing the reversed string
        System.out.println("After Reversing the String : "+str);
    }
}
