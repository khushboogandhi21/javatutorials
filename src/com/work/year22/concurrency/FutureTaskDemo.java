package com.work.year22.concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* FutureTask is a concrete class that
 *implements both Runnable and Future
*Can pass FutureTask to Thread as well as ExecutorService
*Constructors-
*FutureTask(Callable<V> callable)
 *       Creates a FutureTask that will, upon running, execute the given Callable.
 *FutureTask(Runnable runnable, V result)
 *      Creates a FutureTask that will, upon running, execute the given Runnable,
 *      and arrange that get will return the given result on successful completion.
*/

public class FutureTaskDemo {

    class SampleTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return new Random().nextInt(10);
        }
    }

    public static void main(String[] args){
        FutureTaskDemo.SampleTask sampleTask = new FutureTaskDemo().new SampleTask();
        //Thread T1 = new Thread(sampleTask); //NOT COMPILING //Thread only takes Runnable
        FutureTask futureTask = new FutureTask(sampleTask);

        Thread t1 =  new Thread(futureTask);
        t1.start();
        try {
            System.out.println(futureTask.get()); //blocks till result obtained
            //CAN ALSO CALL
            // futureTask.isDone()
            //futureTask.isCancelled()
        }catch(InterruptedException  |  java.util.concurrent.ExecutionException ex){
            System.out.println("Exception while get=" +ex);
        }
    }
}
