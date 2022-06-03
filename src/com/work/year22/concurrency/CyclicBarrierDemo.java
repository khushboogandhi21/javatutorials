package com.work.year22.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args){

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,() ->{
            System.out.println( "\nAll tasks completed");
            SampleTask sampleTask = new SampleTask();
            sampleTask.run();
        } ); //takes runnable

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                FibonacciClass fibonacciClass = new FibonacciClass();
                fibonacciClass.printFibonacci(20);
                try{
                    cyclicBarrier.await();
                }catch(InterruptedException  |BrokenBarrierException ex){
                    System.out.println("Exception caught: " +  ex);
                }


            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                PrimeNumbers primeNumbers = new PrimeNumbers();
                primeNumbers.printPrimeNumbers(20);
                try{
                    cyclicBarrier.await();
                }catch(InterruptedException  |BrokenBarrierException ex){
                    System.out.println("Exception caught: " +  ex);
                }
            }
        });


        try{
            t1.start();
            Thread.sleep(1000);
            t2.start();

            //System.out.print( "\nAll tasks completed");
        }catch(InterruptedException iex){
            System.out.println("Exception caught: " +  iex);
        }


    }
}
