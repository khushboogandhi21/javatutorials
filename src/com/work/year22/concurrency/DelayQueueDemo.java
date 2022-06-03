package com.work.year22.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/*
*DelayQueue implements BlockingQueue
* DelayQueue is a specialized Priority Queue that orders elements based on their delay time
* It means that only those elements can be taken from the queue whose time has expired.
 * So implements compareTo method
 * DelayQueue accepts only those elements that belong to a class of type Delayed or those implement java.util.concurrent.Delayed interface
*DelayQueue implements the getDelay(TimeUnit.NANOSECONDS) method to return the remaining delay time.
 */
public class DelayQueueDemo {

    public static void main(String[] args){
        BlockingQueue<DelayObject> delayQueue = new DelayQueue<>();
        delayQueue.add(new DelayObject(1));
        delayQueue.add(new DelayObject(2200));
        delayQueue.add(new DelayObject(30003));
        delayQueue.add(new DelayObject(44));

        while(true) {
            try {
                System.out.println("DelayQueue: " + delayQueue.take());
            } catch (InterruptedException ex) {
                System.out.println("Exception while take=" + ex);
            }
        }
    }

}

class DelayObject implements Delayed {

    private long time;

    DelayObject(long time){
        this.time = time;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long timeDiff =  this.time - System.currentTimeMillis();
        return timeDiff;
    }

    @Override
    public int compareTo(Delayed obj) {
        if(this.time < ((DelayObject)obj).time){
            return -1;
        }else if (this.time > ((DelayObject)obj).time){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString(){

        return "time = " + time;
    }
}
