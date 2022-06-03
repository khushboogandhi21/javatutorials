package com.work.year22.concurrency;

import java.util.concurrent.Semaphore;

/*
If the semaphore’s count is greater than zero, then the thread acquires a permit, which causes the semaphore’s count to be decremented.
 */
public class SemaphoreDemo {

    public static void main(String[] args){

        Semaphore semaphore = new Semaphore(1);
        Task task = new Task();

        Thread t1 = new Thread (()->{
            try {
                semaphore.acquire();
                task.display(1);
               // Thread.sleep(2000);
                semaphore.release();
            } catch (InterruptedException ex) {
                System.out.println("Exception while take=" + ex);
            }
        });

        Thread t2 = new Thread (()->{
            try {
                System.out.println("thread 2 is waiting for a permit.");

                // acquiring the lock
                semaphore.acquire();

                System.out.println( "thread 2 gets a permit.");
                task.display(2);
                Thread.sleep(2000);
                semaphore.release();
            } catch (InterruptedException ex) {
                System.out.println("Exception while take=" + ex);
            }
        });

        t1.start();
        t2.start();
    }
}

class Task{

    public void display(int threadNumber){
        System.out.println("Executing threadNumber: " + threadNumber);
    }
}


