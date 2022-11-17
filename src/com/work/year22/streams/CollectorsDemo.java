package com.work.year22.streams;

import com.work.year22.Student;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {

    public static void main(String[] args){

//            Teacher t1 = new Student();
//            t1.show();  //compilation error since it refers to method of t1 and its private


//        List collectionData = new ArrayList();
//        collectionData.add(1);
//        collectionData.add("String");
//        collectionData.add(Boolean.TRUE);
//        collectionData.remove("true");
//        System.out.println("collectionData = " + collectionData);


        //character count in a string
        String str1 = "JACKANDJILL";

        //str.length will print total no of characters
        Map<String,Long> resultMap1 = Arrays.stream(str1.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("resultMap1 = " + resultMap1);


        //Actual code starts here
        List<String> arrList = new ArrayList<>();
        arrList.add("Jack");
        arrList.add("Jill");
        arrList.add("John");
        arrList.add("Jane");
        arrList.add("Jack");

        Long count = arrList.stream().collect(Collectors.counting());
        System.out.println("count= " + count); //prints stream size

        //count the no of occurrences in a string
        String str = "This is Jane's home and that is Jill's home";
        String[] strArray = str.split(" "); //space is important else it will split on each character
        List<String> strList = Arrays.asList(strArray); //OR You can initialize  List = Arrays.asList("This","is");
        System.out.println("strList= " + strList);

        //OR Arrays.stream(strArray) ---better option
        Map<String,Long> resultLongMap = strList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())); //takes a function argument, Classifier to map in collection
        System.out.println("resultLongMap= " + resultLongMap);

        //count the no of CHARACTER occurrences in a string
        // str.split(""); remove space

        List<String> resultList = strList.stream().collect(Collectors.toList());  // Similarly toSet(), toMap(), toCollection ,toUnmodifiableList
        //try to modify the UnModifiable  List, we'll get an UnsupportedOperationException
            //OR
        resultList = strList.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("resultList= " + resultList);

       /* //Find duplicates in  a string --INCORRECT SOLUTION
        Set<String> resultSet = strList.stream().collect(Collectors.toSet());   // This will collect one occurrence  of any word including duplicates
        System.out.println("resultSet= " + resultSet); */

        //Note that keys are unique and if in any case the keys are duplicated then an IllegalStateException is thrown when the collection operation is performed.
        //Map<String,Integer> resultIntMap = strList.stream().collect(Collectors.toMap(Function.identity(),String::length));  //throws IllegalStateException


        //to avoid IllegalStateException [refer baeldung link]
        //The third argument here is a BinaryOperator, where we can specify how we want collisions to be handled.
        // In this case, we'll just pick any of these two colliding values because we know that the same strings will always have the same lengths too.
        Map<String,Integer>  resultIntMap = strList.stream().collect( Collectors.toMap(Function.identity(),String::length,(x,y)->x) );
        System.out.println("resultIntMap= " + resultIntMap);


        //CollectingAndThen is a special collector that allows us to perform another action on a result straight after collecting ends.
        //Here x is collection not element
        resultList = strList.stream().collect(Collectors.collectingAndThen(Collectors.toList(),x->{Collections.reverse(x); return x.stream();})).collect(Collectors.toList());
        System.out.println("resultList= " + resultList); //o/p->[home, Jill's, is, that, and, home, Jane's, is, This]

        String result = strList.stream().collect(Collectors.joining());  //joins the elements in stream
        System.out.println("result= " + result); //o/p->ThisisJane'shomeandthatisJill'shome

        //Collectors.summarizingDouble/Long/Int()
        //The static method, Collectors.summarizingDouble() returns a Collector which applies a mapping function to each input element of type T
        // to convert it to primitive double, and returns summary statistics for the resulting values.
        DoubleSummaryStatistics doubleSummaryStatistics = strList.stream().collect(Collectors.summarizingDouble(x->x.length()));   //or String::length
        System.out.println("doubleSummaryStatistics= " + doubleSummaryStatistics);

        // Collectors.averagingDouble/Long/Int()
        //Collectors.summingDouble/Long/Int()
        strList.stream().collect(Collectors.averagingDouble(String::length));

        Optional<String> strOptResult = strList.stream().collect(Collectors.maxBy(Comparator.comparing(String::length)));  //It returns an optional  //Comparator.naturalOrder() or Integer::compareTo
        //Comparator.comparing requires function as input that returns a comparator
        System.out.println("strOptResult= " + strOptResult);  //returns the first word that has max length

        //Collectors.teeing()Collectors.teeing() in Post java 12
        //combine two results
        //NOT WORKING
//        strList.stream().collect(Collectors.teeing(Collectors.maxBy(Comparator.naturalOrder()),Collectors.minBy(Comparator.naturalOrder()),
//                (min,max)->{
//            List<String> tempList = new ArrayList<>();
////            tempList.add(min.get());
////            tempList.add(max.get());
//            return tempList;
//        }));

        //PartitioningBy is a specialized case of groupingBy that accepts a Predicate instance, and then collects Stream
        // elements into a Map instance that stores Boolean values as keys and collections as values. Under the “true” key,
        // we can find a collection of elements matching the given Predicate, and under the “false” key, we can find a
        // collection of elements not matching the given Predicate.
        Map<Boolean, List<String>> resultMap  = strList.stream().collect(Collectors.partitioningBy(x->x.length() > 4));  //returns map with partitions true and false of predicate condition
        System.out.println("resultMap= " + resultMap);


        //The key thing to remember is that the function used for transformation in the map() returns a single value.
        // If map() uses a function, which, instead of returning a single value returns a Stream of values
        // then you have a Stream of Stream of values, and flatmap() is used to flat that into a Stream of values.

        List<Integer> intList =  Stream.of(2,5,1,23,11).map(x->x * x).collect(Collectors.toList());
        System.out.println("intList= " + intList );


        List<List<Integer>> intDoubleList =  Arrays.asList(Arrays.asList(2,5,1), Arrays.asList(23,11));
        System.out.println("intDoubleList= " + intDoubleList );
        intDoubleList = intDoubleList.stream().map(Function.identity()).collect(Collectors.toList());  //Here x is list not Integer so x*x won't work
        System.out.println("intDoubleList= " + intDoubleList );

        //The flatMap() method first flattens the input Stream of Streams to a Stream of Strings
        //Thereafter, it works similarly to the map() method.
        intList = intDoubleList.stream().flatMap(x->x.stream()).collect(Collectors.toList());
        System.out.println("intList= " + intList );


        //Optional map vs flatmap
        // flatmap does not wrap with additional Optional
        Student stud = new Student();
        stud.setStrOpt(Optional.of("Student"));
        Optional<Student> studOpt = Optional.of(stud);
        System.out.println("studOpt.map = " + studOpt.map(x->x.getStrOpt()) );
        System.out.println("studOpt.flatMap = " + studOpt.flatMap(x->x.getStrOpt()) );



    }



}
