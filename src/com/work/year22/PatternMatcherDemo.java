package com.work.year22;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherDemo {

    public static void main(String args[]){
        String str = "This Order was placed for QT3000! OK?";
        String strPattern ="!";
        Pattern pattern = Pattern.compile(strPattern);
        Matcher matcher = pattern.matcher(str);

        if(matcher.matches()) //Attempts to match the entire region against the pattern
            System.out.println("Pattern found via matches"); //returns false since pattern we are looking for is onlya substring of original string not entire original string


        if(matcher.find()) //Attempts to find the next subsequence of the input sequence that matches the pattern.
            System.out.println("Pattern found via find");

        //OR
        System.out.println("Pattern found: " + str.matches("!"));

        pattern = Pattern.compile("(\\d+)");
        matcher = pattern.matcher(str);
        while(matcher.find())
            System.out.println("Pattern found: " + matcher.group());

    }
}
