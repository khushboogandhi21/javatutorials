package com.work.year22.designpatterns;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final  class ImmutableDemo {

    private final String name;
    private final  int age;
    private final Timestamp dob;
    private final List<String> friends;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Timestamp getDob() {
        return (Timestamp) dob.clone(); //not required as clone does the job new Date(d.getTime());
    }

    public List<String> getFriends() {

        // Collections.unmodifiableList() will return read only view and adding anything will return in UnsupportedOperationException
        List<String> friendsDeepCopy = new ArrayList<>();
        for(String str : friends)
            friendsDeepCopy.add(str);

        return friendsDeepCopy;
    }

    public ImmutableDemo(String name, int age, Timestamp dob, List<String> friends) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.friends = friends;
    }


    public static void main(String args[]){
        ImmutableDemo immutableDemo = new ImmutableDemo("Khushboo", 21,
                Timestamp.valueOf( LocalDateTime.of(1990,7,23,5,12,00)), Arrays.asList("Jack","Jill"));

        Timestamp dateClone = immutableDemo.getDob();

        System.out.println("getDob is : " +immutableDemo.getDob());
        System.out.println("getFriends is : " +immutableDemo.getFriends());

        dateClone.setTime( Timestamp.valueOf( LocalDateTime.of(1981,7,23,8,34,00)).getTime());
        System.out.println("getDob is : " + immutableDemo.getDob());
        System.out.println("dateClone is : " + dateClone);

        }

}
