package dcp;

import java.util.*;

public class Problem2 {

    /*
        This problem was asked by Uber.

        Given an array of integers, return a new array such that each element at index 
        i of the new array is the product of all the numbers in the original array 
        except the one at i.

        For example, if our input was [1, 2, 3, 4, 5], the expected output would be 
        [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would 
        be [2, 3, 6].

        Follow-up: what if you can't use division?
    */

    /*

    [1,2,3,4,5] -> [120, 60, 40, 30, 24]
    120 = 2*3*4*5 --> fac(0) * (fac(5) / fac(1))
    60  = 1*3*4*5 --> fac(1) * (fac(5) / fac(2))
    40  = 1*2*4*5 --> fac(2) * (fac(5) / fac(3))
    30  = 1*2*3*5 --> fac(3) * (fac(5) / fac(4))
    24  = 1*2*3*4 --> fac(4) * (fac(5) / fac(5))


    Ideas

        1. Use dynamic programming to create a factorial table and use use it to compose the return array.

            [1,2,3,4,5] -> [120, 60, 40, 30, 24]
            120 = 2*3*4*5 --> fac(0) * (fac(5) / fac(1))
            60  = 1*3*4*5 --> fac(1) * (fac(5) / fac(2))
            40  = 1*2*4*5 --> fac(2) * (fac(5) / fac(3))
            30  = 1*2*3*5 --> fac(3) * (fac(5) / fac(4))
            24  = 1*2*3*4 --> fac(4) * (fac(5) / fac(5))

        2. Multiply and division 

            a. multiply all elements from array
            b. divide total multiplication by current position
                total = 120

                a * b * c * d / c = a * b * d
                total/1 = 120/1 = 120
                total/2 = 120/2 = 60
                total/3 = 120/3 = 40
                total/4 = 120/4 = 30
                total/5 = 120/5 = 24

        3. No division

            left  = 1*2*3*4*5 = 1,2,6,20,100
            right = 5*4*3*2*1 = 20,60,120,1

            1 -> left(i-1) * right(i+1) -> 1 * 60
    
    */

    public static int[] multiplication(int[] input) {

        Map<Integer, Integer> index = new HashMap<>();

        int total = 1;

        for(int i=0; i<input.length; i++) {
            total *= input[i];

            index.put(input[i], i);
        }

        int[] output = new int[input.length];

        for(int i=0; i<input.length; i++) {

            int current = input[i];
            output[index.get(current)] = total/current;
        }

        return output;
    }

    public static int[] leftAndRightSubtraction(int[] input) {

        int[] left = new int[input.length];
        int[] right = new int[input.length];
        int[] output = new int[input.length];

        int totalLeft = 1;
        int totalRight = 1;

        for(int i=0, j=input.length-1; i<input.length; i++, j--) {
            totalLeft *= input[i];
            totalRight *= input[j];
            left[i] = totalLeft;
            right[j] = totalRight;
        }

        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));

        output[0] = right[1];

        int i=1;
        for(; i< input.length-1; i++ ) {
            output[i] = left[i-1] * right[i+1];
        }

        output[input.length-1] = left[i-1];

        return output;
    }
}