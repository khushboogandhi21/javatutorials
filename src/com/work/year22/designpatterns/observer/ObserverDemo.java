package com.work.year22.designpatterns.observer;

public class ObserverDemo {

    public static void main(String[] args){
        Subject subject = new Subject();

        new NewsObserver(subject);
        new TVObserver(subject);

        subject.setState("Weather is 25 degree celsius");
        subject.notifyAllObservers();

        subject.setState("Weather is 32 degree celsius");
        subject.notifyAllObservers();


    }
}
