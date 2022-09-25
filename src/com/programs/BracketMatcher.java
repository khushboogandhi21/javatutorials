package com.programs;

import java.util.EmptyStackException;
import java.util.Stack;

/*
Bracket Matcher
Have the function BracketMatcher(str) take the str parameter being passed and return 1 if the brackets are correctly matched and each one is accounted for.
Otherwise return 0. For example: if str is "(hello (world))", then the output should be 1,
but if str is "((hello (world))" the the output should be 0 because the brackets do not correctly match up.
Only "(" and ")" will be used as brackets. If str contains no brackets return 1.
Examples
Input: "(coder)(byte))"
Output: 0
Input: "(c(oder)) b(yte)"
Output: 1
 */
public class BracketMatcher {
    public static boolean BracketMatcher(String str) {
        // code goes here
        if(str.indexOf("(") == -1 && str.indexOf(")") == -1)
            return true;

        Stack<String> stackMatcher = new Stack<>();

        int popCount = 0;
        for(String s : str.split("")){
            if("(".equals(s)){
                stackMatcher.push(s);
            }else if(")".equals(s)){
                if (stackMatcher.isEmpty()) return false;
                else{
                    stackMatcher.pop();
                    popCount++;
                }
            }
        }//for ends
/*
        if( popCount > 0 && stackMatcher.size() == 0){
            return "1"; //true
        }else {
            return "0";
        }*/
        return stackMatcher.isEmpty();
    }

    public static void main (String[] args) {
        // keep this function call here
        //Scanner s = new Scanner(System.in); //s.nextLine()
        System.out.print(BracketMatcher("three let(t)ers"));   //(coder)(byte))  //(c(oder)) b(yte)  //letter(s) gal(o)(r)((e)  //twice thri(c)(e)()()
    }

}
