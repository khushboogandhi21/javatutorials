package com.leetcode.practice.easy;

import com.leetcode.practice.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 *
 * Follow up: Could you do this in one pass?
 */
public class RemoveNthNodeFromEndofList {

    public static void main(String args[]) {
        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);


        System.out.println("Result is : "  );
        ListNode result = removeNthFromEnd(node, 1);
        ListNode.printList(result);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null)
            return null;

        ListNode curr = head;
        for(int i = 0; i < n; i++){
            curr = curr.next;
        }

        ListNode removeNode = head;
        while(curr != null && curr.next != null){ //removeNode will reach node just before to the node to be deleted
            removeNode = removeNode.next;
            curr = curr.next;
        }

        if(removeNode.next != null){
            removeNode.next = removeNode.next.next;
        }

        return head;

    }




}
