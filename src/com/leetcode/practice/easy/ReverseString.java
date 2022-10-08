package com.leetcode.practice.easy;

import java.util.Arrays;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 *
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */
public class ReverseString {

    public static void main(String args[]){
        char[] charArray = {'h','e','l','l','o'};


        System.out.println("Result is : " );
        reverseString(charArray);
       /* for(int j=0; j<charArray.length; j++){   //u cannot use Arrays.stream on charArray
            System.out.print(charArray[j]);
        }//display all entered characters*/

        System.out.println(String.valueOf(charArray));

    }

    public static  void reverseString(char[] charArray) {

        int i = 0, j= charArray.length -1;

        while(i != j){

            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;

            i++;
            j--;
        }

    }
}
