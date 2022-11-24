package com.leetcode.practice.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.*
 *
 *
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 */
public class ImplstrStrIndexOf {

    public static void main(String args[]) {
        String haystack = "sadbutsad", needle = "sad";

        List<Character> vowelList = new ArrayList<>();
        System.out.println("Result is : " + strStr(haystack,needle) );

    }

        public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0 || needle.length() >104)
            return -1;

            for(int i = 0; i < haystack.length() - needle.length();i++){
                int j;
                for( j = 0; j < needle.length();j++){
                    if(haystack.charAt(i + j ) != needle.charAt(j))
                        break;
                }
                if(j  == needle.length() )  //if needle found no need to check further
                    return i;
            }
            return -1;

    }
}
