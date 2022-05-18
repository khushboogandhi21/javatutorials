package com.work.year22;

import java.util.Arrays;
import java.util.List;

public class Streams22Demo {


    public static void main(String[]args){
        String str="Hello World";
        //convert String to char array
        char[] charArray = str.toCharArray();
        for(char i:charArray){
            System.out.println("Char is " + i );
        }


        //convert char array to list
        List<char[]> characterList = Arrays.asList(charArray);
        //iterate  a list using foreach
        for(char[] chrarr: characterList){
            System.out.println("Char arr is " + chrarr );  //returns [C@e9e54c2 so DOES NOT SATISFY REQUIREMENT
        }
        //convert String Array to List
        //Option 1
        List<String> strList = Arrays.asList("Hello","Java","World");
        for(String s: strList){
            System.out.println("String arr is " + s );
        }
        //Option 2
        String[] strArray = {"This","is","List"};
        List<String> arrList = Arrays.asList(strArray);
        for(String s: arrList){
            System.out.println("String Arraylist is " + s );
        }





    }
}
