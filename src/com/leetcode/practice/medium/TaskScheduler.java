package com.leetcode.practice.medium;

import java.util.*;

/**
 * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task.
 * Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array),
 * that is that there must be at least n units of time between any two same tasks. *
 * Return the least number of units of times that the CPU will take to finish all the given tasks. *
 *
 * Example 1:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 *
 * Example 2:
 * Input: tasks = ["A","A","A","B","B","B"], n = 0
 * Output: 6
 * Explanation: On this case any permutation of size 6 would work since n = 0.
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * And so on.
 *
 * Example 3:
 * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * Output: 16
 * Explanation:
 * One possible solution is
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 *
 * Constraints:
 * 1 <= task.length <= 104
 * tasks[i] is upper-case English letter.
 * The integer n is in the range [0, 100].
 */
public class TaskScheduler {

    public static void main(String args[]){
        char[] tasks = {'A','A','A','B','B','B'};
        int cooldown = 2;
        System.out.println("Result is : " +leastInterval(tasks,cooldown));
    }
    public static int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> tasksFrequencyMap = new HashMap<>();
        for(int i = 0 ;i < tasks.length;i++)
            tasksFrequencyMap.put(tasks[i], tasksFrequencyMap.getOrDefault(tasks[i], 0) + 1);

        PriorityQueue<Integer> frequencyQ = new PriorityQueue<>((a,b) -> b-a);
        frequencyQ.addAll(tasksFrequencyMap.values());

        //Only frequencies matter now
        int result = 0;

        while(!frequencyQ.isEmpty()){
            List<Integer> workerList = new ArrayList<>();
            int time = 0;
            for(int i =0; i < n+1; i++){ //task time + cooldown time => 1+ n
                if(!frequencyQ.isEmpty()){
                    int freq = frequencyQ.poll() - 1;
                    if(freq != 0)
                        workerList.add(freq);
                    time++;

                }
            }

            if(!workerList.isEmpty()){
                frequencyQ.addAll(workerList); //add back remaining tasks since we only decremented freq by 1 and freq still not zero
            }

            if(frequencyQ.isEmpty()) //maybe all tasks executed before n+1
                result +=time;
            else
                result += n+1;
        }
        return result;
    }
}
