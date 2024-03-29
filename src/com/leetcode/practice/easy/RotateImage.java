package com.leetcode.practice.easy;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Example 2:
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 *
 * Constraints:
 * n == len == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
public class RotateImage {

    public static void main(String args[]){

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}}; // [[7,4,1],[8,5,2],[9,6,3]]

        System.out.println("Result is : "  );
        rotate(matrix);

        for(int i=0; i<matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.print(",");
        }

    }

    public static void rotate(int[][] matrix) {
        int len = matrix.length;

        for(int rows=0; rows<len; rows++) {
            for (int columns = rows; columns < len; columns++) {  //u need to start with rows not zero
                int temp =  matrix[rows][columns];
                matrix[rows][columns] = matrix[columns][rows];
                matrix[columns][rows] = temp;
            }
        }

        //reverse the rows
        for(int rows=0; rows<len; rows++) {
            for (int columns = 0; columns < len / 2; columns++) {
                int temp =  matrix[rows][len - 1 - columns];
                matrix[rows][len - 1 - columns] = matrix[rows][columns];
                matrix[rows][columns] = temp;
            }
        }
    }

}
