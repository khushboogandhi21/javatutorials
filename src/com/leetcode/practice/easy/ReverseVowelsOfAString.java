package com.leetcode.practice.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, reverse only all the vowels in the string and return it. *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 *
 *
 * Example 1:
 * Input: s = "hello"
 * Output: "holle"
 * Example 2:
 * Input: s = "leetcode"
 * Output: "leotcede"
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 */
public class ReverseVowelsOfAString {
    public static void main(String args[]){
        String str = "hello";
        List<Character> vowelList =  new ArrayList<>();
        vowelList.add('a');
        vowelList.add('e');
        vowelList.add('i');
        vowelList.add('o');
        vowelList.add('u');
        vowelList.add('A');
        vowelList.add('E');
        vowelList.add('I');
        vowelList.add('O');
        vowelList.add('U');

       System.out.println("Result is : "  +reverseVowels(str,vowelList) );
       /* char[] charArray = reverseVowels(str,vowelList);

        for(int j=0; j<charArray.length; j++){   //u cannot use Arrays.stream on charArray
            System.out.print(charArray[j]);
        }//display all entered characters*/


    }

    public static String reverseVowels(String str , List<Character> vowelList) {
        int i =0;
        int j = str.length() - 1;
        char[] charArray = str.toCharArray();

        while(i <  j){

            while( i<j && !vowelList.contains(str.charAt(i))){
                i++;
            }
            while( i < j && !vowelList.contains(str.charAt(j))){
                j--;
            }

            char temp = charArray[i]; //str.charAt(i); cannot swap with str so use char array
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }

        return String.valueOf(charArray) ; //charArray.toString() Prints Object
    }
}
