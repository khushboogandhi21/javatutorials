package com.leetcode.practice.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralMatrixI {

    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Result is : " + spiralOrder(matrix) );

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();

        int top = 0 , down = matrix.length -1;
        int left = 0 , right = matrix.length -1;
        int direction = 0; //0 ->Right  1 ->down  2 ->left  3->top

        while(left  <= right && top <= down){

            if(direction == 0 ){
                for(int i = left; i<=right ;i++){  //do not use whle loop since we are just iterating not changing the actual value of left
                    resultList.add(matrix[top][i]);
                }
                top++;  //the index that's constant in for loop will be decremented
                direction = 1;  //assign the next direction to go for
            }
            else if(direction == 1){
                for(int i = top ; i <= down ;i++)
                    resultList.add(matrix[i][right]);
                right--;
                direction = 2;
            }
            else if(direction == 2 ){
                for(int i = right ; i >= left ;i--)
                    resultList.add(matrix[down][i]);
                down--;
                direction = 3;
            }
            else if(direction == 3 ){
                for(int i = down ; i >= top ;i--)
                    resultList.add(matrix[i][left]);
                left++;
                direction = 0;
            }
        }


       // direction = (direction + 1) % 4;  // NOT required

        return resultList;

    }
}
