package com.leetcode.practice.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses. *
 *
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 *
 * Constraints:
 * 1 <= n <= 8
 */
public class GenerateParentheses {

    public static void main(String args[]){

        System.out.println("Result is : " +generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        helper(new String(),0,0,result, n);  //DO NOT USE STRINGBUFFER
        return result;
    }

    public static  void helper(String str ,int openBrackets, int closedBrackets, List<String> result, int n){
        /*if(openBrackets > n || closedBrackets > openBrackets)
        return;*/ //working but confusing with limit condition

        if(openBrackets == n && closedBrackets ==n) {
            result.add(str.toString());
            return ;
        }

       if(openBrackets < n)
            helper(str + "(",openBrackets + 1,closedBrackets,result,n );

       if(closedBrackets < openBrackets)
            helper(str + ")",openBrackets,closedBrackets + 1,result,n );

    }
}
