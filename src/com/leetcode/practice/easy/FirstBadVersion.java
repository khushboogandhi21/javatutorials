package com.leetcode.practice.easy;

import java.util.Arrays;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version.
 * You should minimize the number of calls to the API.
 *
 *
 *
 * Example 1:
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 *
 * Example 2:
 * Input: n = 1, bad = 1
 * Output: 1
 *
 * Constraints:
 * 1 <= bad <= n <= 231 - 1
 */
public class FirstBadVersion {

    public static void main(String args[]){

        System.out.println("Result is : " + findFirstBad(5));

    }

    private static int findFirstBad(int n) {
        int low = 1, high = n; //low 1 since high is n not n-1
        int badVersion = 0;

        while(low <= high){

            int mid = low + (high - low) / 2;
            if(isBadVersion(mid)) {
                badVersion = mid;
                high = mid - 1; //everything after mid is bad version we need to find first one
            }else{
                low = mid + 1;
            }

        }
        return badVersion;

    }

    private static boolean isBadVersion(int n){
        if(n >= 5)
            return true;
        else
            return false;
    }
}
