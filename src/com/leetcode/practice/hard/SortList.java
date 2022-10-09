package com.leetcode.practice.hard;

import com.leetcode.practice.util.ListNode;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Example 1:
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Example 2:
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105 *
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */
public class SortList {

    public static void main(String[] args){

        ListNode list1 = new ListNode(4);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(1);
        list1.next.next.next = new ListNode(3);


        System.out.println("Result is : " );

        ListNode result = sortList(list1);
        ListNode.printList(result);
    }


    public static ListNode sortList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;

        while(fast != null && fast.next != null){
            temp = slow; //stores previous node
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;  //break link from 1st part to 2nd

        ListNode l1 = sortList(head); //1st part
        ListNode l2 = sortList(slow); //2nd part

        return merge(l1,l2);


    }

    private static ListNode merge(ListNode list1, ListNode list2) {

        ListNode result = new ListNode(-1);
        ListNode dummy = result;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                result.next = list1;
                list1 = list1.next;
            }else{
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }

        if(list1!=null){
            result.next = list1;
        }
        if(list2!=null){
            result.next = list2;
        }

        return dummy.next;
    }
}
