package com.work.year22.collections;

import java.util.EnumMap;
import java.util.IdentityHashMap;

public class MapDemo {


    public static void main(String[]args) {

        IdentityHashMap<Integer, String> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(10, "Ten");
        identityHashMap.put(20, "Twenty");
        identityHashMap.put(10, "Duplicate Ten");
        System.out.println("IdentityHashMap =" + identityHashMap);  //Result -> {10=Duplicate Ten, 20=Twenty}

        // EnumMap ordered in natural order Faster than hashmap doesn't allow null keys
        EnumMap<EnumDemo,Integer> enumMap = new EnumMap<EnumDemo, Integer>(EnumDemo.class); //class of the key
        enumMap.put(EnumDemo.ENUMCONST1, 111);
        enumMap.put(EnumDemo.ENUMCONST2, 222);
        System.out.println("EnumMap =" + enumMap.get(EnumDemo.ENUMCONST1));


    }
}
