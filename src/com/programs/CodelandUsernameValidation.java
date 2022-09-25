package com.programs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
1. The username is between 4 and 25 characters.
2. It must start with a letter.
3. It can only contain letters, numbers, and the underscore character.
4. It cannot end with an underscore character.

If the username is valid then your program should return the string true, otherwise return the string false.
 */
public class CodelandUsernameValidation {
    public static String CodelandUsernameValidation(String str) {
        // code goes here
        Pattern pattern = Pattern.compile("[a-zA-z][a-zA-z0-9_]{2,23}[^_]");
        Matcher matcher = pattern.matcher(str);
        if(matcher.find())
            return "true";
        else
            return "false";
    }

    public static void main (String[] args) {
        // keep this function call here
        //Scanner s = new Scanner(System.in);
        System.out.print(CodelandUsernameValidation("u__hello_world123")); //aa_
    }
}
