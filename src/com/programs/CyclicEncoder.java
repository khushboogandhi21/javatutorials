package com.programs;
/*
Asked in Mavericks consulting PP round

Given a string s consisting of letters only and an integer n,
The task is to replace every character of the given string by a character which is n times more than it.
If the letter exceeds 'z', then start checking from 'a' in a cyclic manner.

Example 1:
Input: s = "abc", n = 3
Output: "def"
a is moved by 3 times which results in character d
b is moved by 3 times which results in character e
c is moved by 3 times which results in character f

Example 2:
Input: s = "ace", n = 28
Output: "ceg"
a is moved 25 times, z is reached. Then the 26th character will be a, 27th b, 28th  is c.
c is moved 23 times, z is reached. 28-th is e.
e is moved 21 times, z is reached. 28-th is g.

1 < s.length < 5,000
0 <= n <= 10^5==>use Math.pow(5, 3)

Write an algorithm to execute the above task.
 */

public class CyclicEncoder {


    public static void main(String args[]){
        String str = "pxd";
        double num = 50;   // Math.pow(10,5)  use double data type for large int
        str = str.toLowerCase();
        char[] charArr =  str.toCharArray();
        if(validateInput(str,num)){
            encodeString(charArr, num);
        }

        convertCharToASCII();

    }

    private static boolean validateInput(String str, double num) {
        if(str.length() < 1 || str.length()>5000)
            return false;

        if(num < 0 || num > Math.pow(10,5))
            return false;

        return true;
    }

    public static  void encodeString(char[] charArr, double num ){

        StringBuilder sbr  = new StringBuilder();

        for(int i = 0; i< charArr.length; i++){


           /*int value = Character.getNumericValue( charArr[i]);
           value+num; *///doesn't work as it will increment int value

           /* if(num > 25 ){
                num = num - 26;
            }*/ // will only work for Higher values of num where more than one cycle is required

            char charVal ;

            /*
            int dupnum = num;
            if(charArr[i] + num > 122){  //if exceeds z
               num = num % 26; //doesn't work
               num = num - (122 - charArr[i]); //after z we need to again start from a so 122-char will give us remaining steps that remaining we deduct from num, so we can start adding that from a
               num = num % 26; //skip unnecessary cycles
               charVal = (char)(96+ num);
            }else{
                charVal = (char)(charArr[i]+ num);
            }
            num = dupnum;
            */

            // OR

            double rem  = num % 26;  //skip unnecessary cycles
            if(charArr[i] + rem > 122){ //if exceeds z
                rem = rem - (122 - charArr[i]);
                charVal = (char)(96+ rem);  //start from 96 not 97 since addition is inclusive
            }else{
                charVal = (char)(charArr[i]+ rem);
            }


           System.out.println("value is :" +charVal);
           sbr.append((char)charVal);


        }
        System.out.println("Encoded String is :" + sbr.toString());
    }

    //for reference
    //Char to ascii equivalent and vice versa
    public static void convertCharToASCII(){
        String str = "ace";

        //the ASCII value of A-Z are from 65 to 90.
        // a-z are from 97 to 122.

        //Char to ascii
        char character = str.charAt(0); // This gives the character 'a'
        int ascii = (int) character; // ascii is now 97.
        System.out.println("ascii value of "+ character + " is :" +ascii);

        // ascii to Char
        character = (char)ascii;
        System.out.println("character value is : " +character);

        //how to add a number to the ascii value of a char in java

        character = (char)(character + 1);

        //OR

        character = (char)++ascii;


        System.out.println("Incremented value is : " +character);

    }
}
