package com.leetcode.practice.hard;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays. *
 * The overall run time complexity should be O(log (m+n)). *
 *
 *
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class MedianOfTwoSortedArrays {

    public static void main(String args[]){
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        System.out.println("Result is : " + findMedianSortedArrays(nums1,nums2));
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double result = 0;

        int n1 = nums1.length;
        int n2 = nums2.length;

        //we need to play with shorter array primarily
        if(n1 > n2 )
            findMedianSortedArrays(nums2, nums1);


        //nums1 is shorter array
        int low1= 0, high1= n1 ;  //not n1-1 since are trying to find median point which is not zero based

        int mid1 = 0;
        int mid2 = 0;

        int midVal1 = 0, midVal2 = 0;
        int midPlusVal1 = 0, midPlusVal2 =0; //values of index just after mid...we want to ensure partitioned arrays are indeed sorted

        while (low1 <= high1) {

            mid1 = (low1 + high1 )/ 2;
            mid2 = (n1+n2 + 1)/2 - mid1;   //mid of longer array //+1 since we are trying to find median point which divides the array in two parts

            //Check boundary conditions for array index
            midVal1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1-1];  //if mid is 3 the index is 3-1 = 2 as array is zero based
            midVal2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2-1];

            //if mid1 is n1 the midplus will be +ve infinity(since there is no right half of array) else mid
            // ( +1 not required as array is zero based)
            midPlusVal1 = mid1 == n1 ? Integer.MAX_VALUE : nums1[mid1];
            midPlusVal2 = mid2 == n2 ? Integer.MAX_VALUE : nums2[mid2];

            //check if mid of each array is lesser than mid+1 value of another array
           if( midVal1 <= midPlusVal2 && midVal2 <= midPlusVal1){ //if correct find median
               if( (n1 + n2) % 2 ==0){  //if even total of n1+n2 then median sum of two nos /2  so max from left partition and  min from right partition
                   return (Math.max(midVal1,midVal2) + Math.min(midPlusVal1,midPlusVal2)) / 2.0;
               }else{
                   return (Math.max(midVal1,midVal2));
               }
           }else if(midVal1 > midPlusVal2){ //array no partitioned in sorted manner so increase the boundary
               high1 = mid1 - 1;  //we want to get midval1  to be less than midPlusVal2 so lower boundary as all others after it will be greater only
           }  else{
               low1 = mid1 + 1;
           }
        }
        return 0;

    }

}
