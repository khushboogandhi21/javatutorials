package com.leetcode.practice.hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 *
 * Implement the LFUCache class:
 *
 * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
 * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
 * void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
 * To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.
 *
 * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.
 *
 * The functions get and put must each run in O(1) average time complexity.
 *
 *
 *
 * Example 1:
 * Input
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 *
 * Explanation
 * // cnt(x) = the use counter for key x
 * // cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // return 1
 *                  // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
 *                  // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // return -1 (not found)
 * lfu.get(3);      // return 3
 *                  // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
 *                  // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // return -1 (not found)
 * lfu.get(3);      // return 3
 *                  // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // return 4
 *                  // cache=[4,3], cnt(4)=2, cnt(3)=3
 *
 *
 * Constraints:
 * 0 <= capacity <= 104
 * 0 <= key <= 105
 * 0 <= value <= 109
 * At most 2 * 105 calls will be made to get and put.
 */
public class LFUCache {

    int capacity;
    int minFrequencyCount = -1;
    Map<Integer,Integer> dataStore;
    Map<Integer,Integer> frequencyCountMap; //to identify which frequency key needs to be evicted
    Map<Integer, LinkedHashSet<Integer>> frequencySetMap; //key is frequency count


    public static void main(String args[]){
        LFUCache lfuCache = new LFUCache(2);

        lfuCache.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfuCache.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        int param_1 = lfuCache.get(1);      // return 1
                   // cache=[1,2], cnt(2)=1, cnt(1)=2
        System.out.println("Result is : " + param_1);


       lfuCache.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
               // cache=[3,1], cnt(3)=1, cnt(1)=2
        param_1  = lfuCache.get(2);      // return -1 (not found)
        System.out.println("Result is : " + param_1);

        param_1 = lfuCache.get(3);      // return 3
               // cache=[3,1], cnt(3)=2, cnt(1)=2
        System.out.println("Result is : " + param_1);

        lfuCache.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
               // cache=[4,3], cnt(4)=1, cnt(3)=2
        param_1 = lfuCache.get(1);      // return -1 (not found)
        System.out.println("Result is : " + param_1);

        param_1 = lfuCache.get(3);      // return 3
               // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println("Result is : " + param_1);

        param_1 = lfuCache.get(4);      // return 4
               // cache=[4,3], cnt(4)=2, cnt(3)=3
        System.out.println("Result is : " + param_1);


    }

    public LFUCache(int capacity) {
        this.capacity = capacity; //this is important otherwise capacity is 0
        this.dataStore = new HashMap<>();
        this.frequencyCountMap = new HashMap<>();
        this.frequencySetMap = new HashMap<>();
    }

    public int get(int key) {

        if(dataStore.containsKey(key)){
            //update frequency Count
            int prevFreq = frequencyCountMap.get(key);
            //if(frequencyCountMap.containsKey(key))
                frequencyCountMap.put(key, prevFreq + 1);  //++ not working
           /* else
                frequencyCountMap.put(key, 1); */

            //update key set Map [remove and add]
            frequencySetMap.get(prevFreq).remove(key);
            LinkedHashSet<Integer> freqSet  = frequencySetMap.get(prevFreq + 1);
            if(freqSet == null)
                freqSet = new LinkedHashSet<>();
            freqSet.add(key);
            frequencySetMap.put(prevFreq + 1,freqSet);

            //update min count
            if(minFrequencyCount == prevFreq && frequencySetMap.get(prevFreq).size() == 0) //if prev freq list was mincount and now it became zero size set , the next count will be min frequency count
                minFrequencyCount = prevFreq + 1;

            return dataStore.get(key);

        }else
            return -1;

    }

    public void put(int key, int value) {

        //update
        if(dataStore.containsKey(key)){

            dataStore.put(key, value ); //update value

            //update frequency Count
            //update key set Map [remove and add]
            get(key); //same steps
            return; //DO NOT PROCEED DOWN
        }

        //OR
        //insert - 2 cases check if capacity reached
       else if(capacity == dataStore.size()){
            int evictKey = frequencySetMap.get(minFrequencyCount).iterator().next();
            frequencySetMap.get(minFrequencyCount).remove(evictKey); //remove key from LinkedHashSet
            dataStore.remove(evictKey);
            frequencyCountMap.remove(evictKey); //remove not decrement count since we  removed key from cache
        }

        dataStore.put(key,value);
        frequencyCountMap.put(key, 1);

        //update min count
        minFrequencyCount = 1;  //A newly added element will also be least used

        LinkedHashSet<Integer> set =  frequencySetMap.get(1) != null ? frequencySetMap.get(1) : new LinkedHashSet<>();
        set.add(key);
        frequencySetMap.put(1, set);

    }

}
