package com.leetcode.practice.easy;


/**   Sieve of Eratosthenes  ***
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 *
 * Example 1:
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * Example 2:
 * Input: n = 0
 * Output: 0
 *
 * Example 3:
 * Input: n = 1
 * Output: 0
 *
 *
 * Constraints:
 * 0 <= n <= 5 * 106
 */
public class CountPrimes {

    public static void main(String[] args){
        System.out.println("Result is : " + countPrimes(5) );
    }

    public static int countPrimes(int n) {

        if(n <= 2)
            return 0;  //limit case

        int[] resultArr = new int[n]; //assume initially all prime so zero considered prime

        int count = 0;
        for(int i = 2 ; i * i <= n;i++) {   //Prime nos always start with 2
           //count++;  //add for i
            if (resultArr[i] == 0){  //initially all are true
                for (int j = i * i; j < n; j =  j + i) {  //Multiple calculation formula: take first square of number i and then keep adding no to get next multiples
                        resultArr[j] = 1;
                       // count++;  //add for i*i
                }
            }
        }
        // Count all prime numbers
        for (int i = 2; i < n; i++) {
            if (resultArr[i] == 0)
                count++;
        }


        return count;
    }
}
