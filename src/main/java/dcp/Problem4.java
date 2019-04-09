package dcp;

import java.util.Arrays;

public class Problem4 {

    /*
     * This problem was asked by Stripe.
     * 
     * Given an array of integers, find the first missing positive integer in linear
     * time and constant space. In other words, find the lowest positive integer
     * that does not exist in the array. The array can contain duplicates and
     * negative numbers as well.
     * 
     * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0]
     * should give 3.
     * 
     * You can modify the input array in-place.
     */

    /*
     * Contraints/Inputs:
     *      - Array of integers
     *      - Not sorted
     *      - Positive and negatives
     *      - Can contain duplicates
     *      - Should be linear and no consume extra spaces
     *      - Can modify input in-place
     * 
     * 
     * Ideas:
     * 
     * 1. Use a treeset to store positive elements, get the min and check if there 
     * are gaps of 1 positions.
     *      time: O(n)
     *      space: O(n) -- fail with constraints
     * 
     * 2. Clean up array with out of bound elements, sort it in-place and traverse 
     * it to find first missing positive
     *      time: O(n)
     *      space:O O(1)
     */


     public static int findFirstMissingPositive(int[] in) {

        // clean up array with useless values
        for(int i=0; i<in.length; i++) {
            if (in[i] < 0 || in[i]>in.length-1) {
                in[i] = 0;
            }
        }

        // put elements in correct places
        for(int i=0; i<in.length; i++) {
            int current = in[i];
            if (current != i) {
                int temp = in[current];
                in[current] = current;
                in[i] = temp;
            }
        }

        // [3, 0, 0, 1]
        // [1, 0, 0, 3]
        // [0, 1, 0, 3]
        // [0, 1, 0, 3]

        // Search for gaps
        int i=0;
        for(; i<in.length; i++) {
            if (in[i] != i && i>0 && in[i] == 0) {
                break;
            } 
        }

         return i;
     }
}