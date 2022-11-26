package com.programs;

import java.util.Locale;

public class PalindromeDemo {

    public static void main(String[] args){

        String str  = "NeveroddorEVen";


        //First Approach
        String[] strArr = str.split("");
        boolean isNotPalindrome = false;
        for(int i = 0, j= strArr.length - 1; i< strArr.length && j>=0; i++, j--){
            if(!strArr[i].equalsIgnoreCase(strArr[j])) {
                isNotPalindrome = true;
                break;
            }
        }
        if(isNotPalindrome)
            System.out.println("First Approach: Not a Palindrome");
        else
            System.out.println("First Approach: Is a Palindrome");


        //Second Approach
        StringBuilder strReverseBldr = new StringBuilder(str).reverse();
        if(str.equalsIgnoreCase(strReverseBldr.toString()))
            System.out.println("Second Approach: Is a Palindrome");
        else
            System.out.println("Second Approach: Not a Palindrome");

        //Third Approach -- Recommended it ignores special characters in string
        str ="Never,odd-or.EVen";
        str = str.toLowerCase();
        int i = 0, j= str.length() - 1;
        while(i < j){
            while(i<j){  //or  while(i<j && !Character.isLetterOrDigit(str.charAt(i))) //no break clause needed
                if(!Character.isLetterOrDigit(str.charAt(i)))
                    i++;
                else
                    break;
            }

            while(i < j){
                if(!Character.isLetterOrDigit(str.charAt(j)))
                   j--;
                else
                    break;
            }
            if(str.charAt(i) != str.charAt(j)){
                isNotPalindrome =  true;
                break;
            }
            i++;j--;

        }

        if(isNotPalindrome)
            System.out.println("Third Approach: Not a Palindrome");
        else
            System.out.println("Third Approach: Is a Palindrome");


        //Integer palindrome Check
        //1st approach
        int intValue = 978879;
        strReverseBldr = new StringBuilder(String.valueOf(intValue)).reverse();
        if(String.valueOf(intValue).equalsIgnoreCase(strReverseBldr.toString()))
            System.out.println("Int Is a Palindrome");
        else
            System.out.println("Int Not a Palindrome");

        //2nd approach
        //for(int i =0; intValue > = 0; i++ )
        int  revIntValue = 0 ;
        int orgValue = intValue;
        while(intValue > 0){
            revIntValue = (revIntValue*10) + (intValue % 10); //u multiply by 10 to create space for next integer
            intValue = intValue / 10;
        }
        System.out.println(intValue + ";" + revIntValue);

        if(orgValue == revIntValue)
            System.out.println("Int Is a Palindrome");
        else
            System.out.println("Int Not a Palindrome");

    }
}
