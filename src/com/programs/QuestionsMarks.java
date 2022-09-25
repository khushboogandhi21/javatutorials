package com.programs;

import java.util.regex.*;

/*
Questions Marks
Have the function QuestionsMarks(str) take the str string parameter, which will contain single digit numbers,
letters, and question marks, and check if there are exactly 3 question marks
between every pair of two numbers that add up to 10. If so, then your program should return the string true, otherwise it should return the string false. If there aren't any two numbers that add up to 10 in the string, then your program should return false as well.

For example: if str is "arrb6???4xxbl5???eee5" then your program should return true because there are exactly 3 question marks between 6 and 4, and 3 question marks between 5 and 5 at the end of the string.
Examples
Input: "aa6?9"
Output: false
Input: "acc?7??sss?3rr1??????5"
Output: true
 */
class QuestionMarks {

    public static boolean QuestionsMarks(String str) {
        // code goes here
        //"aa6???9"

        str = str.replaceAll("[a-zA-Z]","");
        System.out.println(str);
        Pattern pattern = Pattern.compile("\\d[?][?][?]\\d");

       // ([0-9])([?])([?])([?])([0-9])
        Matcher  matcher = pattern.matcher(str);

        if(matcher.find()){
            //int grpCnt = matcher.groupCount();
            //System.out.println("grpCnt="+grpCnt);
            int firstDigit =  matcher.start();
            int lastDigit =  matcher.end();
            System.out.println("firstDigit=" + str.substring(firstDigit,firstDigit + 1) + ",lastDigit="+ str.substring(lastDigit - 1,lastDigit ) );
            int sum= Integer.parseInt(str.substring(firstDigit,firstDigit + 1))  +  Integer.parseInt(str.substring(lastDigit - 1,lastDigit ));
            if(sum>=10){}
                return true;
        }

        Pattern falseP1 = Pattern.compile("([0-9])([?])([?])([0-9])");
        Pattern falseP2 = Pattern.compile("([0-9])([?])([0-9])");
        Matcher falseMatchP1 = falseP1.matcher(str);
        Matcher falseMatchP2 = falseP2.matcher(str);
        Matcher matchPattern = pattern.matcher(str);
        if (falseMatchP1.find() || falseMatchP2.find()){
            return false;
        }
        if (matchPattern.find()){
            return false;
        }

        return false;
    }

    public static void main (String[] args) {
        // keep this function call here
       // Scanner s = new Scanner(System.in);
        System.out.print(QuestionsMarks("acc?7??sss?3rr1??????5"));
    }

}