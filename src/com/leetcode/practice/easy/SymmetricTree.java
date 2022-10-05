package com.leetcode.practice.easy;

import com.leetcode.practice.util.BinaryTree;
import com.leetcode.practice.util.TreeNode;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * Example 1: *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2: *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *
 * Follow up: Could you solve it both recursively and iteratively?
 */

/*class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}*/


public class SymmetricTree {


    public static void main(String args[]){
        int[] arr = {1,2,2,3,4,4,3};
        /*BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.createBinaryTree(arr);*/

        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(3);

        System.out.println("Traversal Result is : " );
        tree.traverseLevelOrder(tree.root);

        System.out.println("\nResult is : " + isSymmetric(tree.root));
    }


    public static boolean isSymmetric(TreeNode root) {
      /*  //boundary condition
        if(root == null)
            return true;*/

        return checkSymmetric(root,root);

    }

    private static boolean checkSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null)  return true; //order of these two conditions is Important
        if(left == null || right == null)  return false;

       /* if( left.value != right.value)
            return false;*/

        return (left.value == right.value) && checkSymmetric(left.left,right.right) && checkSymmetric(left.right,right.left);


    }
}
