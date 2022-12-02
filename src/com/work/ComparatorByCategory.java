package com.work;

import com.work.year22.Book;

import java.util.Comparator;

public class ComparatorByCategory implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getCategory().compareTo(o2.getCategory());
    }
}
