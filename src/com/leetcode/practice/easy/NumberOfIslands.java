package com.leetcode.practice.easy;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands. *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 *
 * Example 1:
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Example 2:
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {
    public static void main(String args[]){
        char [][] grid = { {'1','1','1','1','0'},
                           {'1','1','0','1','0'},
                           {'1','1','0','0','0'},
                           {'0','0','0','0','0'}};

        System.out.println("Result is : " + numIslands(grid));

    }

    public static int numIslands(char[][] grid) {
        int sum = 0;

        //grid.length Will not work since its m xn matrix rows and cols differ
        //grid.length prints no of rows. For columns use grid[0].length
        int rows = grid.length;
        if(rows == 0 )
            return 0;
        int columns = grid[0].length;
        for(int i =0;i < rows; i++){
            for(int j =0; j< columns; j++){
                if(grid[i][j] == '1'){ // if we find '1', we need to consider adjacent 1s as part of 1 single island, so we call recursion method to mark all as visited by '2'
                    markIslands(grid,i,j,rows,columns);
                    sum +=1;
                }
            }
        }
        return sum;
    }

    private static void markIslands(char[][] grid, int i, int j,int rows,int columns) {

        if(i < 0 || i >= grid.length
        || j < 0 || j >= grid.length
                || grid[i][j] != '1') return; //limiting condition include boundary conditions

        grid[i][j] = '2'; //mark visited

        //explore adjacent cells
        markIslands(grid,i+1,j,rows,columns);//bottom
        markIslands(grid,i-1,j,rows,columns); //top
        markIslands(grid,i,j + 1,rows,columns); //right
        markIslands(grid,i,j - 1,rows,columns); //left
    }
}
