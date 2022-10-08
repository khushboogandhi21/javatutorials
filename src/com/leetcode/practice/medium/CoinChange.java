package com.leetcode.practice.medium;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2: --Not working
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 *
 * Constraints:
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinChange {

    public static void main(String args[]){
        int[] coinsArray = {1,2,5};
        int amount = 11;
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, -1);
        dp[0] = 0; //blank data case

        System.out.println("Result is : " + coinChange(coinsArray,amount,dp));
    }

    public static int coinChange(int[] coins, int amount, int[] dp) {


        if(amount == 0) return 0;

        int ans = Integer.MAX_VALUE;  //Needed since we compare subans with it

        for(int i = 0;i< coins.length;i++){
            if((amount - coins[i]) >= 0){  //check if its not turning negative
                int subAns = 0;
                if(dp[amount - coins[i]] != -1)
                    subAns =  dp[amount - coins[i]];
                else
                    subAns = coinChange(coins, amount - coins[i],dp);

                if( subAns != Integer.MAX_VALUE && subAns + 1 < ans) //we check to see if the path we are trying, don't lead to overflow or negative value
                    // also we see if he subAns has been modified other than max value
                    ans = subAns + 1;

                //dp[amount] = ans; //cant have it here coz if the if condtn not satisfied  it wont be assigned

            }
            dp[amount] = ans;
        }

        //dp[amount] = ans;//assign outside for loop as this is recursion
        return dp[amount];
    }
}
