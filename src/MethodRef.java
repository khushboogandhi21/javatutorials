/**Earlier,If we only use a method of an object in another method,
 * we still have to pass the full object as an argument.
 * Wouldn't it be more practical to just pass the method as an argument?
 * ANSWER:
 * Method reference is used to refer method of functional interface.
 * It is compact and easy form of lambda expression.
 * Each time when you are using lambda expression to just referring a method,
 * you can replace your lambda expression with method reference.
 *
 *
 *
 * Lambda Expressions were added in Java 8.
 * A lambda expression is a short block of code which takes in parameters and returns a value.
 * Lambda expressions are similar to methods,
 * but they do not need a name and they can be implemented right in the body of a method.
 *
 * SO Lambda Expressions is short hand for writing methods traditionally
 * AND method reference is short hand for Lambda Expressions so that method ref
 * can be passed as an argument to other methods
 * Object::methodname
 *
 * First of all, a method reference can't be used for any method. They can only be used to replace a single-method lambda expression.
 *
 * So to use a method reference, you first need a lambda expression with one method.
 * And to use a lambda expression,
 * you first need a functional interface, an interface with just one abstract method.
 * In other words:
 *
 * Instead of using
 * AN ANONYMOUS CLASS
 * you can use
 * A LAMBDA EXPRESSION
 * And if this just calls one method, you can use
 * A METHOD REFERENCE
 *
 * There are following types of method references in java:
 *  * Reference to a static method. -> containingObject::staticMethodName
 *  * Reference to an instance method. -> containingObject::instanceMethodName
 *  * Reference to a constructor. -> ClassName::new
 */

//git commit -m "Restructure"

import java.util.Optional;
interface interface_default {
    void display();
}

// https://www.infoworld.com/article/3453296/get-started-with-method-references-in-java.html
// https://www.codementor.io/@eh3rrera/using-java-8-method-reference-du10866vx
class derived_class{

    public void classMethod(){
        System.out.println("Derived class Method");
    }
}

public class MethodRef {
    public static void main(String[] args){

        derived_class obj1 = new derived_class();
        interface_default obj2 = derived_class::new;   // ClassName::new  LHS should be a functional reference
        interface_default  ref = obj1::classMethod;  // containingObject::instanceMethodName
        // if classMethod was static then containingObject::staticMethodName
        //implementation of classMethod is now pointing to display()
        //we have a reference to the (Functional) interface that references [Not Implements So no polymorphism on LHS]
        // a class method “classMethod” through obj1 (class object).
        ref.display(); // so here the implemented method body is called.




    }
}
