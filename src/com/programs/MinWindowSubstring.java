package com.programs;

import java.util.HashMap;
import java.util.Map;

/*
Have the function MinWindowSubstring(strArr) take the array of strings stored in strArr, which will contain only two strings,
the first parameter being the string N and the second parameter being a string K of some characters, and your goal is to determine
the smallest substring of N that contains all the characters in K.
 For example: if strArr is ["aaabaaddae", "aed"] then the smallest substring of N that contains the characters a, e, and d is "dae" located at the end of the string.
 So for this example your program should return the string dae.

Another example: if strArr is ["aabdccdbcacd", "aad"] then the smallest substring of N that contains all of the characters in K is "aabd"
which is located at the beginning of the string. Both parameters will be strings ranging in length from 1 to 50 characters and all of K's characters will exist
somewhere in the string N. Both strings will only contains lowercase alphabetic characters.
Examples
Input: new String[] {"ahffaksfajeeubsne", "jefaa"}
Output: aksfaje
Input: new String[] {"aaffhkksemckelloe", "fhea"}
Output: affhkkse
 */
public class MinWindowSubstring {
    public static String MinWindowSubstring(String[] strArr) {
        // code goes here
        String[] baseArr = strArr[0].split("");
        String[] searchArr = strArr[1].split("");
        boolean found  = false;
        int foundIndex = -1;
        Map<String,Boolean> foundMap =  new HashMap<>();

        for(int i=0;i<baseArr.length;i++){
            for(int j=0;j<searchArr.length;j++){
                if(!found  && strArr[1].contains(baseArr[i])){
                    found = true;
                    foundIndex = i;
                    foundMap.put(baseArr[i],true);
                }else if(found){
                    if(strArr[1].contains(baseArr[i])){
                        foundMap.put(baseArr[i],true);
                        if(foundMap.size() == searchArr.length){
                            return strArr[0].substring(foundIndex,i);
                        }
                    }//else{
//                        foundIndex = -1;
//                    }
                }
            }
        }
//        if(foundMap.size() != searchArr.length)
//            return strArr[0].substring(foundIndex,)
        return strArr[0];
    }

    public static void main (String[] args) {
        // keep this function call here
        //Scanner s = new Scanner(System.in);
        System.out.print(MinWindowSubstring(new String[] {"ahffaksfajeeubsne", "jefaa"}));
    }
}
