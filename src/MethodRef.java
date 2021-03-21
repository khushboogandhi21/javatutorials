/** Method reference is used to refer method of functional interface.
 * It is compact and easy form of lambda expression.
 * Each time when you are using lambda expression to just referring a method,
 * you can replace your lambda expression with method reference.
 *
 * There are following types of method references in java: *
 * Reference to a static method.
 * Reference to an instance method.
 * Reference to a constructor.
 */

//git commit -m "Restructure"

import java.util.Optional;
interface interface_default {
    void display();
}


class derived_class{

    public void classMethod(){
        System.out.println("Derived class Method");
    }
}

public class MethodRef {
    public static void main(String[] args){

        derived_class obj1 = new derived_class();
        interface_default  ref = obj1::classMethod; //implementation of classMethod is now pointing to display()
        //we have a reference to the (Functional) interface that references [Not Implements So no polymorphism on LHS]
        // a class method “classMethod” through obj1 (class object).
        ref.display(); // so here the implemented method body is called.


    }
}
