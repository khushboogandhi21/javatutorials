package com.work.year22.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/*
Publisher
 */
public class Subject {

    private String state; //data that need to be sent to subscribers
    List<Observer> observerList = new ArrayList<>();

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    public void notifyAllObservers(){
        for(Observer observer : this.observerList){
            observer.update();
        }
    }
}
