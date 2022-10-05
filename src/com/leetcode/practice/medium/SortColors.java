package com.leetcode.practice.medium;

import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2: *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 * *
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */

public class SortColors {

    public static void main(String args[]){
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println("Result is : " );
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void sortColors(int[] nums) {

        int i = 0, j = nums.length - 1, index = 0;
        while (index<=j){
            if(nums[index] == 0) {
                swap(nums, index,i);
                i++;
            } else  if(nums[index] == 2) {
                swap(nums, index,j);
                j--;
            }

           index++;
        }
    }

    private static void swap(int[] nums ,int num, int num1) {
            int temp = nums[num1];
            nums[num1] = nums[num];
            nums[num] = temp;
    }
}
