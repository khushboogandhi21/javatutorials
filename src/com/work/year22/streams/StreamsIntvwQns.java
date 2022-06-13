package com.work.year22.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsIntvwQns {

    public static void main(String[] args){


        Stream<Integer> intStream = Stream.iterate(0,x->x+1).limit(10);

        // find out all the even numbers
        intStream.filter(x->x%2==0).forEach(System.out::print);

        intStream = Stream.iterate(0,x->x+1).limit(10);
        //find out all the numbers starting with 1
        intStream.filter(x->
        {   String str = x+ "";
            if(str.indexOf("1") == 0)
                //OR
            //if(str.startsWith("1"))
                return true;
            else
                return false;
        }).forEach(System.out::println);

        //find duplicate elements in a given integers list
        Stream<String> strStream =Stream.of("Hello","World","Java","World");
        Set<String> strSet = new HashSet<>();
        List<String> resultList = strStream.filter(x->!strSet.add(x)).toList();
        System.out.println("resultList=" + resultList);

        ////Reinitialize as getting java.lang.IllegalStateException: stream has already been operated upon or closed
        strStream =Stream.of("Hello","World","Java","World");
        Map<String,Long> resultMap = strStream.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("resultMap="+resultMap);

        //find the first element of the list
        strStream =Stream.of("Hello","World","Java","World");
        strStream.findFirst().ifPresent(System.out::println);  //findFirst() returns Optional<T>

        strStream =Stream.of("Hello","World","Java","World");
        System.out.println("find the total number of elements =" + strStream.count());

        //find the maximum value element present
        intStream = Stream.iterate(0,x->x+1).limit(10);
        //Optional<Integer> intResult = intStream.max((x, y)->{return x-y;});
        //OR
        Optional<Integer>  intResult = intStream.max(Integer::compare);
        System.out.println("maximum value element present =" + intResult.get());


        String str = "HelloWorld";
//        str.chars().mapToObj(x->Character.toLowerCase(Character.valueOf((x))).
//                collect(Collectors.groupingBy(Collectors.groupingBy(Function.identity(),HashMap::new,Collectors.counting())));

        //find the first non-repeated character  //I DIDN'T PRACTICE THIS
        Character result = str.chars() // Stream of String
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();

        System.out.println(result);



        //asc order
        intStream = Stream.iterate(0,x->x+1).limit(10);
        intStream.sorted().forEach(System.out::print);

        System.out.println("");
        //desc order
        intStream = Stream.iterate(0,x->x+1).limit(10);
        intStream.sorted(Comparator.reverseOrder()).forEach(System.out::print);
        //OR Collections.reverseOrder()











    }
}
