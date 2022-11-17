package com.programs;

import java.util.Scanner;

/**
 * Say Fizz if the number is divisible by 3.
 * Say Buzz if the number is divisible by 5.
 * Say FizzBuzz if the number is divisible by both 3 and 5.
 * Return the number itself, if the number is not divisible by 3 and 5.
 */
public class FizzBuzz {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");

        int n = sc.nextInt();
        System.out.println("The Fizz, Buzz, and FizzBuzz numbers are: ");
        //close the Scanner
        sc.close();
        calculateFizzBuzz(n);

    }

    private static void calculateFizzBuzz(int n) {
        if(n < 0 || n > (2 * Math.pow(10,5)))  //boundary conditions  0< n< 2 x 10^5
            return;

        for (int i = 1; i <= n; i++)
        {
            if (i%3==0 && i%5==0)  //Order is important for performance optimization
            {
                System.out.print("FizzBuzz");
            }
            else if (i%3==0)
            {
                System.out.print("Fizz");
            }
            else if (i%5==0)
            {
                System.out.print("Buzz");
            }
            else
            {
                System.out.print(i);
            }

            System.out.print(","+" ");
        }

    }
}
