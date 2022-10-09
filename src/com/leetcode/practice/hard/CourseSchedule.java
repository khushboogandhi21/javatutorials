package com.leetcode.practice.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {

    static boolean[] visited ;
    static boolean[] marked ;

    static List<Integer>[] adjacencyArray;

    public static void main(String[] args){

        int[][] prerequisites = {{1,0},{0,1}};

        System.out.println("Result : " +  canFinish(2,prerequisites));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        adjacencyArray = new ArrayList[numCourses];  //array of List

         visited = new boolean[numCourses];
         marked = new boolean[numCourses];

        for(int i =0; i< numCourses;i++){
            adjacencyArray[i] = new ArrayList<>();  //initialize arraylist at each index
        }

        //array index is course in prerequisite and all courses its dependent on goes in list
        for(int i =0; i< prerequisites.length;i++){
            //add the course dependency listed in prerequisites in adjacency array, 1st course goes as key index,second course in the list
            adjacencyArray[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for(int i=0;i<numCourses;i++){  //check if each course is visited and cyclic
            if(!visited[i]){
                if(isCyclic(i)){
                    return false;
                }
            }
        }

        return true;  //No course is cyclic

    }

    private static boolean isCyclic(int i) {
        visited[i] = true;
        //iterate the dependency list against each course
        for(Integer j : adjacencyArray[i]){  //OR for(int j =0;j<adjacencyArray[i].size();j++){
            if(!visited[j]){   // OR if(!visited[adjacencyArray[i].get(j)]){
                if(isCyclic(j))
                    return true;
            }else{
                if(!marked[j])   //visited but not marked means cycle
                    return true;
            }
        }

        marked[i] = true;

        return false;
    }
}
