package com.leetcode.practice.medium;

/**
 * Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
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
 * Input: columnTitle = "A"
 * Output: 1
 *
 * Example 2:
 * Input: columnTitle = "AB"
 * Output: 28
 *
 * Example 3:
 * Input: columnTitle = "ZY"
 * Output: 701
 *
 *
 * Constraints:
 * 1 <= columnTitle.length <= 7
 * columnTitle consists only of uppercase English letters.
 * columnTitle is in the range ["A", "FXSHRXW"].
 */
public class ExcelSheetColumnNumber {
    public static void main(String args[]){

        System.out.println("Result is : "  + convertAlphaToColumnNumber("ZY"));
    }

    private static int convertAlphaToColumnNumber(String str) {
        int result = 0;
        //convert string to digits
        for(int i= 0; i<str.length();i++ ){
            int digit  = str.charAt(i) - 'A' + 1; //+1 for offset
            result = result * 26 + digit;  //instead of 10 for decimal system use 26 for alphabets

        }
        return result;

    }

}
