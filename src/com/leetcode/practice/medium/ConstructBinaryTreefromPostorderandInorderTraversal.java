package com.leetcode.practice.medium;

import com.leetcode.practice.util.BinaryTree;
import com.leetcode.practice.util.TreeNode;

import java.util.*;

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree
 * and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 *
 *
 * Example 1:
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 * Constraints:
 *
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 */

public class ConstructBinaryTreefromPostorderandInorderTraversal {

    public static void main(String args[]){
        int[] postorder = {9,15,7,20,3}; //{1,3,2}
        int[] inorder = {9,3,15,20,7}; //{1,2,3}
        System.out.println("Result is : " +buildTree(inorder,postorder ));
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inOrderMap = new HashMap<>();
        for(int i = 0; i< inorder.length; i++)
            inOrderMap.put(inorder[i],i);


        TreeNode root = buildSubTree(0, inorder.length - 1,inorder,0, postorder.length - 1,postorder,inOrderMap);

        traverseBFSLevelOrder(root);

        return root;
    }

    public static TreeNode buildSubTree(int istart, int iend,  int[] inorder,int pstart, int pend,  int[] postorder, Map<Integer,Integer>  inOrderMap) {

        if(pstart > pend || istart> iend) return null;

        int rootIndex = inOrderMap.get(postorder[pend]);
        int numsLeft = rootIndex - istart; //left part of postOrder

        TreeNode root = new TreeNode(postorder[pend]);


        root.left =  buildSubTree(istart,  rootIndex - 1,   inorder,  pstart,  pstart + numsLeft - 1,   postorder,  inOrderMap);
        root.right =  buildSubTree(  rootIndex + 1,  iend,   inorder,pstart + numsLeft ,  pend - 1,   postorder,   inOrderMap); //pend -1 since last node is root node

        return root;
    }
    public static void traverseBFSLevelOrder(TreeNode root) {

        Queue<TreeNode> nodeQueue = new LinkedList<>();

        nodeQueue.add(root);

        while(!nodeQueue.isEmpty()){


                TreeNode node =  nodeQueue.poll();
                if(node!=null){
                    System.out.println(node.value + ",");
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
                    System.out.println(null + ",");
                }


        }

    }

}
