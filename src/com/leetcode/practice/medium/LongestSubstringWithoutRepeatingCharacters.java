package com.leetcode.practice.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String args[]){
        String str = "dvdf";  //aab ->2 //dvdf ->3
        int result  = lengthOfLongestSubstring(str);
        System.out.println("Result is : " +result);
    }

    public static int lengthOfLongestSubstring(String str) {
        Set<Character> strSet = new HashSet<>();
        int max = 0;
        //int count = 0;

      /* for(int i = 0; i< str.length(); i++){
            if(strSet.add(str.charAt(i))){
                count++;
                max= Math.max(max,count);
            }else{
                count = 1;
                strSet.clear();
                strSet.add(str.charAt(i));
            }
        }  *///FOR SUBSTRING WORKING

        /*for(int i = 0; i< str.length(); i++){
            if(strSet.add(str.charAt(i))){
                count++;
                max= Math.max(max,count);
            }else{

                strSet.remove(str.charAt(i));
            }
        }*/ //FOR SUBSEQUENCE WORKING

        //SLIDING WINDOW APPROACH---RECOMMENDED
        //i always will be greater than j

        int i =0,j=0;
        while(i< str.length()){
           // if(!strSet.add(str.charAt(i))){
                while(strSet.contains(str.charAt(i))){
                    strSet.remove(str.charAt(i));
                    j++; //tracks count of repetitive characters
                }
            //} NOT REQUIRED
            strSet.add(str.charAt(i));  //add current occurrence.  Do this after removal to keep at least one occurrence
            max= Math.max(max, i-j + 1); //here count is i-j + 1(add 1 or offset for length)
            i++;
        }
        return max;
    }
}
