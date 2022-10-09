package com.leetcode.practice.hard;

import java.util.*;

/**
 * Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
 * Return all the possible results. You may return the answer in any order.
 *
 *
 * Example 1:
 * Input: s = "()())()"
 * Output: ["(())()","()()()"]
 * Example 2:
 * Input: s = "(a)())()"
 * Output: ["(a())()","(a)()()"]
 * Example 3:
 * Input: s = ")("
 * Output: [""]
 *
 *
 * Constraints:
 * 1 <= s.length <= 25
 * s consists of lowercase English letters and parentheses '(' and ')'.
 * There will be at most 20 parentheses in s.
 */
public class RemoveInvalidParentheses {

    public static void main(String[] args){
        System.out.println("Result : " +  removeInvalidParentheses("(a)())()"));

    }

    public static List<String> removeInvalidParentheses(String str) {
        Set<String> resultSet = new HashSet<>();

        int minInvalid = getMinInvalid(str);

        generateStr(str,minInvalid, resultSet);

        List<String> resultList = new ArrayList<>();
        resultList.addAll(resultSet);
        return resultList;
    }

    private static void generateStr(String str, int minInvalid, Set<String> resultSet) {
        if(minInvalid == 0){

            //check if string formed is valid
            if(getMinInvalid(str) ==0) { //valid
                if(!resultSet.contains(str)){
                    resultSet.add(str);
                }
            }
            return;
        }


        for(int i=0;i<str.length();i++){
            String left = str.substring(0,i);
            String right = str.substring(i + 1); //+ 1 as you are removing one bracket
            generateStr(left+right, minInvalid - 1, resultSet); //-1 since one invalid bracket will be removed
        }


    }

    private static int getMinInvalid(String str) {
        Stack<Character> stack = new Stack();

        for(int i =0;i<str.length();i++){
            if(str.charAt(i) =='(')
                stack.push('(');
            else if(str.charAt(i) ==')'){
                if(stack.isEmpty())
                    stack.push(')'); //first invalid case
                else{
                    if(stack.peek() == ')') //second invalid case
                        stack.push(')');
                    else   //if ( in stack
                        stack.pop();
                }
            }
        }

        return stack.size();
    }
}
