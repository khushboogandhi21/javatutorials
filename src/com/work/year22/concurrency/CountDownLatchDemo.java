package com.work.year22.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args){

        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                FibonacciClass fibonacciClass = new FibonacciClass();
                fibonacciClass.printFibonacci(20);
                countDownLatch.countDown();

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                PrimeNumbers primeNumbers = new PrimeNumbers();
                primeNumbers.printPrimeNumbers(20);
                countDownLatch.countDown();
            }
        });


        try{
            t1.start();
            Thread.sleep(1000);
            t2.start();
            countDownLatch.await();
            System.out.print( "\nAll tasks completed");
        }catch(InterruptedException iex){
            System.out.println("Exception caught: " +  iex);
        }


    }
}

/*
*Prime number is a number that is greater than 1 and divided by 1 or itself only.
*For example 2, 3, 5, 7, 11, 13, 17
* 0 and 1 are not prime numbers. 3
 *The 2 is the only even prime number because all the other even numbers can be divided by 2.
 */
class PrimeNumbers{
    public void printPrimeNumbers(int range){
        System.out.print("\nPrime Nos: " + 2);
        for(int i=1;i<range;i++){
            for(int j=2;j<i;j++){
                if(i%j == 0){ //Not a prime number
                    break;
                }else if((j+1) == i){
                    System.out.print("\t" + i);
                }
            }
        }
    }
}

class FibonacciClass {

    /*
    In fibonacci series, next number is the sum of previous two numbers
     for example 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 etc.
     The first two numbers of fibonacci series are 0 and 1.
     */
    public void printFibonacci(int range){

        int first = 0;
        int second = 1;
        System.out.print("\nFibonacci Nos: " + first);
        System.out.print("\t" + second);
        for(int i=1;second<range;i++){
            int temp = second;
            second = first + second;
            System.out.print("\t" +second);
            first = temp;

        }
    }

}
