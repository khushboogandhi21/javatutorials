package com.leetcode.practice.easy;

/**
 * In 1st version u need to show unique numbers In result irrespective of how many times they match
 * In 2nd version u need to show all nos as many times as they match
 */

import java.util.*;


/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 *
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 *
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 *
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArrays_I_and_II {

    public static void main(String args[]){

        int[] nums1 = {1,2,2,1}; int[] nums2 = {2,2};

        System.out.println("Result is : " ); //show unique numbers

        int[] result  = intersectOne(nums1, nums2);
       /* for(int i =0;i< result.length;i++){
            System.out.println("\t "  + result[i] );
        }*/

        Arrays.stream(result).forEach(System.out::println);

        //System.out.println("Result is : " +intersectTwo(nums1, nums2));
    }

    public static int[] intersectOne(int[] nums1, int[] nums2) {
        Set<Integer> resultSet = new HashSet<>();  //Flavour 1
        List<Integer> resultList = new ArrayList<>(); //Flavour 2
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;

        while(i < nums1.length){
            if(nums1[i] == nums2[j]){
                resultSet.add(nums1[i]); //Flavour 1
                resultList.add(nums1[i]); //Flavour 2
                j++;
            }

            i++;
        }

        //return  resultSet.stream().mapToInt(Integer::intValue).toArray();  //Flavour 1
        return resultList.stream().mapToInt(x-> x.intValue()).toArray(); //Flavour 2
    }
}
