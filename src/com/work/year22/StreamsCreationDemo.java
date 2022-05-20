package com.work.year22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsCreationDemo {


    public static void main(String[]args){
        String str="Hello World";
        //convert String to char array
        char[] charArray = str.toCharArray();
        for(char i:charArray){
            System.out.println("Char is " + i );
        }


        //convert char array to list
        List<char[]> characterList = Arrays.asList(charArray);
        //iterate  a list using foreach
        for(char[] chrarr: characterList){
            System.out.println("Char arr is " + chrarr );  //returns [C@e9e54c2 so DOES NOT SATISFY REQUIREMENT
        }
        //convert String Array to List
        //Option 1
        List<String> strList = Arrays.asList("Hello","Java","World");
        for(String s: strList){
            System.out.println("String arr is " + s );
        }
        //Option 2
        String[] strArray = {"This","is","List"};
        List<String> arrList = Arrays.asList(strArray);
        for(String s: arrList){
            System.out.println("String Arraylist is " + s );
        }


        //WAY 1-->Convert arrays to stream
        Stream<String> streamObj = Arrays.stream(strArray);

        //forEach(Consumer T) introduced in stream
        streamObj.forEach(s -> System.out.println("String arr is " + s ));


        //WAY 2-->convert list to stream
        Stream<String> streamList = strList.stream();
        streamList.forEach(s->System.out.println("String arr is " + s ));

        String str1= "Count char occurences";
        //str1.chars() -->returns IntegerStream
        //returns Stream
        str1.chars().forEach(System.out::println );
        long eCharCount= str1.chars().filter(c -> c == 'e').count();
        System.out.println("eCharCount = " + eCharCount);

        //WAY 3-->
        streamList = Stream.of("Hello","streams","java");

        //WAY 4-->
        Stream<List<String>> arrListStream = Stream.ofNullable(strList);   //takes single object as input and produces a stream

        //WAY 5-->
        Stream<Double> strGen= Stream.generate(()->Math.random()); //takes supplier obj as input

        //WAY 6-->iterate through a condition while generating values
        //Two versions
        //static <T> Stream<T> iterate(T initialVal,  UnaryOperator<T> f)
        //static <T> Stream<T> iterate(T seed, Predicate<R> r, UnaryOperator<T> f)

        Stream<Integer> integerStream = Stream.iterate(0, (x)-> x+2);

        integerStream = Stream.iterate(0, (x)->x%2 ==0, (x)-> x+2).limit(10);

       // integerStream.forEachOrdered(System.out::println); ///this will print INFINITELY SO USE LIMIT ABOVE TO GENERATE

        integerStream.forEachOrdered(System.out::println);






    }
}
