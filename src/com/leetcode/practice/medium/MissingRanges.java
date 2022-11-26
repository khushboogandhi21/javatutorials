package com.leetcode.practice.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 *
 * Example:
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 */
public class MissingRanges {

    public static void main(String args[]){
        int[] nums = {0, 1, 3, 50, 75};

        System.out.println("Result is : " +findMissingRanges(nums, 0    , 99));
    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper){
        List<String> result = new ArrayList<>();
        if(nums == null || nums.length == 0) { //boundary condition
            if(lower < upper)
                result.add(lower + "->" + upper);
            else if(lower == upper)
                result.add(lower + "");

            return result;
        }

        if(lower==Integer.MAX_VALUE){ //boundary condition
            return result;
        }

        if(nums[0] > lower) {  // Array boundary condition
            result.add("" + lower + "->" + (nums[0] - 1));
        }

        for (int i = 0;i< nums.length - 1 ;i++){

            if(nums[i] + 1 != nums[i+1]){   //if next is not a consecutive number
                result.add("" + (nums[i] + 1) + "->" + (nums[i+1] -1));
            }
        }
        if(nums[nums.length - 1] < upper){ // Array boundary condition
            result.add("" + (nums[nums.length - 1] + 1) + "->" + upper);
        }

        return result;
    }
}
