package com.leetcode.practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 * Example 1: *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 *
 * Example 2: *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * Constraints:
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class MergeIntervals {

    public static void main(String args[]){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}}; //{1,3},{2,6},{8,10},{15,18}  //{1,4},{4,5}
        int[][] result = merge(intervals);
        for(int[] i: result)
            System.out.println("Result is : " + i[0] + "," + i[1]);
    }

    public static int[][] merge(int[][] intervals) {
        //int[][] result =  new int[intervals.length][];

        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        List<int[]> resultList = new ArrayList<>();

        for(int i = 0; i< intervals.length ; i++) {
            int[] mergeArray = new int[2];
            if(i + 1 <  intervals.length && intervals[i][1] >= intervals[i+1][0]){
                mergeArray[0] = intervals[i][0];
                mergeArray[1] = intervals[i+1][1];
                i++;
            }else {
                mergeArray[0] = intervals[i][0];
                mergeArray[1] = intervals[i][1];
            }

            resultList.add(mergeArray);
        }

        return resultList.toArray(new int[0][]);  //dumps the array contained in list to new Array. List already  contains 1d array int[]. zero in declaration required.

    }
}
