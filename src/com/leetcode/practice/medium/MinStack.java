package com.leetcode.practice.medium;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 *
 *
 * Example 1:
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 *
 * Constraints:
 *
 * -231 <= val <= 231 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */
public class MinStack {


    Stack<Integer> allStack;
    Stack<Integer> minValueStack;

    public static void main(String args[]){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Result is : " + minStack.getMin()); // return -3
        minStack.pop();
        System.out.println("Result is : " +minStack.top());    // return 0
        System.out.println("Result is : " + minStack.getMin()); // return -2

    }

    public MinStack() {
        allStack = new Stack<>();
        minValueStack = new Stack<>();
    }

    public void push(int val) {

        allStack.push(val);
        if(!minValueStack.isEmpty() && val <= minValueStack.peek()){
            minValueStack.push(val);
        }else if(minValueStack.isEmpty())
            minValueStack.push(val);
    }

    //removes the element on the top of the stack.
    public void pop() {
        int val = -1;
        if (!allStack.isEmpty()){
            val = allStack.pop();
            if (minValueStack.peek() == val)
                minValueStack.pop();
        }
    }

    //gets the top element of the stack
    public int top() {
        if(!allStack.isEmpty())
            return allStack.peek();
        else
            return -1;
    }

    public int getMin() {
        if(!minValueStack.isEmpty())
            return minValueStack.peek();
        else
            return -1;
    }
}
