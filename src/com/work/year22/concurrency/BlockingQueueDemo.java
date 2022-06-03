package com.work.year22.concurrency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
Java BlockingQueue implementations are thread-safe
*Java provides several BlockingQueue implementations such as
*ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue, SynchronousQueue etc.
*
*/
public class BlockingQueueDemo {
    public static void main(String[] args){
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);
        Thread t1 = new Thread(new Producer(blockingQueue));
        Thread t2 = new Thread(new Consumer(blockingQueue));
        t1.start();
        t2.start();

    }
}


class Producer implements Runnable{
    BlockingQueue<Integer> blockingQueue;

    Producer(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try{
            for(int i=0;i<10;i++){
                int random = new Random().nextInt(20);
                System.out.println("Value Produced:" + random);
                this.blockingQueue.put(random);
                Thread.sleep(1000);
            }

        }catch(InterruptedException   ex){
            System.out.println("Exception while put=" +ex);
        }
    }
}


class Consumer implements Runnable{
    BlockingQueue<Integer> blockingQueue;
    int count = 0;

    Consumer(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try{
            while (true){
                System.out.println("Value Consumed:" + this.blockingQueue.take());
                Thread.sleep(1000);
            }

        }catch(InterruptedException   ex){
            System.out.println("Exception while take=" +ex);
        }
    }
}
