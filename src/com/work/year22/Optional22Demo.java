package com.work.year22;

import com.work.year22.streams.StreamsCreationDemo;


import java.util.Optional;

public class Optional22Demo {

    public static void main(String[]args){

        StreamsCreationDemo obj = new StreamsCreationDemo();

        Optional<StreamsCreationDemo> spliteratorOptional = null;
        StreamsCreationDemo spliteratorObj = null;

        try {
            spliteratorOptional = Optional.empty();  //empty
            System.out.println("empty demo=" + spliteratorOptional.get());  //throws java.util.NoSuchElementException
        }catch(Exception ex){
            ex.printStackTrace();
        }
        try{
            spliteratorOptional = Optional.ofNullable(spliteratorObj);  //returns empty if object is null
            System.out.println("ofNullable demo=" + spliteratorOptional.get());  //throws java.util.NoSuchElementException
        }catch(Exception ex){
            ex.printStackTrace();
        }

        try{
            spliteratorOptional = Optional.of(spliteratorObj);  //throws null pointer if obj is null
            System.out.println("of demo=" + spliteratorOptional.get());  //throws null pointer
        }catch(Exception ex){
            ex.printStackTrace();
        }

        spliteratorObj = new StreamsCreationDemo();
        try {
            spliteratorOptional = Optional.empty();  //empty
            System.out.println("empty demo=" + spliteratorOptional.get());  //throws java.util.NoSuchElementException
        }catch(Exception ex){
            ex.printStackTrace();
        }
        try{
            spliteratorOptional = Optional.ofNullable(spliteratorObj);  //returns empty if object is null
            System.out.println("ofNullable demo=" + spliteratorOptional.get());  //returns value since its present
        }catch(Exception ex){
            ex.printStackTrace();
        }

        try{
            spliteratorOptional = Optional.of(spliteratorObj);  //throws null pointer if obj is null
            System.out.println("of demo=" + spliteratorOptional.get());  //returns value since its present
        }catch(Exception ex){
            ex.printStackTrace();
        }

        System.out.println("Is value present = " + spliteratorOptional.isPresent());
        spliteratorOptional.ifPresent((x) -> {System.out.println("value is Present ="+ x);});  //arg is Consumer Functional Interface [accept(T t) method]

        //arg is Consumer Functional Interface, Runnable Interface that specifies action to perform if empty JAVA 9
       // spliteratorOptional.ifPresentOrElse((x) -> {System.out.println("value is Present="+ x);}, () -> {System.out.println("value is Empty");});

    }

    //Optional<String> strOpt = Optional.ofNullable("Hello").orElseThrow() ; //orElseThrow(RuntimeException::new);  // DIDNT WORK since final return type is string not optional
    Optional<String > strOpt = Optional.ofNullable("Hello");
    String str = strOpt.orElseThrow(RuntimeException::new);




}
