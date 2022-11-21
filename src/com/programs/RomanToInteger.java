package com.programs;

import java.util.HashMap;
import java.util.Map;

/*
Largest to smallest: ADD
Smaller before Larger: Subtract smaller
 */
class RomanToInteger {

    public static int romanToInt(String s) {
        Map<Character,Integer> romanNumeralsMap = new HashMap<>();
        romanNumeralsMap.put('I',1);
        romanNumeralsMap.put('V',5);
        romanNumeralsMap.put('X',10);
        romanNumeralsMap.put('L',50);
        romanNumeralsMap.put('C',100);
        romanNumeralsMap.put('D',500);
        romanNumeralsMap.put('M',1000);

        int intValue = 0;
        char[] charArr = s.toCharArray();
        for(int i=0 ; i < charArr.length;i++){

            if (i+1 == charArr.length || romanNumeralsMap.get(charArr[i]) >= romanNumeralsMap.get(charArr[i + 1])) {  //i+1 == charArr.length ==>If last char no comparison required
                intValue += romanNumeralsMap.get(charArr[i]);
            } else {
                intValue -= romanNumeralsMap.get(charArr[i]);
            }
        }

        return intValue;
    }


    public static void main(String[] args){

        String str = "MCMXCIV";
        System.out.println("Integer equivalent for str:" +RomanToInteger.romanToInt(str));
    }
}