package com.work.year22;

public class SingletonDemo {
    private static volatile SingletonDemo singObj;  // volatile  ensures that multiple threads offer the obj variable correctly
    //Early Instantiation:
    //private static volatile SingletonDemo singObj = new SingletonDemo();
    private SingletonDemo(){

    }

    public static  SingletonDemo getSingObj() {
        if(singObj == null) {  //// Double Checked Locking - Acquire lock only if its null
            synchronized (SingletonDemo.class) {
                if (singObj == null) {
                    singObj = new SingletonDemo();  //lazy Instantiation:
                }
            }
        }
        return singObj;
    }
}
