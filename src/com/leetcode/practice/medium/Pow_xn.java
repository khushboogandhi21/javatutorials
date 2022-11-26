package com.leetcode.practice.medium;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 * Example 1:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 *
 * Example 2:
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 *
 * Example 3:
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 * Constraints:
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n is an integer.
 * -104 <= xn <= 104
 */

public class Pow_xn {

    public static void main(String args[]){
        double x = 0;
        int n = -2; //Math.abs(Integer.MIN_VALUE)
        System.out.println("Result is : " +myPow(x,n));
    }

    public static double myPow(double x, int n) {
        boolean sign = n < 0 ? true : false;
        if(sign) //if negative
            n = n * -1;  //Cannot use Math.abs here since most negative value[-2147483648] cannot be represented positively[2147483647]

        double result = 0 ;

        //if(x == 0 ) return 0; //wrong as 1 /0 will be infinity
        if( n == 0) return 1;

        if(n % 2 == 0){
            result = myPow(x * x, n/2);
        }else{
            result = x  * myPow(x, n -1 );
        }

        if(sign){
            result = (1 / result) * (-1);
        }

        return result;
    }
}
