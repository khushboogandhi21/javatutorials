package com.programs;
class Node{  //or u can declare it outside BinaryTreeDetails
    int value = 0;
    Node left;
    Node right;

    Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
public class BinaryTreeDetails {



    private int getMaxDepth(Node node){

        if(node == null)
            return -1;

        int lDepth =  getMaxDepth(node.left);
        int rDepth =  getMaxDepth(node.right);

        if(lDepth > rDepth)
            return lDepth + 1;  // + 1 for current node level
        else
            return rDepth + 1;

    }

    /* computes number of nodes in tree */
    private int size(Node node)
    {
        if (node == null)
            return 0;
        else
            return(size(node.left) + 1 + size(node.right));   // + 1 for current node
    }

    private boolean isBalanced(Node node) {

        if(node == null)
            return true;    /* If tree is empty then return true */

        int lHeight =  height(node.left);  //could have used getMaxDepth() here which is better version
        int rHeight =  height(node.right);

        //check if tree is balanced
        if(Math.abs(lHeight-rHeight) <=1 && isBalanced(node.left) && isBalanced(node.right))
            return true;
        else
            return false;
    }

    private int height(Node node) {  //could have used getMaxDepth() here

        if(node == null)
            return 0;

        return Math.max(height(node.left),height(node.right)) + 1;
    }


    /**The idea is to traverse the tree, starting from root.
     * For every node, check if its left subtree is a leaf. If it is, then add it to the result.
     *
     * @param node
     * @return
     */
    private int sumOfLeftLeaves(Node node) {

        if(node == null)
            return 0;    /* If node is empty then return 0 */

        if(node.left != null && node.left.left == null && node.left.right == null){  //If left part of node is leaf node calculate value sum and traverse the right
            return node.left.value + sumOfLeftLeaves(node.right);
        }
        return sumOfLeftLeaves(node.left) + sumOfLeftLeaves(node.right);
    }



    public static void main(String args[]){

          /* Constructed binary tree is
                   1
                 /   \
                2      3
              /  \    /
            4     5  6
            /
           7         */

        BinaryTreeDetails binaryTreeDetails = new BinaryTreeDetails();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.left.left.left = new Node(7);


        //false example
       /* BinaryTreeDetails binaryTreeDetails = new BinaryTreeDetails();
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(5);
        root.right.left = new Node(3);
        root.right.right = new Node(7);
        root.right.right.left = new Node(4);
        root.right.right.right = new Node(9);*/

        System.out.println("Max Height of Binary tree is:" + binaryTreeDetails.getMaxDepth(root));
        System.out.println("Size of Binary tree is:" + binaryTreeDetails.size(root));
        System.out.println("IsBalanced Binary tree is:" + binaryTreeDetails.isBalanced(root));

        System.out.println("Sum Of Left Leaves for Binary tree is:" + binaryTreeDetails.sumOfLeftLeaves(root));

    }


}
