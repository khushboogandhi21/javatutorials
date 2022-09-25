package com.programs;

import java.util.*;
import java.util.stream.Stream;

/*
Longest Word
Have the function LongestWord(sen) take the sen parameter being passed and return the longest word in the string. If there are two or more words that are the same length, return the first word from the string with that length. Ignore punctuation and assume sen will not be empty. Words may also contain numbers, for example "Hello world123 567"
Examples
Input: "fun&!! time"
Output: time
Input: "I love dogs"
Output: love
 */
public class LongestWord {
    public static String LongestWord(String sen) {
        // code goes here
        String[] senArr = sen.split(" ");
       Stream senStream = Arrays.stream(senArr);

        Optional<String> maxSen = senStream.max(Comparator.comparing(String :: length));
        return maxSen.get();

        /*int longestIndex = 0;
        String longestWord = "";

        for (int i = 0; i < senArray.length; i++) {
            //System.out.println(senArray[i]);
            if (senArray[i].length() > longestIndex) {
                longestWord = senArray[i];
                longestIndex = senArray[i].length();
            }
        }
        return longestWord;*/
       // return sen;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LongestWord("I love dogs"));
    }



}
