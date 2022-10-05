package com.leetcode.practice.medium;


import java.util.Stack;

/**
 * You have either one celebrity or none present.Celebrity knows no one but everyone knows celebrity.
 * Already a boolean function knows(a,b) is available.We need to call minimum times.
 * Instead below u can use 2D array also and can check if 0 or 1.0 for doesn't know and 1 for knows
 */

 public class FindTheCelebrity {

    public static void main(String args[]){
        int[][] roomDetails = {{0,1,0},{0,0,0}, {0,1,0}};
        System.out.println("Result is : " +getCelebrity(roomDetails, 3));
    }

    public static int getCelebrity(int[][] arr, int n){

        Stack<Integer> stackList = new Stack<>();
        for(int i =0 ; i< n; i++)
            stackList.push(i);

        while(stackList.size() != 1){
            int prospect1 = stackList.pop();
            int prospect2 = stackList.pop();
            if(arr[prospect1][prospect2] == 1)
                stackList.push(prospect2);
            else
                stackList.push(prospect1);

        }
        int celebrityProspect = stackList.pop();
        for(int i =0 ; i< n; i++){
            if(i == celebrityProspect) continue; //do not compare with self
            if(arr[celebrityProspect][i] != 0 || arr[i][celebrityProspect] != 1)
                return -1;
        }


        return celebrityProspect;

    }
}
