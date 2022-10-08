package com.leetcode.practice.util;

public class ListNode {

      public int val;
      public ListNode next;

      public ListNode(int x) { val = x; }

      public static void printList(ListNode head){
            ListNode curr = head; //as the original node changes assign to temp var
            while(curr != null){
                  System.out.print(curr.val + "->");
                  curr = curr.next;
            }
      }
}
