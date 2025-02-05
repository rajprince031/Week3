package com.stringbuffer;

public class ConcatenateStringArray {
    public static void main(String[] args) {

        //Creating a string array
        String[] stringArray = {"I","am","Raj","Prince"};

        //Create a StringBuffer string and initialize it with empty string
        StringBuffer stringBuffer = new StringBuffer();

        //Concatenate the string array
        for (String s : stringArray) {
            stringBuffer.append(s);
        }

        //Convert StringBuffer to String
        String str = stringBuffer.toString();

        //print the concatenated string
        System.out.println("String Array after concatenate : "+str);
    }
}
