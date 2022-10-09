package com.leetcode.practice.hard;

import com.leetcode.practice.util.ListNode;

import java.util.ArrayList;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 * Input: lists = []
 * Output: []
 * Example 3:
 * Input: lists = [[]]
 * Output: []
 *
 *
 * Constraints:
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 */
public class MergeKSortedLists {

    public static void main(String[] args){

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);


        ListNode[]  lists = {list1,list2,list3};
        System.out.println("Result is : " );

        ListNode result = mergeKLists(lists);
        ListNode.printList(result);
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        int low = 0, high = lists.length - 1;
        return merge(lists, low,high);
    }

    public static ListNode merge(ListNode[] lists, int low ,int  high ) {
        if(low == high){
            return lists[low];
        }

        int mid = low + (high - low)/2;
        ListNode list1 = merge(lists, low, mid );
        ListNode list2 = merge(lists, mid  + 1, high);

        ListNode result = mergeList(list1,list2);
        return result;

    }

    public static ListNode mergeList(ListNode list1, ListNode list2 ) {
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
