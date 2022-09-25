package com.programs;


/*
Tree Constructor
Have the function TreeConstructor(strArr) take the array of strings stored in strArr,
which will contain pairs of integers in the following format: (i1,i2),
where i1 represents a child node in a tree and the second integer i2 signifies that it is the parent of i1.
For example: if strArr is ["(1,2)", "(2,4)", "(7,2)"], then this forms the following tree:
4
/
2
/  \
1    7
which you can see forms a proper binary tree. Your program should, in this case, return the string true because a valid binary tree can be formed. If a proper binary tree cannot be formed with the integer pairs, then return the string false. All of the integers within the tree will be unique, which means there can only be one node in the tree with the given integer value.
Examples
Input: new String[] {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"}
Output: true
Input: new String[] {"(1,2)", "(3,2)", "(2,12)", "(5,2)"}
Output: false
 */
public class TreeConstructor {
    public static String TreeConstructor(String[] strArr) {
        // code goes here
        String[] tempArr = strArr[0].replaceAll("\\(","").replaceAll("\\)","").split(",");
        Node root = new Node(tempArr[1],new Node(tempArr[0],null,null), null);
        for(int i = 1;i< strArr.length; i++){
            tempArr = strArr[i].replaceAll("\\(","").replaceAll("\\)","").split(",");
            //Node root = root;
          // while(root.left != null || root.right != null) {
               if ((root.data).equals(tempArr[1])) {
                   if (root.left == null) {
                       root.left = new Node(tempArr[0], null, null);
                   } else if (root.right == null) {
                       root.right = new Node(tempArr[0], null, null);
                   }
               } else if ((root.data).equals(tempArr[0])) {
                   root = new Node(tempArr[1], root, null);
              } else {
//                   root = root.left;
//                   search tree
                Node tempRoot = traversePath(root,tempArr[0]);
                if(tempRoot!=null){
                    root = tempRoot;
                }else{
                    tempRoot = traversePath(root,tempArr[1]);
                    if(tempRoot!=null){
                       // root = tempRoot;
                        if (tempRoot.left == null) {
                            tempRoot.left = new Node(tempArr[0], null, null);
                        } else if (root.right == null) {
                            tempRoot.right = new Node(tempArr[0], null, null);
                        }
                    }
                   // if not found store pair in separate arr
                }
//
              }
          // }
        }
        inOrder(root);
        System.out.println();
        return strArr[0];
    }

    public static Node traversePath(Node node, String searchLeaf){
        if(node == null)
            return null;
        Node searchNode = null;

        if(node != null){
            if(node.left!= null && (node.left.data).equals(searchLeaf) ){
                return node.left;
            }else if(node.right != null && (node.right.data).equals(searchLeaf) ){
                return node.right;
            }else{
                //node = node.left;
                searchNode = traversePath(node.left,searchLeaf);
                //node = node.right;
                searchNode = traversePath(node.right,searchLeaf);
//                if(searchNode == null){
//                    break;
//                }
            }
        }
       return searchNode;
    }

    public static void inOrder(Node node){
        if(node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + "->");
        inOrder(node.right);
    }

    public static void main (String[] args) {
        // keep this function call here
        //Scanner s = new Scanner(System.in);
        System.out.print(TreeConstructor(new String[] {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"}));
    }

    static class Node{
        String data;
        Node left;
        Node right;

        Node( String data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }


}
