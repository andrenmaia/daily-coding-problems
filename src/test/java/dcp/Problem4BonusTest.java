package dcp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Problem4BonusTest {

    @Test
    public void happyCase() {
        int[][] list = new int[][] {
            {10, 15, 30}, 
            {12, 15, 20}, 
            {17, 20, 32}
        };

        Integer[] actual = Problem4Bonus.merge(list);

        assertArrayEquals(actual, new Integer[] {10, 12, 15, 15, 17, 20, 20, 30, 32});
    }

    @Test
    public void emptyLists() {
        int[][] list = new int[][] {};

        Integer[] actual = Problem4Bonus.merge(list);

        assertArrayEquals(actual, new Integer[] {});
    }

    @Test
    public void listsWithEmptyLists() {
        int[][] list = new int[][] { {}, {}, {}};

        Integer[] actual = Problem4Bonus.merge(list);

        assertArrayEquals(actual, new Integer[] {});
    }

    @Test
    public void listsConstainsEmptyAndNonEmptyLists() {
        int[][] list = new int[][] { {}, {1}, {1,2}};

        Integer[] actual = Problem4Bonus.merge(list);

        assertArrayEquals(actual, new Integer[] {1,1,2});
    }

    @Test
    public void listsContainsOneListOfOneElement() {
        int[][] list = new int[][] { {1}};

        Integer[] actual = Problem4Bonus.merge(list);

        assertArrayEquals(actual, new Integer[] {1});
    }

    @Test
    public void listsContainsListsOfVaryingSize() {
        int[][] list = new int[][] { {1}, {1,3,5}, {1,10,20, 30, 40}};

        Integer[] actual = Problem4Bonus.merge(list);

        assertArrayEquals(actual, new Integer[] {1,1,1,3,5,10,20,30,40});
    }

}