package com.leetcode.practice.easy;

import java.util.Arrays;

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 *
 * Example 1: *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * Example 3:
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 *
 *
 * Constraints:
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 */
public class PlusOne {

    public static void main(String args[]){

        int[] digits = {9};

        System.out.println("Result is : " );

        int[] result  = plusOne(digits);

        Arrays.stream(result).forEach(System.out::println);

    }
    public static int[] plusOne(int[] digits) {

        for(int i = digits.length - 1; i>=0 ; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits; //No need to look further as we just needed to add 1 to unit digit
            }else{
                digits[i] = 0; //since more than 9 adding 1 will be 10 so carry 1 to next digit
            }
        }
        //if last digit encountered is  greater than 9 so u reached here so add 1
        int[] resultArr = new int[digits.length + 1];
        resultArr[0] = 1;

        return resultArr;
    }
}
