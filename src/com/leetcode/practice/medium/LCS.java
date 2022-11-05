package com.leetcode.practice.medium;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 * Example 1:
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 * Example 2:
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 *
 * Example 3:
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * Constraints:
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 */
public class LCS {
    public static void main(String args[]){
        String str1 = "forgeeksskeegfor", str2 ="rofgeeksskeegrof"; //ACB --> 3
        System.out.println("Result is : " + getLCS(str1,str2));
    }

    public static int getLCS(String str1,String str2){
        int[][] dp = new int[str1.length() + 1][str2.length()+1];

        for(int i = 0; i <= str1.length() ; i++){ //<=since size is length +1

            for(int j = 0; j <= str2.length() ; j++){
                //NO NEED OF first two if conditions since int array def value is 0 In that case loops will start from 1
                if(i == 0){
                    dp[i][j]  = 0; //since one of the string will be blank no match will be there so zero
                }else if(j == 0){
                        dp[i][j]  = 0;
                }else if(str1.charAt(i - 1) == str2.charAt(j -1)){  //diagonal match  for previous indexes
                    dp[i][j] = dp[i-1][j-1] + 1; //offset 1 since initial is considered 0
                }else{
                    dp[i][j] =  Math.max(dp[i][j-1],dp[i-1][j]);  //No + 1 since no match found
                }

            }
        }

        return dp[str1.length()][str2.length()];
    }

}
