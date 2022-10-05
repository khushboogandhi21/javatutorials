package com.leetcode.practice.medium;

public class AddTwoNumbers {

    public static void main(String args[]){
        // listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
        ListNode headA = new ListNode(2);
        headA.next = new ListNode(4);
        headA.next.next = new ListNode(3);


        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(4);

        ListNode result =addTwoNumbers(headA,headB );
        System.out.println("Result is : " +result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyA = l1;
        ListNode dummyB = l2;

        ListNode result = new ListNode(0);
        ListNode dummyResult = result;
        int carry = 0, remainder = 0;


        while(l1 != null || l2!=null){
            int x = l1 == null? 0: l1.val;
            int y = l2 == null? 0: l2.val;
            remainder = (x + y) % 10 + carry;
            carry = (x + y)/10;
            result.next = new ListNode(remainder);

            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }

        return dummyResult.next;

    }

}
