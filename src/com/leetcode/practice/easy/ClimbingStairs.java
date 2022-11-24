package com.leetcode.practice.easy;

import java.util.Arrays;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 * 1 <= n <= 45
 */
public class ClimbingStairs {

    public static void main(String args[]){
        int nums = 5;
        int[] dp = new int[nums + 1];
        System.out.println("Result is : " +  climb(nums,dp) );

    }

    private static int climb(int nums, int[] dp) {
        if(nums <= 1 ) //if only equal sign it gives out of bounds error
            return 1;

        if(dp[nums] > 0)
            return dp[nums];

        dp[nums] = climb(nums -1,dp) + climb(nums - 2, dp);
        return dp[nums];

    }
}
