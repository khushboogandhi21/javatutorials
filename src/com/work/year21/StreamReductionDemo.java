package com.work.year21;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamReductionDemo {

    public static void main(String[] args){

        //Custom reduction/terminating operations
        //reduce a stream to some value/non stream
        OptionalInt sumValueOpt = IntStream.rangeClosed(1,3).reduce((a, b)->a+b); // No Initial Val
        System.out.println("Reduce:sum = " + sumValueOpt.getAsInt());

        int sumValue = IntStream.rangeClosed(1,3).reduce(2,(a,b)->a+b); //Initial val
        System.out.println("Reduce:sum = " + sumValue);

        //.reduce(Initial value,Transformation function, Aggregating Function)
        int reducedParams = Stream.of(1, 2, 3)
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    System.out.println("a="+a+",b="+b);
                    return a + b;
                });
        System.out.println("Reduce:reducedParams = " + reducedParams);  //returns 16

        //Above Aggregating Function is not invoked.To make it work, a stream should be parallel:
        //identity value gets added to each value in stream (10 + 1 = 11; 10 + 2 = 12; 10 + 3 = 13;) so Transformation fn runs thrice
        //Aggregating Function runs twice (12+13=25;25+11=36)
        reducedParams = Arrays.asList(1, 2, 3).parallelStream()
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    System.out.println("a="+a+",b="+b);
                    return a + b;
                });

        System.out.println("Reduce:reducedParams = " + reducedParams);  //returns 36


        //collect() -another terminal operation,
        //It accepts an argument of the type Collector, which specifies the mechanism of reduction.

        List<Product> productList = Arrays.asList(new Product("Apple",12,100),
                        new Product("WaterMelon",14,115),
                new Product("Lemon",15,20),
                new Product("Banana",11,20));

        //Converting a stream to the Collection (Collection, List or Set):
        List<String> resultList  = productList.stream().map(Product::getName).collect(Collectors.toList());


        //joining - It can have from one to three parameters (delimiter, prefix, suffix).
        String res = productList.stream().map(Product::getName).collect(Collectors.joining(",","List Contents:",""));
        System.out.println("joining:result = " + res);

        //The methods averagingXX(), summingXX() and summarizingXX() can work with primitives (int, long, double)
        // and with their wrapper classes (Integer, Long, Double).
        //the developer doesn't need to use an additional map() operation before the collect() method.
        Long sumCount = productList.stream().collect(Collectors.summingLong(Product::getPrice));


        //Function.identity() - Utility function that returns input provided as output
        //Collectors counting() method is used to count the number of
        // elements passed in the stream as the parameter.

        //groupingBy takes two mandatory params return type is Map
        //Function- It is the property which is to be applied to the input elements.
        //Classifier- It is used to map input elements into the destination map.
        // 3 apple, 2 banana, others 1
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String,Long> mapResult = items.stream().
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("groupingBy:mapResult = " + mapResult);

        Map<Long,List<Product>> mapProduct = productList.stream().collect(Collectors.groupingBy(Product :: getPrice));
        System.out.println("groupingBy:mapProduct = " + mapProduct);

        //Partition a stream in two parts based on result of predicate
        Map<Boolean,List<Product>> mapPartition = productList.stream().collect(Collectors.partitioningBy(item->item.getPrice() >100));
        System.out.println("partitioningBy:mapPartition = " + mapPartition);

        //another variation
        Map<Boolean,Long> mapPartition2 = productList.stream().collect(Collectors.partitioningBy(item->item.getPrice()>100,Collectors.counting()));
        System.out.println("partitioningBy:mapPartition2 = " + mapPartition2);

        //sorted() - Sort a stream
        items.stream().sorted().forEachOrdered(System.out::println);

        //Sort using a comparator Comparator.comparing introduced in Java 8
        //The Comparator.comparing static function accepts a sort key Function and
        // returns a Comparator for the type which contains the sort key
        productList.stream().sorted(Comparator.comparing(p -> ((Integer) p.id))).forEachOrdered(x->System.out.print(x.getName()+"\t"));
        //OR
        // productList.stream().sorted((p1,p2)->{((Integer)p1.id).compareTo((Integer)p2.id))});



    }

}
