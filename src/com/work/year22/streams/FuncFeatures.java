package com.work.year22.streams;

interface interface_default {
    void display();
}

class derived_class{

    public void classMethod(){
        System.out.println("Derived class Method");
    }
}

public class FuncFeatures {
    public static void main(String[] args){

        derived_class obj1 = new derived_class();
        interface_default  ref = obj1::classMethod;
        //we have a reference to the (Functional) interface that references [Not Implements So no polymorphism on LHS]
        // a class method “classMethod” through obj1 (class object).
        ref.display(); // so here the implemented method body is called.

    }
}
