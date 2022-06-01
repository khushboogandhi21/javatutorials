package com.work.year22.innerclasses;


//Local inner class cannot access non-final local variable till JDK 1.7.
// Since JDK 1.8, it is possible to access the non-final local variable in method local inner class.
 class OuterMethodClass {

    public void OuterMethod(){
        int outerLocal = 56;

        class MInnerClass{
            public void show(){ //can access no final variable of outer class method but cannot reassign any value
                //outerLocal = 75;  //NOT COMPILING
                System.out.println("SHOW: outerLocal Value = " + outerLocal);

            }
        }
        MInnerClass mInnerClass = new MInnerClass(); //Accessing Inner class as variable in outer method
        mInnerClass.show();
    }
}

public class MethodInnerClassDemo {

     public static void main(String[] args){
         OuterMethodClass outerMethodClass = new OuterMethodClass();
         outerMethodClass.OuterMethod();

    }
}
