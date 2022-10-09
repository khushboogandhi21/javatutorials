package com.leetcode.practice.easy;

import com.leetcode.practice.util.BinaryTree;
import com.leetcode.practice.util.TreeNode;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 * Input: root = [2,1,3]
 * Output: true
 * Example 2:
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args){

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println("Result is : " + isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        Integer max = null, min = null;
        return validateBST(root, max,min);

    }

    public static boolean validateBST(TreeNode root, Integer max, Integer min){
        if(root == null)
            return true;
        if(max!= null && root.value > max || min != null && root.value < min )
            return false;

        validateBST(root.left, root.value,null);
        validateBST(root.right, null,root.value);

        return true;
    }
}
