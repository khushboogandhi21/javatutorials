package com.leetcode.practice.easy;

/**
 * Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image. *
 * To flip an image horizontally means that each row of the image is reversed. *
 * For example, flipping [1,1,0] horizontally results in [0,1,1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 * For example, inverting [0,1,1] results in [1,0,0].
 *
 *
 * Example 1: *
 * Input: image = [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * Example 2:
 * Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *
 *
 * Constraints:
 *
 * n == image.length
 * n == image[i].length
 * 1 <= n <= 20
 * images[i][j] is either 0 or 1.
 */
public class FlippingAnImage {

    public static void main(String args[]){

        int[][] image = {{1,1,0,1},{1,0,1,1},{0,0,0,1}}; // Final ->[[1,0,0],[0,1,0],[1,1,1]] //Flip -> [[0,1,1],[1,0,1],[0,0,0]].

        System.out.println("Result is : "  );
        flipAndInvertImage(image);

        for(int i=0; i<image.length; i++) {
            for (int j = 0; j < image.length; j++) {
                System.out.print(image[i][j]);
            }
            System.out.print(",");
        }

    }

    public static int[][] flipAndInvertImage(int[][] image) {

        for(int i=0; i<image.length; i++) {
            int j = 0, k=image.length - 1;  //since its n x n  matrix it will work else need to use k = image[i].length - 1
            while(j<k){
                int temp = image[i][j];
                image[i][j] = image[i][k];
                image[i][k] = temp;
                j++;
                k--;
            }
        }

        for(int i=0; i<image.length; i++) {
            for (int j = 0; j < image.length; j++) {
                image[i][j] = image[i][j] == 0 ? 1 : 0;
            }
        }

        return image;

    }
}
