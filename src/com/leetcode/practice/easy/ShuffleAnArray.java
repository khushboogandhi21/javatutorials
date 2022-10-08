package com.leetcode.practice.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**              Fisher Yates Algorithm   *****
 * Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.
 *
 * Implement the Solution class:
 * Solution(int[] nums) Initializes the object with the integer array nums.
 * int[] reset() Resets the array to its original configuration and returns it.
 * int[] shuffle() Returns a random shuffling of the array.
 *
 *
 * Example 1:
 * Input
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * Output
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * Explanation
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
 *                        // Any permutation of [1,2,3] must be equally likely to be returned.
 *                        // Example: return [3, 1, 2]
 * solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
 * solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 50
 * -106 <= nums[i] <= 106
 * All the elements of nums are unique.
 * At most 104 calls in total will be made to reset and shuffle.
 */
public class ShuffleAnArray {
    int[] nums;
    Random random;

    public static void main(String args[]){
        int[] nums = {0,1,0,3,2,3};
        ShuffleAnArray obj = new ShuffleAnArray(nums);

        int[] param_2 = obj.shuffle();
        System.out.println("Result is : " );
        Arrays.stream(param_2).forEach(System.out::print);

        int[] param_1 = obj.reset();
        System.out.println("\nResult is : " );
        Arrays.stream(param_1).forEach(System.out::print);

    }

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] copyArray  = nums.clone();
        for(int i = copyArray.length - 1; i > 0; i-- ){
            int randomIndex = random.nextInt(i);  //bound can be between 1 to Integer.max
            int temp = copyArray[i];
            copyArray[i] = copyArray[randomIndex];
            copyArray[randomIndex] = temp;
        }
        return copyArray;
    }
}
