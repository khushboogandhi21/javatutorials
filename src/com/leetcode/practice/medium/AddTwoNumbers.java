package com.leetcode.practice.medium;

import com.leetcode.practice.util.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * Constraints:
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {

    public static void main(String args[]){
        // listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);


        ListNode headB = new ListNode(4);
        headB.next = new ListNode(9);
        headB.next.next = new ListNode(6);

        ListNode result = addTwoNumbers(headA,headB );
        System.out.println("Result is : " );
        result.printList(result);
    }

    /** The nos are in reverse form.Answer expected in reverse form */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode dummyResult = result;
        int carry = 0, sum = 0;


        while(l1 != null || l2 != null){
            int x = l1 == null? 0: l1.val;
            int y = l2 == null? 0: l2.val;
            sum = (x + y + carry) ;
            carry = sum / 10;
            result.next = new ListNode(sum  % 10 );

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            result = result.next;
        }
        if(carry > 0)
            result.next = new ListNode(carry );

        return dummyResult.next;

    }

}
