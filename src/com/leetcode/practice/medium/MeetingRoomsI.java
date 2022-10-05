package com.leetcode.practice.medium;

import java.util.Arrays;

/**
 * Given an array of intervals[i] = [start,end] determine if a person could attend ALL meetings
 */

public class MeetingRoomsI {

    public static void main(String args[]){
        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println("Result is : " +canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(int[][] intervals){

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        for(int i =0; i< intervals.length - 1; i++){
            if(intervals[i + 1][0] <  intervals[i][1])
                return false;
        }
        return true;
    }
}
