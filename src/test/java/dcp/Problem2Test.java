package dcp;

import org.junit.jupiter.api.Test;

import dcp.Problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class Problem2Test {

    @Test
    public void defaultProblemInputSorted_multiplication() {

        int[] in = new int[] { 1,2,3,4,5 };

        int[] actual = Problem2.multiplication(in);

        assertArrayEquals(actual, new int[] {120, 60, 40, 30, 24});
    }

    @Test
    public void defaultProblemInputReverseSorted_multiplication() {

        int[] in = new int[] { 3,2,1 };

        int[] actual = Problem2.multiplication(in);

        assertArrayEquals(actual, new int[] {2,3,6});
    }

    @Test
    public void defaultProblemInputNotSorted_multiplication() {

        int[] in = new int[] { 4,2,5,1,3 };

        int[] actual = Problem2.multiplication(in);

        assertArrayEquals(actual, new int[] {30, 60, 24, 120, 40});
    }

    @Test
    public void inputSorted_NoMultiplication() {

        int[] in = new int[] { 1,2,3,4,5 };

        int[] actual = Problem2.leftAndRightSubtraction(in);

        assertArrayEquals(actual, new int[] {120, 60, 40, 30, 24});
    }

    @Test
    public void littleInputSorted_NoMultiplication() {

        int[] in = new int[] { 1,2,3 };

        int[] actual = Problem2.leftAndRightSubtraction(in);

        assertArrayEquals(actual, new int[] {6,3,2});
    }

    @Test
    public void littleInputNotSorted_NoMultiplication() {

        int[] in = new int[] { 3,1,2 };

        int[] actual = Problem2.leftAndRightSubtraction(in);

        assertArrayEquals(actual, new int[] {2,6,3});
    }

    @Test
    public void inputNotSorted_NoMultiplication() {

        int[] in = new int[] { 5,2,3,1,4 };

        int[] actual = Problem2.leftAndRightSubtraction(in);

        assertArrayEquals(actual, new int[] { 24, 60, 40, 120, 30 });
    }

    @Test
    public void inputWithOneZeroAtBegining_NoMultiplication() {

        int[] in = new int[] { 0,2,3,1,4 };

        int[] actual = Problem2.leftAndRightSubtraction(in);

        assertArrayEquals(actual, new int[] { 24, 0, 0, 0, 0 });
    }

    @Test
    public void inputWithOneZeroAtTheEnd_NoMultiplication() {

        int[] in = new int[] { 5,2,3,1,4,0 };

        int[] actual = Problem2.leftAndRightSubtraction(in);

        assertArrayEquals(actual, new int[] { 0, 0, 0, 0, 0, 120 });
    }

    @Test
    public void inputWithOneZeroInTheMiddle_NoMultiplication() {

        int[] in = new int[] { 5,2,3,0,1,4 };

        int[] actual = Problem2.leftAndRightSubtraction(in);

        assertArrayEquals(actual, new int[] { 0, 0, 0, 120, 0, 0 });
    }


    @Test
    public void inputWithMoreThanZero_NoMultiplication() {

        int[] in = new int[] { 5,0,2,3,0,1,4 };

        int[] actual = Problem2.leftAndRightSubtraction(in);

        assertArrayEquals(actual, new int[] { 0, 0, 0, 0, 0, 0, 0 });
    }

}