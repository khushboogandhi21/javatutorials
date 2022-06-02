package com.work.year21;

public class Product {

    String name;
    int id;
    long price;


    Product(String name,int id,long price){
        this.name = name;
        this.id = id;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
