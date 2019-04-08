package dcp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Problem1Test {

    @Test
    public void defaultProblemSample() {

        int[] input = new int[] { 10, 15, 3, 7 };
        int target = 17;

        int[] actual = new Problem1().twoSum(input, target);

        assertArrayEquals(actual, new int[] {0,3});
    }

    @Test
    public void basicSample() {

        int[] input = new int[] { 2, 7, 11, 15 };
        int target = 9;

        int[] actual = new Problem1().twoSum(input, target);

        assertArrayEquals(actual, new int[] {0,1});
    }
}