package com.work.year22.innerclasses;


/** static modifier not allowed for a class
 * Static nested classes are not technically inner classes. They are like a static member of outer class.
 * Only inner classes can be declared static.
 * A static class has no pointer to its outer class and can therefore only refer to
 * static fields and methods of the outer class. A static class may however itself contain non-static methods.
 */
public class StaticInnerClassDemo {

    public static void main(String[] args ){

        OuterStatClass.InnerClass.show();
        OuterStatClass outerStatClass = new OuterStatClass();
        //NOT COMPILING outerStatClass.new() InnerClass
        //So can't access nonstatic method from static inner class
        //OuterStatClass.InnerClass.nonStatShow(); NOT COMPILING

    }
}

class OuterStatClass{
    private static int y= 10;

    static class InnerClass{
         static void show(){
            System.out.println("SHOW" + y);
        }

        public void nonStatShow(){  //CAN"T ACCESS THIS METHOD FROM OUTER
            System.out.println("SHOW" + y);
        }
    }
}
