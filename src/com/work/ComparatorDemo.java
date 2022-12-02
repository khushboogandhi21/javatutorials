package com.work;

import com.work.year22.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorDemo {

    public static void main(String args[]) {

       List<Book> bookList = new ArrayList<>();
       bookList.add(new Book(1,"World of Nature","Geography"));
       bookList.add(new Book(3,"Book of stories","Fiction"));
       bookList.add(new Book(2,"Book of Comedy","Fiction"));

       //use comparable
       //compares by id
       bookList.stream().sorted().forEach(System.out::println);
        System.out.println("-----------------");

        //OR
        bookList.stream().sorted(Comparator.comparing(book -> book.getId())).forEach(System.out::println);
        System.out.println("-----------------");

        //use comparator
       // compares by category
        bookList.stream().sorted(new ComparatorByCategory()).forEach(System.out::println);
        System.out.println("-----------------");

        //OR without using streams
        bookList.sort(Comparator.comparing((book) ->  book.getBookName())); //sort by name
        bookList.stream().forEach(System.out::println);
        System.out.println("-----------------");

        bookList.sort(Comparator.comparing((book) ->  book.getBookName(), (x,y)->y.compareTo(x))); //Reverse sort by name ...key + function implementation
        bookList.stream().forEach(System.out::println);
        System.out.println("-----------------");



    }
}
