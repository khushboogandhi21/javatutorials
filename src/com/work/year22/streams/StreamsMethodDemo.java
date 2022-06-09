package com.work.year22.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsMethodDemo {

    public static void main(String[] args){
        List<String> stringList = Arrays.asList("Hello","world","am","here","and","happy","on","my","own");
        List<String> resultList = stringList.stream().filter(x->x.indexOf("o") != -1).collect(Collectors.toList()) ; //takes predicate
        System.out.println("filter: resultList" + resultList);  //[Hello, world, on, own]

        resultList = stringList.stream().distinct().collect(Collectors.toList());
        System.out.println("distinct: resultList" + resultList);

        //filter will remove all items from the stream that do not satisfy the condition.
        //    VS
        //takeWhile will abort the stream on the first occurrence of an item which does not satisfy the condition.
        resultList = stringList.stream().takeWhile(x->x.indexOf("o") != -1).collect(Collectors.toList());
        System.out.println("takeWhile: resultList" + resultList); //[Hello, world]


        //The takewhile() method of Stream API accepts all values until predicate returns false whereas
        // dropWhile() method of Stream API drops all values until it matches the predicate.
        resultList = stringList.stream().dropWhile(x->x.indexOf("o") != -1).collect(Collectors.toList()); //jo match hota hai woh drop hoga
        System.out.println("dropWhile: resultList" + resultList);

        //Returns: an Optional describing the first element of this stream, or an empty Optional if the stream is empty
        Optional<String> strOpt = stringList.stream().findFirst();
        System.out.println("strOpt" + strOpt);

        strOpt = stringList.stream().findAny();
        System.out.println("strOpt" + strOpt);

        boolean boolResult = stringList.stream().allMatch(x->x.indexOf("o") != -1) ; //takes predicate
        System.out.println("boolResult = " + boolResult);  //false since all elements don't match
        //Similarly anyMatch

        boolResult = stringList.stream().anyMatch(x->x.indexOf("o") != -1) ; //takes predicate
        System.out.println("boolResult = " + boolResult);  //true

    }

}
