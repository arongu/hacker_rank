package aron.hacker_rank.continuous_median;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortsTest {
    @Test
    public void sortTest(){
        int[] arr1 = { 1 };
        int[] arr2 = { 4, 12, 8, 5, 1, 100, 14 };
        int[] arr3 = { 4, 12, 13, 16 };

        Sorts.bubbleSort(arr1, false);
        assertEquals(1, Sorts.findMin(arr1));
        assertEquals(1, Sorts.findMax(arr1));
        assertEquals(1, Sorts.findMedian(arr1));


        Sorts.bubbleSort(arr2, false);
        assertEquals(1, Sorts.findMin(arr2));
        assertEquals(100, Sorts.findMax(arr2));
        assertEquals(8, Sorts.findMedian(arr2));

        assertEquals(12.5, Sorts.findMedian(arr3));

        Sorts.printArray(arr1);
        Sorts.printArray(arr2);
    }
}
