package com.work.year22.concurrency;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CompFutureWithoutCallback {

    public static void main(String[] args){

        CompletableFuture  compFut = CompletableFuture.runAsync(new SampleTask());

        //System.out.println("Printing result = " + compFut.complete("Manually completing"));
        //returns true if completed false f task already was completed for example by calling get

        try{
            System.out.println("Printing result = " + compFut.get()); //blocking call
            //returns Manually completing
            //returns null which means success if ompFut.complete commented above

        }catch(InterruptedException  |  java.util.concurrent.ExecutionException ex){
            System.out.println("Exception while get=" +ex);
        }


        compFut = CompletableFuture.supplyAsync(()->{
            return new Random().nextInt(25);
        });  //takes Supplier as arg

        ExecutorService es = Executors.newFixedThreadPool(5);
        compFut = CompletableFuture.supplyAsync(()->{
            return new Random().nextInt(25);
        },es);  //takes Supplier and ExecutorService as arg

        try{
            System.out.println("Printing supplier result = " + compFut.get()); //blocking call
            //returns Manually completing
            //returns null which means success if ompFut.complete commented above

        }catch(InterruptedException  |  java.util.concurrent.ExecutionException ex){
            System.out.println("Exception while get=" +ex);
        }
        finally {
            es.shutdown(); //else system will not exit
        }




    }
}

class SampleTask implements Runnable{


    @Override
    public void run() {
        System.out.println("Running SampleTask");
    }
}
