package com.leetcode.practice.util;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public TreeNode root;

    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        int[] arr = {1,2,2,3,4,4,3}; //{25,11,15,16,23,79};
        System.out.println("Result is : " +  binaryTree.createBinaryTree(arr)); //;
        System.out.println("Traversal Result is : " );
        binaryTree.traverseLevelOrder(binaryTree.root);
    }

    public TreeNode createBinaryTree(int[] arr) {

        for(int i: arr){
            //bt.add(i);
            insert(this.root,i);
        }

        return root;
    }

    /** BINARY TREE LEVEL ORDER TRAVERSAL */
    public void traverseLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            TreeNode node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    public void insert(TreeNode node, int value)
    {
        if (node == null) {
            this.root = new TreeNode(value);
            System.out.println("  Inserted Root " + this.root.value);
            return;
        }
        if (value < node.value)
        {
            if (node.left != null)
            {
                insert(node.left, value);
            } else
            {
                System.out.println("  Inserted " + value + " to left of Node " + node.value);
                node.left = new TreeNode(value);
            }
        }
        else if (value > node.value)
        {
            if (node.right != null)
            {
                insert(node.right, value);
            } else
            {
                System.out.println("  Inserted " + value + " to right of Node " + node.value);
                node.right = new TreeNode(value);
            }
        }
    }
}
