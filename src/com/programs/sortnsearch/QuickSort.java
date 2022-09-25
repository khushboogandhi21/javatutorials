package com.programs.sortnsearch;

public class QuickSort {

    public static void main(String[] args){

        int[] intArr = {5, 1, 4, 2, 8};
        quickSort(intArr,0,intArr.length - 1);
        printArray(intArr, -1);
    }

    private static void quickSort(int[] intArr, int low, int high) {
        if(low<high){   //IMP
            int pivotActualPosition = partition(intArr,low,high);   //selecting last element as pivot

            quickSort(intArr, low, pivotActualPosition - 1 );
            quickSort(intArr, pivotActualPosition  + 1, high);

            printArray(intArr, pivotActualPosition);
        }

    }

    private static int partition(int[] intArr, int low, int high) {
        int pivot  = intArr[high];

        int pivotActualPosition = low -1;  //initially assumed position which will increase as no of smaller elements increase

        for(int j = low ; j <=high - 1; j++){   // j < high ==>leave the last element as its pivot
            if(intArr[j] < pivot){
                pivotActualPosition++;
                swap(intArr, pivotActualPosition, j);
            }
        }
        //place the pivot at its original position
        swap(intArr, pivotActualPosition + 1, high);

        return pivotActualPosition + 1 ;
    }

    private static void swap(int[] intArr, int pivotActualPosition, int j) {
        int temp = intArr[pivotActualPosition];
        intArr[pivotActualPosition] = intArr[j];
        intArr[j] = temp;
    }

    public static void printArray(int[] intArr, int pivot){
        System.out.print("Pivot  " + pivot + ":\t");
        for(int i1=0;i1< intArr.length;i1++){
            System.out.print(intArr[i1] + "\t");
        }
        System.out.println();
    }
}
