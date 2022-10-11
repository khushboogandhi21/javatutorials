package com.leetcode.practice.util;

public class DoublyListNode {

      public int key;
      public int val;
      public DoublyListNode prev;
      public DoublyListNode next;

      public DoublyListNode(int key, int val) {
            this.key = key;
            this.val = val;
      }

      public static void printList(DoublyListNode head){
            DoublyListNode curr = head; //as the original node changes assign to temp var
            while(curr != null){
                  System.out.print(curr.val + "->");
                  curr = curr.next;
            }
      }
}
