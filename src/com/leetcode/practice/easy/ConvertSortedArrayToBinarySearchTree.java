package com.leetcode.practice.easy;

import com.leetcode.practice.util.BinaryTree;
import com.leetcode.practice.util.TreeNode;

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 *
 * Example 1:
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 *
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args){

        /*TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);*/

        int[] arr = {-10,-3,0,5,9};
        System.out.println("Result is : " );

        TreeNode root = sortedArrayToBST(arr);
        System.out.println("Traversal Result is : " );
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.traverseLevelOrder(root);
    }

    public static  TreeNode sortedArrayToBST(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        TreeNode root =  generateBST(nums, low, high);

        return root;

    }

    public static  TreeNode generateBST(int[] nums,  int low, int high ) { //execute in leetcode

        if(low > high)
            return null;

        int mid = low + (high-low)/2;
        TreeNode root = new TreeNode(nums[mid]); //value not index

        root.left = generateBST(nums, low, mid- 1 );  //will return left node which is mid of left subarray
        root.right = generateBST(nums, mid + 1, high);  ////will return right node which is mid of right subarray

        return root;

    }


}
