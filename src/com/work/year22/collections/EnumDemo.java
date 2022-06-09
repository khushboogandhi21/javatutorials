package com.work.year22.collections;
/*
Each enum class is compiled as a class being a subclass of java.lang.Enum.
Each enum constant becomes a static final constant within that class.
 */
 public enum EnumDemo {

     ENUMCONST1  ("Value 1"),
     ENUMCONST2("Value 2");

     private final String val; //If u add this at top it gives compilation error

     private EnumDemo(String val) {
         this.val = val;
     }

 }
