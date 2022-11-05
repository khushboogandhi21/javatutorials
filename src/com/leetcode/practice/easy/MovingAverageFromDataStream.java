package com.leetcode.practice.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * Example:
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverageFromDataStream {


    private int sum;
    private Queue<Integer> queue;
    private int capacity;

    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        queue = new LinkedList<Integer>();
        sum = 0;
        capacity = size;
    }

    public double next(int val) {
        if (queue.size() == capacity) {
            int sub = queue.poll();
            sum = sum - sub;
        }
        queue.offer(val);
        sum = sum + val;

        return (double) sum / queue.size();
    }

    public static void main(String args[]){
        MovingAverageFromDataStream m = new MovingAverageFromDataStream(3);

        System.out.println("Result is : " +m.next(1));  // 1
        System.out.println("Result is : " +m.next(10)); // (1 + 10) / 2;
        System.out.println("Result is : " +m.next(3) ); // (1 + 10 + 3) / 3;
        System.out.println("Result is : " +m.next(5) ); // (10 + 3 + 5) / 3;


    }
}
