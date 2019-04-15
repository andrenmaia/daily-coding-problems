package dcp;

import java.awt.List;
import java.lang.*;
import java.util.*;

public class Problem4Bonus {

    /*
        Return a new sorted merged list from K sorted lists, each with size N.
        For example, if we had [[10, 15, 30], [12, 15, 20], [17, 20, 32]], the 
        result should be [10, 12, 15, 15, 17, 20, 20, 30, 32].
    */

    public static class Triple implements Comparable<Triple> {
        int value;
        int listIndex;
        int elementIndex;

        public Triple(int value, int listIndex, int elementIndex){
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }

        @Override
        public int compareTo(Triple other) {
            return this.value - other.value;
        }
    }

    public static Integer[] merge(int[][] lists) {
        ArrayList<Integer> mergedLists = new ArrayList<>(lists.length);
        Queue<Triple> minheap = new PriorityQueue<>();

        // build heap
        for(int i=0; i<lists.length; i++) {
            if (lists[i].length > 0) {
                minheap.add(new Triple(lists[i][0], i, 0));
            }
        }

        // search min element and output it
        while(!minheap.isEmpty()) {
            Triple current = minheap.remove();
            mergedLists.add(current.value);

            if(current.elementIndex + 1 < lists[current.listIndex].length) {
                current = new Triple(lists[current.listIndex][current.elementIndex + 1],
                          current.listIndex,
                          current.elementIndex + 1);

                minheap.add(current);
            }
        }

        return mergedLists.toArray(new Integer[mergedLists.size()]);
    }
}