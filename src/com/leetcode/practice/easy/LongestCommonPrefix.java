package com.leetcode.practice.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1: *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2: *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
public class LongestCommonPrefix {

    public static void main(String args[]){
        String[] strs =  {"dog","racecar","car"};
        System.out.println("Result is : " + longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {

        StringBuilder sbr =new StringBuilder();
        //check boundary conditions
        if(strs == null || strs.length == 0)
            return sbr.toString();

        char[] arr0 = strs[0].toCharArray();
        for(int i = 0 ; i< arr0.length; i++){
           // boolean isMatch = true;
            for(int j = 1 ; j< strs.length; j++){
                if(i < strs[j].length() ){ //check if string is shorter than the arr0
                    if(arr0[i] != strs[j].charAt(i)){
                        /*isMatch = false;
                        break;*/
                        return sbr.toString();
                    }
                }
            } //inner for ends

            //if(isMatch)
            sbr.append(arr0[i]);
        }

        return sbr.toString();
    }
}
