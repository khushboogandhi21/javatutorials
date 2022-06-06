package com.work.year22.designpatterns.observer;

public class NewsObserver extends Observer{
    //has reference to subject via super class
    NewsObserver(Subject subject){
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("NewsObserver: " + subject.getState());
    }
}
