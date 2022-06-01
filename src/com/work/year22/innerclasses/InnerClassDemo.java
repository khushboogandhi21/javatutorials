package com.work.year22.innerclasses;

public class InnerClassDemo {

    public static void main(String[] args ){
        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.show();

    }
}

class OuterClass{
    private int i= 10;

    class InnerClass{
        void show(){
            System.out.println("SHOW" + i);
        }
    }
}
