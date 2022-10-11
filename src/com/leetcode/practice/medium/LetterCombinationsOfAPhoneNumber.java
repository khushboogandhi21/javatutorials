package com.leetcode.practice.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order. *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * LeetCode 17 Keypad
 * Constraints:
 * 0 ≤ digits.length ≤ 4
 * digits[i] is a digit in the range ['2', '9'].
 * Examples
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 */
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String args[]){

        System.out.println("Result is : " +letterCombinations("23"));
    }

    public  static List<String> letterCombinations(String digits) {

        Map<Character, char[]> dict = new HashMap<>();
        dict.put('2',new char[]{'a','b','c'});
        dict.put('3',new char[]{'d','e','f'});
        dict.put('4',new char[]{'g','h','i'});
        dict.put('5',new char[]{'j','k','l'});
        dict.put('6',new char[]{'m','n','o'});
        dict.put('7',new char[]{'p','q','r','s'});
        dict.put('8',new char[]{'t','u','v'});
        dict.put('9',new char[]{'w','x','y','z'});

        List<String> resultList = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return resultList;

        char[] charArr = new char[digits.length()];
        helperRecursive(dict,digits,0,charArr, resultList);

        return resultList;
    }

    private static void helperRecursive(Map<Character,char[]> dict, String digits, int index, char[] charArr, List<String> resultList) {

        if(index == digits.length()){  //charArr.length won't work
            resultList.add(new String(charArr));  //charArr.toString() not working
            return ;
        }

        char[] dictArr = dict.get(digits.charAt(index));  //first digit of string...next call next digit(index+1)

        for(int i = 0;i< dictArr.length;i++){
            charArr[index] = dictArr[i];  //index will be 0 for all char of that digit in this call...next call it will be +1
            //all characters of current digit will combine with all char of second digit
            helperRecursive(dict,digits,index + 1,charArr, resultList);
        }


    }
}
