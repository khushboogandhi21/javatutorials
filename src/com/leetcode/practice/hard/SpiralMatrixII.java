package com.leetcode.practice.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.*
 *
 *
 * Example 1:
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 * Input: n = 1
 * Output: [[1]]
 *
 * Constraints:
 * 1 <= n <= 20
 */
public class SpiralMatrixII {

    public static void main(String[] args){

        System.out.println("Result is : "  );
        int[][] matrix = generateMatrix(3);

        //print matrix
        for(int i =0; i< matrix.length;i++){
            for(int j = 0; j< matrix.length;j++){
                System.out.print(matrix[i][j]+"," );
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int num) {
        int[][] matrix =new int[num][num];

        int top = 0 , down = num -1;
        int left = 0 , right = num -1;
        int direction = 0; //0 ->Right  1 ->down  2 ->left  3->top

        int count =0;
        while(left  <= right && top <= down){

            if(direction == 0 ){
                for(int i = left; i<=right ;i++){  //do not use while loop since we are just iterating not changing the actual value of left
                    matrix[top][i] = ++count;
                }
                top++;  //the index that's constant in for loop will be decremented
                direction = 1;  //assign the next direction to go for
            }
            else if(direction == 1){
                for(int i = top ; i <= down ;i++)
                   matrix[i][right] = ++count;
                right--;
                direction = 2;
            }
            else if(direction == 2 ){
                for(int i = right ; i >= left ;i--)
                   matrix[down][i] = ++count;
                down--;
                direction = 3;
            }
            else if(direction == 3 ){
                for(int i = down ; i >= top ;i--)
                   matrix[i][left] = ++count;
                left++;
                direction = 0;
            }
        }


       // direction = (direction + 1) % 4;  // NOT required

        return matrix;

    }
}
