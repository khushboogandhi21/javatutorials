package com.leetcode.practice.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order. *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 * Example 1: *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */
public class GroupAnagrams {

    public static void main(String args[]){
        String[] strArray = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result  =groupAnagrams(strArray);
        System.out.println("Result is : " +result);
    }

    public static List<List<String>> groupAnagrams(String[] strArray) {
        List<List<String>> resultList = new ArrayList<>();
        Map<String, List<String>> resultMap = new HashMap<>();

        for(int i =0; i< strArray.length; i++){
            int[] intArray = new int[26];
            StringBuffer sb = new StringBuffer();
            for(char c: strArray[i].toCharArray()){
                intArray[c- 97]++;
            }
            for(int index: intArray){
                sb.append(index);
            }
            List arrList = null;

            String str = sb.toString();
            if(!resultMap.containsKey(str)){
                resultMap.put(str, new ArrayList<>() );
            }

            // resultMap.put(str, resultMap.get(str).add(strArray[i]) ); Here calling Put not required
            resultMap.get(str).add(strArray[i]);

        }

        resultList.addAll(resultMap.values());

        return resultList;
    }
}
