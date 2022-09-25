package com.programs;

/*
Second approach convert linked list to int array and use traditional approach for vale comparison
 */
public class PalindromeLinkedList {
    public static  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode middle(ListNode head){  //Idea is to find the middle by traversing the nodes twice at x and 2x speed
      ListNode slow = head;
      ListNode fast = head;

      while(fast != null && fast.next != null){
          fast = fast.next.next;
          slow = slow.next;
      }

    return slow;
    }

    public static ListNode reverse(ListNode head){

        ListNode curr = head;
        ListNode prev = null; //prev<--- currX ->next

        while(curr != null){
            ListNode temp = curr.next; //want to save next node as we are going to break link
            curr.next = prev; //now change the pointer to prev(opp direction)
            prev = curr; //prev pointer moves ahead by 1
            curr = temp; //curr pointer moves ahead by 1

        }

        return prev;  //as curr is now null
    }

    public  static boolean isPalindrome(ListNode head){
//1,2,2,1


        if(head == null || head.next == null)  //single element  1
            return true;
        //find middle
        ListNode middle = middle(head);

        if(middle.next == null){
            if (middle.val == head.val)
                return true;
            else
                return false;
        }

        ListNode reverseList = reverse(middle.next); //reverse part of list after middle element

        boolean isPalindrome = true;
       // printList(reverseList);

        ListNode curr = head; //do not alter original
        if(reverseList != null) {
            while (reverseList != null) {
                if (reverseList.val != curr.val) {
                    isPalindrome = false;
                    break;
                }
                    reverseList = reverseList.next;
                    curr = curr.next;

            }

        }else
            return false;

        return isPalindrome ;

    }

    public static void printList(ListNode head){
        ListNode curr = head; //as the original node changes assign to temp var
        while(curr != null){
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }

    //OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();  //if innerclass non static
    public static void main(String[] args){

        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);


        // printList(reverse(node));
       System.out.println("\nisPalindrome : " + isPalindrome(node));
    }
}
