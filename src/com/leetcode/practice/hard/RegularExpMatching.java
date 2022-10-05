package com.leetcode.practice.hard;

/**
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * 1 <= p.length <= 30
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */

public class RegularExpMatching {


    public static void main(String args[]){

        System.out.println("Result is : " +isMatch("ba","a*"));
    }

    public static boolean isMatch(String str, String pattern) {
        Boolean[][] dp = new Boolean[str.length() + 1][pattern.length() + 1]; //1 index more for storing result
        return matchExp(0, 0 , str,pattern,dp);
    }
    public static boolean matchExp(int strCount, int patCount, String str, String pattern, Boolean[][] dp) {

        boolean ans = false;
        if(patCount == pattern.length()  )  //if end of pattern reached
            return  strCount == str.length(); //strCount should not exceed str length if str processed return true else false

        if(dp[strCount][patCount] != null)
            return dp[strCount][patCount];

        boolean firstMatch =  strCount < str.length() && (str.charAt(strCount) == pattern.charAt(patCount)  || pattern.charAt(patCount) == '.');

        if(patCount + 1 < pattern.length() &&  pattern.charAt(patCount + 1) == '*'){
            ans = firstMatch && matchExp(strCount + 1, patCount ,str,pattern,dp) ||  //check next chars in str
                    !firstMatch && matchExp(strCount , patCount + 2,str,pattern, dp); //check 1st char of str matches with char after * in pattern as we will ignore char*

        }else {
            ans = firstMatch && matchExp(strCount + 1, patCount + 1,str,pattern,dp);
        }

        dp[strCount][patCount] =  ans;

        return dp[strCount][patCount] ;
    }

}
