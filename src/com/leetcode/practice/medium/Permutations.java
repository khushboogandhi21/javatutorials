package com.leetcode.practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 * Constraints: *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */

public class Permutations {

    public static void main(String args[]){
        int[] nums = {1,2,3};
        System.out.println("Result is : " +permute(nums));
    }


    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> resultList =  new ArrayList<>();
        generatePermute(resultList,nums, 0 , nums.length - 1);
        return resultList;
    }

    /** recursive method */
    public static void generatePermute(List<List<Integer>> resultList , int[] nums, int left, int right){

        if(left == right){ //one char/integer left
            // You cannot convert int[] to List of Integers directly
            List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
            resultList.add(numList);
            return ;
        }
        else {
            for (int i = left; i <= right; i++) {
                nums = swap(nums, left, i); //left is constant here i will change, Also we are reassigning nums with the swapped values this will be input to recursive call,that's how left part [0 to left] is also swapped
                generatePermute(resultList,nums, left + 1, right); //permute for next char
                nums = swap(nums, left, i);  // swap back to return to original string [Backtracking]

            }
        }
    }

    private static int[] swap(int[] nums, int i, int left) {
        int temp = nums[i];
        nums[i] = nums[left];
        nums[left] = temp;

        return nums;
    }
}
