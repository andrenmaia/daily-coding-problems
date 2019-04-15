package dcp;

import java.util.*;

public class Problem1 { 

    /*
        This problem was recently asked by Google.

        Given a list of numbers and a number k, return whether any two numbers from the 
        list add up to k.

        For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

        Bonus: Can you do this in one pass?
    */

    /*
    
    Inputs:
    
        - Array of integers, positives and negative;
        - Data not sorted;
        
    Ideas
    
        1. traverse array and test for each element if the sums is equal the target value
            - time: O(N²) --> each element compared with each other
            - space: O(1)
            
            This is not true, because a can not use the same element twice. This idea not 
            works.
            
            
            
        2. create a hashtable with complements of each number, and check for each one if I already see
            a complement value during traversing
            - time: O(N) traverse, analyse, store and hashtable
            - space: O(N) --> the complements of each number from array
    */
    
    
    public int[] twoSum(int[] nums, int target) {
        
        // complement -> index from array.
        Map<Integer, Integer> store = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            int current = nums[i];
            Integer complementIndexFound = store.get(current);
            
            if (complementIndexFound != null) {
                return new int[] { complementIndexFound, i };
            } else  {
                int complement = target - nums[i];
                store.put(complement, i);
            }
        }
        
        return null;
    }

}