package com.leetcode.practice.medium;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value. *
 * If target is not found in the array, return [-1, -1]. *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 * Constraints:
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
public class SearchForARange {
    public static void main(String args[]){
        int[] nums = {5,7,7,8,8,10};
        System.out.println("Result is : " +searchRange(nums,8));
    }


    public static int[] searchRange(int[] nums, int target) {
        int[] result =  {-1,-1};
        result[0]  = findStartIndex(nums, target);
        result[1]  = findEndIndex(nums, target);
        System.out.println("Result is : " +result[0] + "," + result[1]);
        return result;
    }
    public static int findStartIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1, mid = -1;

        while(left <= right){
             mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }

            if(nums[mid] == target)  // inside while
                index = mid;
        }


        return index;
    }

    public static int findEndIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1, mid = -1;

        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] <= target){ //move to Right
                left = mid + 1;
            }else{
                right = mid - 1;
            }

            if(nums[mid] == target)
                index = mid;
        }


        return index;
    }
}
