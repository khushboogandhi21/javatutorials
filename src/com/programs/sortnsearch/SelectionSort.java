package com.programs.sortnsearch;

public class SelectionSort {

    public static void main(String[] args){
        int[] intArr = {12,11,13,5,6};
        selectionSort(intArr);
    }

    private static void selectionSort(int[] intArr) {

        for(int i = 0; i<intArr.length; i++){
            int minpos = i;  //consider i as min pos for each  element iteration
            for(int j = i; j < intArr.length; j++){
                if(intArr[minpos]> intArr[j]){
                    minpos = j;
                }
            }

            if(minpos != i){
                int temp = intArr[minpos];
                intArr[minpos] = intArr[i];
                intArr[i] = temp;
            }

            System.out.print("Pass " + i + ":\t");
            for(int i1=0;i1< intArr.length;i1++){
                System.out.print(intArr[i1] + "\t");
            }
            System.out.println();
        }
    }
}
