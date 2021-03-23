import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class FunctionClass {
    public static void main (String[] args){
        /**
         * Predicate,Function,Supplier,Consumer are the
         * main types of Functional Interface
         * Others are BiFunction,BiConsumer,BiPredicate,UnaryOperator,BinaryOperator
         */
        FunctionClass functionClass =  new FunctionClass();
        //Function Reference
        Function funcRef = functionClass.getFuncInterfaceImpl(); //return implementation of Function Interface

        Integer returnVal = (Integer) funcRef.apply("kamal");
        System.out.println("returnVal = " + returnVal);

        //OR
        Function<String,Integer> funcRef111 = (temp)->{System.out.println("temp = " + temp); return 23;};
        System.out.println("returnVal = " + funcRef111.apply("Khushboo"));

        BiFunction<Integer,Integer,Integer> biFunction = (a,b) -> {return a+b;};
        //If u don't specify types on LHS then by default it is considered as Object type.
        // BiFunction biFunction1 = (a,b) -> {return a;};

        System.out.println("BiFunction result = " + biFunction.apply(255,3));

        Predicate<String> predicate = (s)->s.startsWith("G");
        System.out.println("Predicate result = " + predicate.test("Kamal"));

        Supplier<Double> supplier = () ->{return Math.random() * 100;};
        //supplier doesn't take any input only returns
        System.out.println("Supplier result = " + supplier.get());

        List<Integer> consumerList =  new ArrayList<>();
        Consumer<Integer> consumer = (input) -> {consumerList.add(input);};
        consumer.accept(55);
        consumer.accept(110);
        System.out.println("consumerList = " + consumerList.toString());


    }


    private Function<String,Integer> getFuncInterfaceImpl(){
        return (String temp)->{System.out.println("temp = " + temp); return 1;};
        // OR
        // return ( temp)->{System.out.println("temp = " + temp); return 1;};
    }
}
