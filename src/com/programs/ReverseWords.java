package com.programs;

import java.util.Stack;

public class ReverseWords {

    public static String reverse_words(String str) {
        // code goes here
        Stack<String>  strStack = new Stack<>();

        String[] strArr = str.split("");
        StringBuilder sbr = new StringBuilder();

        for(int count = 0; count <= strArr.length ;  count++){
            if (count < strArr.length && strArr[count].matches("[a-zA-Z0-9]+")) {
                strStack.push(strArr[count]);
            }else{
                if(!strStack.isEmpty()){
                    int size = strStack.size();
                    for(int tempCount = 0; tempCount <  size ;  tempCount++){
                        sbr.append(strStack.pop());
                    }
                }
                if (count < strArr.length)
                    sbr.append(strArr[count]);

            }
        }

        return sbr.toString();
    }

    public static void main (String[] args) {
        System.out.print(reverse_words("_;-%   $# "));  //irtS_gn;-%   b2$#e desrever
    }
}
