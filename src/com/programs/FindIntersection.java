package com.programs;
/*
Find Intersection
Have the function FindIntersection(strArr) read the array of strings stored in
strArr which will contain 2 elements: the first element will represent a list of
comma-separated numbers sorted in ascending order, the second element will represent a second list of comma-separated numbers (also sorted).
 Your goal is to return a comma-separated string containing the numbers that occur in elements of strArr in sorted order.
 If there is no intersection, return the string false.
Examples
Input: new String[] {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"}
Output: 1,4,13
Input: new String[] {"1, 3, 9, 10, 17, 18", "1, 4, 9, 10"}
Output: 1,9,10
 */
public class FindIntersection {
    public static String FindIntersection(String[] strArr) {
        // code goes here
        String maxStr = strArr[0];
        String minStr = strArr[1];

        if(strArr[0].length()<strArr[1].length()){
            maxStr = strArr[1];
            minStr = strArr[0];
        }

        String[] maxStrArr = maxStr.split(",");
        String[] minStrArr = minStr.split(",");

        StringBuilder sbr =  new StringBuilder();

        boolean flag = false;

        for(int i = 0; i<minStrArr.length;i++){
            for(int j =0; j<maxStrArr.length;j++){
                //if(maxStr.contains(minStrArr[i])){  //if(maxStr.contains(minStrArr[i])){ DONT USE IT DIDNT WORK for 10 and 1 match
                if(minStrArr[i].trim().equals(maxStrArr[j].trim())){
                    sbr.append(minStrArr[i].trim()).append(",");
                    flag = true;
                }
            }
        }
        if(flag)
            return sbr.substring(0,sbr.length()-1);
        else
            return "false";
    }

    public static void main (String[] args) {
        // keep this function call here
        //Scanner s = new Scanner(System.in);
        System.out.print(FindIntersection(new String[] {"2, 5, 7, 10, 11, 12", "2, 7, 8, 9, 10, 11, 15"}));
        //new String[] {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"}
        //new String[] {"1, 2, 3, 4, 5", "6, 7, 8, 9, 10"}
    }
}
