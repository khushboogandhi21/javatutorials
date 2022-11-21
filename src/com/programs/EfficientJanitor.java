package com.programs;

import java.util.Arrays;

/**
 * The janitor at Hacker High School is insanely efficient. By the end of
 * each day, all of the waste from the trash cans in the school has been
 * shifted into plastic bags which can carry waste weighing between 1.01
 * pounds and 3.00 pounds. All of the plastic bags must be dumped into
 * the trash cans outside the school. The janitor can carry at most 3.00
 * pounds at once. One trip is described as selecting a few bags which
 * together don't weigh more than 3.00 pounds, dumping them in the
 * outdoor trash can and returning to the school. The janitor wants to
 * make minimum number of trips to the outdoor trash can. Given the
 * number of plastic bags, n, and the weights of each bag, determine the
 * minimum number of trips if the janitor selects bags in the optimal way.
 *
 * For example, given n = 6 plastic bags weighing weight = [1.01, 1.99, 2.5,
 * 1.5, 1.01], the janitor can carry all of the trash out in 3 trips: [1.01 +
 * 1.99 , 2.5, 1.5 + 1.01].
 *
 * Constraints:
 * 1 ≤ n ≤ 1000
 * 1.01 ≤ weight[i] ≤ 3.0
 * Input
 */
public class EfficientJanitor {
    public static void main(String args[]){

        double[] bagWeights =  {1.01, 1.99, 2.5,1.5, 1.01};
        System.out.println("result = " + efficientJanitor(6,bagWeights));
    }

    private static int efficientJanitor(int noOfBags,double[] bagWeights) {

        int tripCount = 0;
        int startPointer = 0, endPointer = bagWeights.length -1;

        //2 pointer solution
        Arrays.sort(bagWeights);

        while(startPointer < endPointer){
            if(bagWeights[startPointer] + bagWeights[endPointer] <= 3.0){
                startPointer++;
                endPointer--;
                tripCount++;
            }else{
                endPointer--; //since endPointer points to higher weights
                tripCount++;
            }
        }

        return tripCount;
    }
}
