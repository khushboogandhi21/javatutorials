package com.leetcode.practice.medium;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public static void main(String args[]){
        int[] nums = {0, 1, 3, 50, 75};

        System.out.println("Result is : " +findMissingRanges(nums, 0    , 99));
    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper){
        List<String> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            if(lower < upper)
                result.add(lower + "->" + upper);
            else if(lower == upper)
                result.add(lower + "");

            return result;
        }

        if(lower==Integer.MAX_VALUE){
            return result;
        }

        if(nums[0] > lower) {
            result.add("" + lower + "->" + (nums[0] - 1));
        }

        for (int i = 0;i< nums.length - 1 ;i++){

            if(nums[i] + 1 != nums[i+1]){
                result.add("" + (nums[i] + 1) + "->" + (nums[i+1] -1));
            }
        }
        if(nums[nums.length - 1] != upper){
            result.add("" + (nums[nums.length - 1] + 1) + "->" + upper);
        }
        return result;
    }
}
