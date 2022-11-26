package com.leetcode.practice.medium;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator. *
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8,
 * and -2.7335 would be truncated to -2.
 *
 * Return the quotient after dividing dividend by divisor. *
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−2^31, 2^31 − 1].
 * For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
 *
 *
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = 3.33333.. which is truncated to 3.
 * Example 2:
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 *
 * Constraints: *
 * -2^31 <= dividend, divisor <= (2^31)  - 1
 * divisor != 0
 */

public class DivideTwoIntegers {

    public static void main(String args[]){

        System.out.println("Result is : " +divide(10,-2));
    }

    public static int divide(int dividend, int divisor) {
        if(divisor ==  0) return -1;
        if(dividend > (2 << 31) - 1 & divisor == -1) return Integer.MAX_VALUE;


        int result = 0;
        int sign = (dividend < 0 || divisor < 0) ? -1 : 1;


        dividend= Math.abs(dividend); //here we are not using * -1 since we cannot use long ...req is to limit till integer range only
        divisor = Math.abs(divisor);

        while(dividend >= divisor){
            int count = 0;
            int temp = divisor << 1 << count;

            while ((temp) < dividend){
                count++;
                temp = divisor << 1 << count;  //count indicates do divisor << 1  count times ->[divisor * 2] count times
            }

            result +=  1 << count; //add 1 << count for the condition of single divisor value(3) since we start checking with doubled divisor(9) 10/3 case
            dividend -= divisor << count;
        }

        return sign == 1? result : -result; //can't multiply by 1 since can't use multiply operation
    }
}
