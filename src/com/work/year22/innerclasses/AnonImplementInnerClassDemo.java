package com.work.year22.innerclasses;

interface SuperInterface{

    public void superMethod();
}

public class AnonImplementInnerClassDemo {

    public void anonymousMethod(){

        SuperInterface superObj =  new SuperInterface(){

            int anonInt = 56;

            @Override
            public void superMethod(){
                System.out.println("superMethod overridden in implemented anonymous class");
            }

            public void anonMethod(){  //CAN'T INVOKE
                System.out.println("anonMethod");
            }
        };

        superObj.superMethod();
        //superObj.anonInt;  //NOT COMPILE CANNOT RESOLVE SYMBOL
        //superObj.anonMethod //NOT COMPILE SINCE REFERENCE TYPE IS SUPER
    }

    public static void main(String[] args ){
        AnonImplementInnerClassDemo anonObj = new AnonImplementInnerClassDemo();
        anonObj.anonymousMethod();

    }
}
