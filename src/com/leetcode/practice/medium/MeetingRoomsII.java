package com.leetcode.practice.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of intervals[i] = [start,end] Return the minimum number of conference rooms required
 */

public class MeetingRoomsII {

    public static void main(String args[]){
        int[][] intervals = {{7,10},{2,4}}; //{0,30},{5,10},{15,20}
        System.out.println("Result is : " +minimumRooms(intervals));
    }

    public static int minimumRooms(int[][] intervals){

        if(intervals == null)
            return 0;

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        //WORKING
       /* int room = 1;

        for(int i =0; i< intervals.length - 1; i++){
            if(intervals[i + 1][0] <  intervals[i][1])
                room++;
        }
        return room;*/

        //OR

        PriorityQueue<Integer> endTimeQ = new PriorityQueue<>();
        endTimeQ.add(intervals[0][1]);
        for(int i = 1; i< intervals.length; i++){
            if(intervals[i][0] >=  intervals[i - 1][1]) // No overlap
                endTimeQ.remove();

            endTimeQ.add(intervals[i][1]); //After using room add it back to Queue for reuse

        }

        return endTimeQ.size();
    }
}
