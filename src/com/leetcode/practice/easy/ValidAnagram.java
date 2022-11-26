package com.leetcode.practice.easy;

/** The ASCII value of the lowercase alphabet is from 97 to 122.
 * And, the ASCII value of the uppercase alphabet is from 65 to 90.
*/

 public class ValidAnagram {

    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};
        String str1 ="care";
        String str2 ="race";

        System.out.println("Result:" + checkAnagram(str1,str2) );

    }

    private static boolean checkAnagram(String str1, String str2) {

        if(str1.length() != str2.length())
            return false;

        int[] intArray = new int[26];

        for(int i = 0; i< str1.length(); i++){

            intArray[str1.charAt(i)-97] = intArray[str1.charAt(i)-97] + 1;  //considering characters as lowercase
            //OR
            //intArray[str1.charAt(i)-'a']++;
                /*97 a
                98 b ->  97-98 = 1*/

            intArray[str2.charAt(i)-'a']--;

        }

       /* for(int i = 0; i< str2.length(); i++){ //NOT REQUIRED AS CAN USE SAME FOR LOOP AS BOTH STRINGS LENGTH IS SAME
            intArray[str2.charAt(i)-97] = intArray[str2.charAt(i)-97] - 1;
        }*/

        for(int i = 0; i< intArray.length; i++){
            if(intArray[i] != 0)
                return false;
        }

        return true;

    }
}
