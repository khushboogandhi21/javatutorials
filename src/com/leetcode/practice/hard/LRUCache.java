package com.leetcode.practice.hard;

import com.leetcode.practice.util.DoublyListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 *
 *
 * Example 1:
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 *
 * Constraints:
 * 1 <= capacity <= 3000
 * 0 <= key <= 104
 * 0 <= value <= 105
 * At most 2 * 105 calls will be made to get and put.
 */
public class LRUCache {

    int capacity;

    Map<Integer, DoublyListNode> dataStore;

    DoublyListNode head = new DoublyListNode(0,0);
    DoublyListNode tail =  new DoublyListNode(0,0);

    public static void main(String args[]){
        LRUCache lRUCache = new LRUCache(2);

        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2} in ORDER
        int param_1 = lRUCache.get(1);    // return 1   now 1 comes at top 2 goes back
        System.out.println("Result is : " + param_1);

        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        param_1 = lRUCache.get(2);    // returns -1 (not found)
        System.out.println("Result is : " + param_1);

        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        param_1 = lRUCache.get(1);    // return -1 (not found)
        System.out.println("Result is : " + param_1);
        param_1 = lRUCache.get(3);    // return 3
        System.out.println("Result is : " + param_1);
        param_1 = lRUCache.get(4);    // return 4
        System.out.println("Result is : " + param_1);

    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dataStore = new HashMap<>();
        head.next = tail;
        tail.prev = head;

    }

    //if exists remove and place new version at the top
    public int get(int key) {
        if(dataStore.containsKey(key)){
            //retrieve
            DoublyListNode result = dataStore.get(key);

            //removal for placing new version to top
            remove(result);

            //put
            insert(result);

            return result.val;
        }else
            return -1;
    }

    public void put(int key, int value) {

        DoublyListNode node;
        if(dataStore.containsKey(key)){  //update scenario

            //retrieve
            node = dataStore.get(key);

            //removal for placing new version to top
            remove(node);
        }else { //insert scenario

            // if cache is full
            if (capacity == dataStore.size()) {
                //remove least recent used element as well  which will be tail.prev
                remove(tail.prev);  //IMP
            }
        }

        //common
        //put  new version at TOP
        node  = new DoublyListNode(key,value);
        insert(node);

    }

    void remove(DoublyListNode node){
        dataStore.remove(node.key);

        DoublyListNode temp = node.prev;
        node.next.prev = temp;
        temp.next = node.next;

    }

    void insert(DoublyListNode node){

        dataStore.put(node.key, node);

        DoublyListNode temp = head.next;  //place at top
        head.next = node;
        temp.prev = node;
        node.next = temp;
        node.prev = head;

    }

}
