package com.work.year22;


import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;

public class EnumCommandDemo {

    public static void main(String args[]){
        System.out.println("EnumCommand.BUCKET_FILL : " + EnumCommand.BUCKET_FILL);

        EnumCommand[] enumArr = EnumCommand.values();
        System.out.println("getDob is : " + Arrays.asList(enumArr));


        //The java.lang.Enum.valueOf() method returns the enum constant of the specified enumtype with the specified name.
        // The name must match exactly an identifier used to declare an enum constant in this type.
        EnumCommand rectangle = EnumCommand.valueOf("RECTANGLE");
        rectangle.getEnumInfo(); //utility custom method prints this.enumCommand

        System.out.println("Ordinal of Rectangle : " + rectangle.ordinal());
        //ordinal() tells about the ordinal number(it is the position in its enum declaration, where the initial constant is assigned an ordinal of zero)
        // for the particular enum.

        //for EnumSet can only use factory methods for instantiation
        EnumSet<EnumCommand> enumSet = EnumSet.allOf(EnumCommand.class); //adds all instance values of EnumCommand
        enumSet.add(rectangle); //Since set will not add again
        for(EnumCommand enumCommand: enumSet)
            System.out.println("Printing contents of enumset: " + enumCommand);

        //another enumset factory methds

        enumSet = EnumSet.noneOf(EnumCommand.class); //empty enum
        for(EnumCommand enumCommand: enumSet)
            System.out.println("Printing contents of enumset: " + enumCommand); //will not print as set empty

        enumSet = EnumSet.of(EnumCommand.LINE, EnumCommand.CANVAS); //adds only mentioned instance values of EnumCommand
        for(EnumCommand enumCommand: enumSet)
            System.out.println("Printing Specific contents of enumset: " + enumCommand);

        //EnumMap is a Map implementation that exclusively takes Enum as its keys.
        //EnumMap doesn't allow null as keys
        EnumMap<EnumCommand, String> enumMap = new EnumMap<>(EnumCommand.class);
        enumMap.put(rectangle,"This is Rectangle Enum");
        //enumMap.put(null,""); //java.lang.NullPointerException: Cannot invoke "Object.getClass()" because "key" is null
    }
}
