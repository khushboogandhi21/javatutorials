package com.leetcode.practice.medium;

import com.programs.ReverseInteger;

public class LongestPalindromeSubsequence {

    public static void main(String args[]){
        String str1 = "forgeeksskeegfor", str2 ; //12--ogeeksskeego
        StringBuffer str2Reverse = new StringBuffer();
        //Reverse str2
        for(int i = str1.length() - 1; i >=0; i--)
            str2Reverse.append(str1.charAt(i));

        str2 = str2Reverse.toString(); //reassign reverse

        System.out.println("Result is : " + getLCS(str1,str2));
    }

    public static int getLCS(String str1,String str2){


        int[][] dp = new int[str1.length() + 1][str2.length()+1];

        for(int i = 0; i<= str1.length() ; i++){ //<=since size is length +1
            for(int j = 0; j<= str2.length() ; j++){

                if(i == 0){
                    dp[i][j]  = 0; //since one of the string will be blank no match will be there so zero
                }else if(j == 0){
                    dp[i][j]  = 0;
                }else if(str1.charAt(i - 1) == str2.charAt(j -1)){  //diagonal match for previous indexes
                    dp[i][j] = dp[i-1][j-1] + 1; //offset 1 since initial is considered 0
                }else{
                    dp[i][j] =  Math.max(dp[i][j-1],dp[i-1][j]);  //No + 1 since no match found
                }

            }
        }

        return dp[str1.length()][str2.length()];
    }
}
