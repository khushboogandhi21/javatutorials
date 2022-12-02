package com.work.year22;

public enum EnumCommand {  //cannot extend as it implicitly extends generic Enum<T> class, only implements allowed

    CANVAS("C"),  //Here C is the value passed to the constructor and CANVAS is the instance created
    LINE("L"),
    RECTANGLE("R"),
    BUCKET_FILL("B");

    private String enumCommand;

    EnumCommand(String enumCommand) {  //constructor cannot be public
        this.enumCommand = enumCommand;
    }

    //getter
    public String getEnumCommand() {
        return enumCommand;
    }


    //utility method
    public String getEnumInfo(){
        System.out.println(this.enumCommand);
        return this.enumCommand;
    }







}
