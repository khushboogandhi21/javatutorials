package com.work.year22.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
    class RunnableTask implements Runnable{

        @Override
        public void run() {
            System.out.println("Runnable Task");
        }
    }
    public static void main(String[] args){
        ExecutorService es = Executors.newFixedThreadPool(5);
        String result = null;
        Future future = es.submit(new FutureDemo().new RunnableTask()) ; //takes runnable or callable
        try{
            System.out.println("Printing result = " + future.get());  //returns null in this case if success
            // es.invokeAll(), invokeAny() takes a collection of callables
        }catch(InterruptedException  |  java.util.concurrent.ExecutionException ex){
            System.out.println("Exception while get=" +ex);
        }finally {
            es.shutdown();  //shutdownNow immediate shutdown
        }

    }
}
