package com.work.year22;

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


        Map<String,Long> resultLongMap = strList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())); //takes a function argument, Classifier to map in collection
        System.out.println("resultLongMap= " + resultLongMap);

        //count the no of CHARACTER occurrences in a string
        // str.split(""); remove space

        List<String> resultList = strList.stream().collect(Collectors.toList());  // Similarly toSet(), toMap(), toCollection ,toUnmodifiableList
        //try to modify the UnModifiable  List, we'll get an UnsupportedOperationException
            //OR
        resultList = strList.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("resultList= " + resultList);

        //Find duplicates in  a string
        Set<String> resultSet = strList.stream().collect(Collectors.toSet());
        System.out.println("resultSet= " + resultSet);

        //Note that keys are unique and if in any case the keys are duplicated then an IllegalStateException is thrown when the collection operation is performed.
        //Map<String,Integer> resultIntMap = strList.stream().collect(Collectors.toMap(Function.identity(),String::length));  //throws IllegalStateException


        //to avoid IllegalStateException [refer baeldung link]
        //The third argument here is a BinaryOperator, where we can specify how we want collisions to be handled.
        // In this case, we'll just pick any of these two colliding values because we know that the same strings will always have the same lengths too.
        Map<String,Integer>  resultIntMap = strList.stream().collect( Collectors.toMap(Function.identity(),String::length,(x,y)->x) );
        System.out.println("resultIntMap= " + resultIntMap);


        //CollectingAndThen is a special collector that allows us to perform another action on a result straight after collecting ends.
        resultList = strList.stream().collect(Collectors.collectingAndThen(Collectors.toList(),x->{Collections.max(x); return x.stream();})).collect(Collectors.toList());

        String result = strList.stream().collect(Collectors.joining());  //joins the elements in stream
        System.out.println("result= " + result); //o/p->ThisisJane'shomeandthatisJill'shome



    }



}
