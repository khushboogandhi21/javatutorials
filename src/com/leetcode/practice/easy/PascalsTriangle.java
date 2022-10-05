package com.leetcode.practice.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1: *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2: *
 * Input: numRows = 1
 * Output: [[1]]
 *
 * Constraints:
 *
 * 1 <= numRows <= 30
 */


public class PascalsTriangle {

    public static void main(String args[]){
        System.out.println("Result is : " +generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {

        if(numRows < 1 || numRows > 30)
            return null;
        List<List<Integer>> result = new ArrayList<>();

        List rowList = new ArrayList();
        rowList.add(1);
        result.add(rowList);

        for(int i = 1; i < numRows;i++){
            List prevRow = result.get(i-1);
            rowList = new ArrayList();
            rowList.add(1);
            for(int j = 1; j < i; j++){
                rowList.add((Integer)prevRow.get(j) + (Integer) prevRow.get(j-1));
            }
            rowList.add(1);
            result.add(rowList);
        }
        return result;

    }
}
