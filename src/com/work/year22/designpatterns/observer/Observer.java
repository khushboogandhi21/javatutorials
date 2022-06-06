package com.work.year22.designpatterns.observer;

/*
Subscriber
 */
public abstract class Observer {  //cant be an interface as we then cannot assign subject later [Interface has final variables]
     protected Subject subject = null;

     public abstract void update();

}
