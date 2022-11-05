package com.leetcode.practice.medium;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 *
 * Example 1:
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
public class LongestIncreasingSubsequence {

    public static void main(String args[]){
        int[] nums = {0,1,0,3,2,3};
        System.out.println("Result is : " + lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {

        int max = 0;  //keeps track of max subsequence length since there can be many subsequences in array
        int[] LIS = new int[nums.length];
        for(int i =0; i< LIS.length; i++)
            LIS[i] = 1; //LIS for single index is 1

        for(int i = 1; i<nums.length; i++){
            for(int j = 0; j< i;j++){
                if(nums[i] > nums[j] && LIS[i] <= LIS[j]){  //LIS[i] <= LIS[j]  U don't want to overwrite an already higher subsequence value
                    LIS[i] = LIS[j] + 1;
                    max = Math.max(max,LIS[i]);
                }
            }
        }
        return max;
    }
}
