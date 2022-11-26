package com.leetcode.practice.medium;

/**
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 *
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 *
 * Example 1:
 * Input: columnNumber = 1
 * Output: "A"
 *
 * Example 2:
 * Input: columnNumber = 28
 * Output: "AB"
 *
 * Example 3:
 * Input: columnNumber = 701
 * Output: "ZY"
 *
 * Constraints:
 * 1 <= columnNumber <= 231 - 1
 */
public class ExcelSheetColumnTitle {

    public static void main(String args[]){

        System.out.println("Result is : "  + convertColumnNumberToAlpha(701));
    }

    private static String convertColumnNumberToAlpha(int num) {
        StringBuilder result = new StringBuilder();

        //convert digits to string
        while(num>0){
            int lsd = 'A' + (num - 1) % 26 ; //Remainder will give least significant digit,  -1 for offset
            char lsdChar = (char)lsd;
            result.append(lsdChar);
            num = (num - 1)  / 26;

        }
        return result.reverse().toString();

    }

}
