package com.programs;

import java.util.Arrays;

/*
Coderbytes Palo IT
 */
public class sortAndMaxInt {

    public static void main(String[] args ){

        //-2 -1 1 2 4 7
        int[] arr = {1,4,2,-2,7,-1};

        Arrays.sort(arr); //Collections.reverseOrder() don't work with primitive types

        int sum = 0;
        for(int i = arr.length -1 ; i>= arr.length - 4 && i>=0 ;i--){  //i>=0 for arr size less than 4
            System.out.print(arr[i] + "\t");
            sum+=arr[i];
        }

        String str = "67gj98okf";
        StringBuilder sbr = new StringBuilder();
        sbr.append(String.valueOf(sum)).append(str);

       //String[] strArr = sbr.toString().split("");  //Don't use string arr there is boilerplate code while converting it back to String
        char[] charArr =  sbr.toString().toCharArray();
        for(int j = 3; j< charArr.length;j=j+3){
            charArr[j] = 'X';
        }

        System.out.println("Final String is : " + new String(charArr));  //strArr.toString() returns object
        //Arrays.toString(strArr) prints comma separated values



    }

}
