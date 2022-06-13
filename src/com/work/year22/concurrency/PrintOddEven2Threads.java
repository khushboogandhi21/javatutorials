package com.work.year22.concurrency;

/*
Print even and odd numbers in increasing order using two threads
* In sequence
*Used anonymous inner class in approach
 */
public class PrintOddEven2Threads {

    public synchronized void  printOdd(int range){

        for(int i=0;i<=range;i++){
            if(i%2 != 0){
                System.out.println("Printing Odd Number : " + i);
                notify();
                try {
                    if(i<range)
                        wait();
                }catch (InterruptedException iex){
                    System.out.println("InterruptedException : " + iex);
                }
            }
        }
    }

    public synchronized void printEven(int range){
        for(int i=0;i<=range;i++){
            if(i%2 == 0){
                System.out.println("Printing Even Number : " + i);
                notify();
                try {
                    if(i<range)  //else system does not exit since none calls notify
                        wait();
                }catch (InterruptedException iex){
                    System.out.println("InterruptedException : " + iex);
                }
            }
        }
    }

    public static void main (String[] args){
        PrintOddEven2Threads printObj = new PrintOddEven2Threads();
        int range = 10;

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                printObj.printEven(range);
            }
        });
      //OR
      //  t1 = new Thread(printObj); //where PrintOddEven2Threads implements Runnable and have only one method for printing both[Single thread approach]

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                printObj.printOdd(range);
            }
        });

        t1.start();
        t2.start();

        //t1.interrupt();
        //t1.stop deprecated now
        //If this thread is blocked in an invocation of the wait(), wait(long), or wait(long, int) methods
        // of the Object class, or of the join(), join(long), join(long, int), sleep(long), or sleep(long, int),
        // methods of this class, then its interrupt status will be cleared and it will receive an InterruptedException.
    }


}
