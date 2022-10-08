package com.leetcode.practice.easy;

import com.leetcode.practice.util.ListNode;

/**
 * ou are given the heads of two sorted linked lists list1 and list2. *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 *
 *
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {

    public static void main(String args[]) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        System.out.println("Result is : "  );
        ListNode result = mergeTwoLists(list1, list2);
        ListNode.printList(result);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultList  = new ListNode(-1);
        ListNode dummy = resultList;

        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                resultList.next = list2;
                list2 = list2.next;
            }
            else{
                resultList.next = list1;
                list1 = list1.next;
            }
            resultList = resultList.next;


        }

        if(list1 != null)
            resultList.next = list1;
        else if(list2 != null)
            resultList.next = list2;


        return dummy.next; //resultList.next NOT WORKING ...Will return last node


    }


}
