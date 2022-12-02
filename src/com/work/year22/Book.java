package com.work.year22;

public class Book implements Comparable<Book>{

    int id;
    String bookName;

    String category;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }



    public Book(int id, String bookName, String category) {
        this.id = id;
        this.bookName = bookName;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int compareTo(Book book) {
        return this.getId() - book.getId();
    }
}
