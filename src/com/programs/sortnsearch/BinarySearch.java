package com.programs.sortnsearch;

/*
Binary Search is a searching algorithm used in a sorted array by repeatedly dividing the search interval in half.
The idea of binary search is to use the information that the array is sorted and reduce the time complexity to O(Log n).

When we have an algorithm with time complexity of log(n), that is incredibly good because that means as the input increases/doubles,
the number of elementary operations that we’re performing in the algorithm only increases by one.

 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr =  {5,6,11,12,13};
        int index =  binarySearchElement(12, arr);
        if(index == -1)
            System.out.println("The number is not present");
        else
            System.out.println("The number is found at index = " + index);
    }

    private static int binarySearchElement(int num, int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while(low<=high){
            int mid = low +  (high-low) / 2;

            if(arr[mid] == num)
                return mid;
            else if(arr[mid] < num)
                low = mid + 1;
            else
                high =  mid - 1;
        }
        return -1;
    }
}
