package com.programs.sortnsearch;

public class BubbleSort {


    public static void main(String[] args){
        int[] intArr = {5, 1, 4, 2, 8};
        bubbleSort(intArr);
    }
    private static void bubbleSort(int[] intArr) {


        for(int i = 0;i< intArr.length - 1 ; i++){
            boolean isSwapped = false;
            for(int j = 0;j < intArr.length - 1 -i ; j++){  //no need to swap last  element
                if(intArr[j] > intArr[j+1]){
                    int temp = intArr[j];
                    intArr[j] = intArr[j+1];
                    intArr[j+1] = temp;
                    isSwapped = true;   //optimization
                }
            }

            System.out.print("Pass " + i + ":");
            for(int i1= 0; i1< intArr.length;i1++){
                System.out.print("\t " + intArr[i1]);
            }
            System.out.println();

            if(!isSwapped)
                break;
        }
    }
}
