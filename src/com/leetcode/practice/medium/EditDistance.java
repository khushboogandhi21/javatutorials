package com.leetcode.practice.medium;

/**
 * edit distance is a string metric, i.e. a way of quantifying how dissimilar two strings (e.g., words) are to one another,
 * that is measured by counting the minimum number of operations required to transform one string into the other.
 * Problem Desc: Convert string s1 to s2 in minimum operations of insert/remove/replace
 */
public class EditDistance {
    public static void main(String args[]){
        String str1 = "saturday", str2 ="sunday"; //3 -->replace n with u, remove a and t
        System.out.println("Result is : " + getEditDistance(str1,str2));
    }

    public static int getEditDistance(String str1,String str2){
        int[][] dp = new int[str1.length() + 1][str2.length()+1];

        for(int i =0; i<= str1.length();i++){  //<= is imp to consider last index which holds result
            for(int j =0; j<= str2.length();j++){
                if( i  == 0  ){
                    dp[i][j] = j;  //insert the incrementing count of second string since that would be the insertion count
                }
                else if( j == 0){  //else is reqd
                    dp[i][j] = i;
                }
                else  if( str1.charAt(i - 1) == str2.charAt(j -1)){  //diagonal cell case when last chars of both string match
                    dp[i][j] =  dp[i-1][j-1];  //here i and j are considered the boundaries...since we calculate from top to down
                    //we won't add 1 since no additional operation performed
                }
                else if( str1.charAt(i - 1) != str2.charAt(j -1)){  //adjacent and top cells case  //offset 1 since we will do some operation
                    dp[i][j] =  1 + Math.min(dp[i ][j-1], //insertion
                            Math.min(dp[i - 1][j], //removal
                                    dp[i - 1][j-1]));  //replace
                }

            }
        }

        return dp[str1.length()][str2.length()];


    }
}
