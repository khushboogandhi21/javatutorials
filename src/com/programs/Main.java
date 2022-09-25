package com.programs;

public class Main {
    public static String SearchingChallenge(String str) {
        // code goes here
        if(str.length() < 2)
            return "none";

        int maxLen = 1;
        int begin = 0;

        for(int i =0;i<str.length();i++){
            for(int j = i; j< str.length();j++){
                int palFlag = 1;
                for(int k= 0; k<(j-i+1)/2;k++){
                   // if(str.charAt(i+k) ! = str.charAt(j-k))
                    palFlag =0;
                }
                if(palFlag != 0 && (j-i+1) > maxLen){
                    begin =i;
                    maxLen = j - i + 1;
                }
            }
        }
        int start  = begin;
        int end = begin + maxLen-1;
        StringBuilder sbr = new StringBuilder();
        for(int k = start; k <= end; ++k ){
            //sbr.append(String.valueOf(str.charAt()[k]));
        }


        String chalTken = sbr.append("05pq2lxde6").toString();

        char[] strArr = chalTken.toCharArray();
        for(int i=2; i< strArr.length; i= i+3){
            strArr[i] ='X';
        }


        return new String(strArr);
    }

    public static void main (String[] args) {
        // keep this function call here
      //  Scanner s = new Scanner(System.in);
        System.out.print(SearchingChallenge(""));
    }
}
