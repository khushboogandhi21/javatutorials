package com.programs.sortnsearch;

/**
 * The main difference between quicksort and merge sort is that
 * the quicksort sorts the elements by comparing each element with an element called a pivot
 * while merge sort divides the array into two sub arrays again and again until one element is left.
 */
public class MergeSort {

    public static void main(String[] args){

        int[] intArr = {5, 1, 4, 2, 8};
        mergeSort(intArr,0,intArr.length - 1);
        System.out.println("Sorted Array is : ");
        printArray(intArr);
    }

    private static void mergeSort(int[] intArr, int low, int high) {
        if(low<high){
            int mid = low + (high-low)/2;

            mergeSort(intArr,low, mid );  //NO mid -1 as we are not doing binary search here we need to include all elements
            mergeSort(intArr, mid + 1, high);

            //MERGE all the sorted arrays
            merge(intArr,low,mid,high);
        }
    }

    private static void merge(int[] intArr, int low, int mid, int high) {

        //get the two sub array size
        int size1 = mid - low + 1; //+1 for exclusivity
        int size2 = high - mid;  //+1 NOT required as second array start with mid+1

        //create temp arrays
        int[] tempArr1 = new int[size1];
        int[] tempArr2 = new int[size2];

        //copy data in temp arrays
        for(int i=0;i<size1;i++){  //can't have i=low as low<size1 may not be valid
            tempArr1[i] = intArr[i + low];
        }

        for(int i=0;i<size2;i++){
            tempArr2[i] = intArr[i + mid + 1];
        }

        //merge two sub arrays
        int i=0,j=0,k=low; //IMP
        while(i<size1 && j<size2){
            if(tempArr1[i]<tempArr2[j]){
                intArr[k] = tempArr1[i]; //overwrite elements in original array
                i++;
            }else{
                intArr[k] = tempArr2[j];
                j++;
            }
            k++;
        }

        //copy remaining elements
        while(i<size1){
            intArr[k++] = tempArr1[i++];
        }

        while(j<size2){
            intArr[k++] = tempArr2[j++];
        }

    }


    public static void printArray(int[] intArr){
        for(int i1=0;i1< intArr.length;i1++){
            System.out.print(intArr[i1] + "\t");
        }
        System.out.println();
    }
}
