package com.leetcode.practice.easy;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different. *
 * Given two integers x and y, return the Hamming distance between them.*
 *
 *
 * Example 1:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 *
 * Example 2:
 * Input: x = 3, y = 1
 * Output: 1
 *
 *
 * Constraints:
 * 0 <= x, y <= 231 - 1
 */
public class HammingDistance {

    public static void main(String args[]){

        System.out.println("Result is : "  + hammingDistance(3,1));
    }

    public static  int hammingDistance(int x, int y) {
        if( x < 0 ||  y > Integer.MAX_VALUE)   //Integer.MIN_VALUE is -2^32 while Integer.MAX_VALUE is 2^31-1
            return 0;

        int result = x ^ y;  //gives n of different bits in both numbers as 1 ^ 0 = 1
        return NumberOf1Bits.hammingWeight(result);
    }
}
