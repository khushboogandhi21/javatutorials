package com.work.year22.innerclasses;

class SuperClass{

    public void superMethod(){
        System.out.println("superMethod");
    }
}

public class AnonExtendInnerClassDemo {

    public void anonymousMethod(){

        SuperClass superObj =  new SuperClass(){

            int anonInt = 56;

            @Override
            public void superMethod(){
                System.out.println("superMethod overridden in extended anonymous class");
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
        AnonExtendInnerClassDemo anonObj = new AnonExtendInnerClassDemo();
        anonObj.anonymousMethod();

    }
}
