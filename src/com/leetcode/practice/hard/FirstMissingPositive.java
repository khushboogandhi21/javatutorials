package com.leetcode.practice.hard;


/**
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 *
 * Example 1:
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 * Example 2:
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 * Example 3:
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 */
public class FirstMissingPositive {

    public static void main(String[] args){

        int[] arr = {3,2,-1,1};
        System.out.println("Result is : " + firstMissingPositive(arr) );
    }

    public static int firstMissingPositive(int[] nums) {

        int n = nums.length;

        int min = Integer.MAX_VALUE;
        //int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > 0 && nums[i] <=n){
                if(nums[i] < min){
                    min = nums[i];
                }
            }else{ //if(nums[i] < 0){
                nums[i] = 1;  //can assign any number in range
            }
        }
        if(min != 1)  //if 1 not found its the missing one
            return 1;


        for(int i = 0 ; i < nums.length; i++){ //consider the nos contained in array as index of array[since we are not using new array]
            int index = Math.abs(nums[i]) - 1; //if  already turned negative[processed] so abs required
            if( nums[index]  > 0 ){ //if not already turned negative[processed]
                nums[index] = -1 * nums[index];
            }
        }

        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > 0){ //if no not processed its index is missing no
                return i + 1;
            }
        }

        //if no missing no found n+1 is missing no
        return nums.length + 1;

    }
}
