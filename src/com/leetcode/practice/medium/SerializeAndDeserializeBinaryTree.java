package com.leetcode.practice.medium;

import com.leetcode.practice.util.BinaryTree;
import com.leetcode.practice.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Example 1:
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * Example 2: *
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 10^4].
 * -1000 <= Node.val <= 1000
 */
public class SerializeAndDeserializeBinaryTree {

    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};
        BinaryTree binaryTree = new BinaryTree();
        String result  = serialize(binaryTree.createBinaryTree(arr));
        TreeNode root = deserialize(result);
       // System.out.println("Result is : " +);
    }

    // Encodes a tree to a single string.
    public static  String serialize(TreeNode root) {

        Queue<TreeNode> nodeQueue = new LinkedList<>();

        nodeQueue.add(root);

        StringBuffer str = new StringBuffer();

        while(!nodeQueue.isEmpty()){


            TreeNode node =  nodeQueue.poll();
            if(node!=null){
                str.append(node.value + ",");
                if(node.left != null)
                    nodeQueue.add(node.left);
                /*else
                    System.out.println(null + ",");
                */
                if(node.right != null)
                    nodeQueue.add(node.right);
               /* else
                    System.out.println(null + ",");*/
            }else {
                str.append( "X");
            }

        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String str) {
        String[] strArr = str.split(",");
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        nodeQueue.add(root);

        for(int i =1; i< strArr.length; i++){
            TreeNode node = nodeQueue.poll();
            node.left = new TreeNode(Integer.parseInt(strArr[i]));
            node.right = new TreeNode(Integer.parseInt(strArr[++i]));

            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return root;
    }

}
