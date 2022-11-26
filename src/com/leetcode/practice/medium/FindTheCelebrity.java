package com.leetcode.practice.medium;


import java.util.Stack;

/**
 * In a party of N people, only one person is known to everyone. Such a person may be present in the party,
 * if yes, (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “.
 * Find the stranger (celebrity) in the minimum number of questions.
 * We can describe the problem input as an array of numbers/characters representing persons in the party.
 * We also have a hypothetical function knows(A, B) which returns true if A knows B, false otherwise. How can we solve the problem.
 *
 * Examples:
 *
 * Input:
 * MATRIX = { {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0} }
 * Output: id = 2
 * Explanation: The person with ID 2 does not know anyone but everyone knows him
 *
 * Input:
 * MATRIX = { {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 1, 0, 0}, {0, 0, 1, 0} }
 * Output: No celebrity
 * Explanation: There is no celebrity.
 *
 * You have either one celebrity or none present.Celebrity knows no one but everyone knows celebrity.
 * Already a boolean function knows(a,b) is available.We need to call minimum times.
 * Instead below u can use 2D array also and can check if 0 or 1.0 for doesn't know and 1 for knows
 */

 public class FindTheCelebrity {

    public static void main(String args[]){
        int[][] peopleDetails = {{0,1,0},
                                {0,0,0},
                                {0,1,0}};
        System.out.println("Result is : " +getCelebrity(peopleDetails, 3));
    }

    public static int getCelebrity(int[][] arr, int n){

        Stack<Integer> stackList = new Stack<>();
        System.out.println("Default Capacity of Java stack class is:" + stackList.capacity());
        for(int i =0 ; i< n; i++)
            stackList.push(i);

        while(stackList.size() != 1){
            int prospect1 = stackList.pop();
            int prospect2 = stackList.pop();
            if(arr[prospect1][prospect2] == 1)  //Here actually knows method need to be called
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
