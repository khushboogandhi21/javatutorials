package com.programs;

public class ReverseInteger {

    public static void main (String[] args) {
        System.out.print(reverse_integer(983));  //389
    }

    private static int reverse_integer(int num) {
        int revNum = 0;
        while(num != 0){
            revNum= (revNum * 10) + (num % 10);
            num = num/10;
        }

        return revNum;
    }
}
