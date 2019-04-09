package dcp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import dcp.Problem4;

public class Problem4Test {

    @Test
    public void defaultCase1() {
        int[] in = new int[] {3, 4, -1, 1};
        int actual = Problem4.findFirstMissingPositive(in);

        assertEquals(2, actual);
    }

    @Test
    public void defaultCase2() {
        int[] in = new int[] {1, 2, 0};
        int actual = Problem4.findFirstMissingPositive(in);

        assertEquals(3, actual);
    }

    @Test
    public void bigNumber() {
        int[] in = new int[] {100,200,300};
        int actual = Problem4.findFirstMissingPositive(in);

        assertEquals(1, actual);
    }

    @Test
    public void bigNumberWithNegatives() {
        int[] in = new int[] {-100, 200, -1, 100, -3,300};
        int actual = Problem4.findFirstMissingPositive(in);

        assertEquals(1, actual);
    }

    @Test
    public void bigNumberWithNegativesAndSmallSequence() {
        int[] in = new int[] {-100, 200,1, -1, 100, 2, 4, -3,300};
        int actual = Problem4.findFirstMissingPositive(in);

        assertEquals(3, actual);
    }
}