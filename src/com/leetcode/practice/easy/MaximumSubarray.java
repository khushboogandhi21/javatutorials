package com.leetcode.practice.easy;

/**            Kadane's Algorithm *****
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 *  Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2: *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class MaximumSubarray {

    public static void main(String args[]){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println("Result is : " +maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];

        for(int i=1; i < nums.length ; i ++){

            if(sum < 0){
                sum = 0; //reset if sum is -ve
            }

            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;

    }
}
