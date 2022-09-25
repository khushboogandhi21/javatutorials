package com.programs;

public class FirstReverse {
    public static String FirstReverse(String str) {
        // code goes here
        String[] strArr = str.split("");

        StringBuilder sbr = new StringBuilder();

        for(int count = strArr.length -1; count >=0; count--){
            sbr.append(strArr[count]);
        }

        return sbr.toString();
    }

    public static void main (String[] args) {
        // keep this function call here
        //Scanner s = new Scanner(System.in);
        System.out.print(FirstReverse("Stri_ng;-%   2b$#e reversed")); //coderbyte
    }
}
