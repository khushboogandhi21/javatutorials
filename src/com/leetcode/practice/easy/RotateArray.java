package com.leetcode.practice.easy;

import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 *
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 *
 * Follow up:
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArray {

    public static void main(String args[]){

        int[] nums = {1,2,3,4,5,6,7};

        System.out.println("Result is : " );

        rotate(nums,3);

        Arrays.stream(nums).forEach(System.out::print);

    }

    public static void rotate(int[] nums, int k) {

        //optimise rotations
        k =  k % nums.length;

        //Left Rotation
       /* reverseArray(nums, 0, nums.length - 1); ; //reverse entire array FIRST
        reverseArray(nums, 0, nums.length - k - 1) ; //reverse arr-k part
        reverseArray(nums,  nums.length - k , nums.length - 1) ; //reverse k part*/

        //Right rotation
        reverseArray(nums, 0, nums.length - 1); ; //reverse entire array FIRST
        reverseArray(nums,  0 , k - 1) ; //reverse k part
        reverseArray(nums,  k , nums.length - 1) ; //reverse arr - k part

    }

    private static void reverseArray(int[] nums, int i, int j) {

        while(i < j){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;

            i++;
            j--;
        }

    }
}
