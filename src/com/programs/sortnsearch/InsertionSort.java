package com.programs.sortnsearch;
/*
Insertion sort will swap places while comparing from its current position
to the first index zero in each iteration

Time Complexity: O(N^2)--> n square  -->The two nested loops are an indication that we are dealing with quadratic effort, meaning with time complexity of O(n²)*.
This is the case if both the outer and the inner loop count up to a value that increases linearly with the number of elements.

Auxiliary Space: O(1) ->The space complexity of Insertion Sort is constant since we do not need any additional memory except
for the loop variables i and j and the auxiliary variable elementToSort.
This means that – no matter whether we sort ten elements or a million – we always need only these three additional variables.
Constant complexity is noted as O(1).
 */
public class InsertionSort {

    public static void main(String[] args){
        int[] intArr = {12,11,13,5,6};

        for(int i=1;i< intArr.length;i++){
            for(int j= i;j>0;j--){
                if(intArr[j] < intArr[j-1]){
                    int temp = intArr[j];
                    intArr[j]  = intArr[j-1];
                    intArr[j-1] = temp;
                }
            }
            System.out.print("Pass " + i + ":\t");
            for(int i1=0;i1< intArr.length;i1++){
                System.out.print(intArr[i1] + "\t");
            }
            System.out.println();
        }

    }
}

