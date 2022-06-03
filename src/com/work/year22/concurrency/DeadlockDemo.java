package com.work.year22.concurrency;

public class DeadlockDemo {

    public static void main(String[] args){
        SharedObjectOne s1 =  new SharedObjectOne();
        SharedObjectTwo s2 = new SharedObjectTwo();

        Thread t1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                s1.displayOne(s2);
                s2.displayTwo(s1);
            }
        });

        Thread t2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                s2.displayTwo(s1);
                s1.displayOne(s2);
            }
        });

        t1.start();
        t2.start();

    }

}

class SharedObjectOne{

    public synchronized void displayOne(SharedObjectTwo s2){
        System.out.println("Display One");
        s2.displayTwo(this);
    }
}

class SharedObjectTwo{

    public synchronized void displayTwo(SharedObjectOne s1){
        System.out.println("Display Two");
        s1.displayOne(this);
    }
}