package com.leetcode.practice.medium;



import com.leetcode.practice.util.TreeNode;

public class BinaryTreeTraversal {

    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("PreOrder:" );
        preOrder(root);
        System.out.println("\nPostOrder:" );
        postOrder(root);
        System.out.println("\nInOrder:" );
        inOrder(root);
        // System.out.println("Result is : " +);
    }

    private static void inOrder(TreeNode root) {
        if(root == null)
            return;

        inOrder(root.left);
        System.out.print( root.value + ",");
        inOrder(root.right);

    }

    private static void postOrder(TreeNode root) {
        if(root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print( root.value + ",");
    }

    private static void preOrder(TreeNode root) {
        if(root == null)
            return;

        System.out.print( root.value + ",");

        preOrder(root.left);
        preOrder(root.right);



    }
}
