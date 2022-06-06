package com.work.year22.designpatterns.observer;

public class TVObserver extends Observer{
    //has reference to subject via super class
    TVObserver(Subject subject){
        this.subject = subject;
        this.subject.addObserver(this);  //if u remove this line it will not get published message
    }

    @Override
    public void update() {
        System.out.println("TVObserver: " + subject.getState());
    }
}
